package objectPool;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class ObjectPool<K> {

	private ConcurrentLinkedQueue<K> pool;

	private ScheduledExecutorService executorService;

	public ObjectPool(final int minSize) {
		pool = new ConcurrentLinkedQueue<K>();

		for (int i = 0; i < minSize; i++) {
			pool.add(createObject());
		}
	}

	public ObjectPool(final int minSize, final int maxSize, final long checkInterval) {

		this(minSize);

		executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				int size = pool.size();
				if (size < minSize) {
					int sizeToBeAdded = minSize - size;
					for (int i = 0; i < sizeToBeAdded; i++) {
						pool.add(createObject());
					}
				} else if (size > maxSize) {
					int sizeToBeRemoved = size - maxSize;
					for (int i = 0; i < sizeToBeRemoved; i++) {
						pool.poll();
					}
				}
			}
		}, checkInterval, checkInterval, TimeUnit.SECONDS);
	}

	public K checkOut() {
		K object = pool.poll();
		if (null == object) {
			object = createObject();
		}

		return object;
	}

	public void checkIn(K object) {
		if (null == object) {
			return;
		}

		this.pool.offer(object);
	}

	public void shutdown() {
		if (null != executorService) {
			executorService.shutdown();
		}
	}

	protected abstract K createObject();

}
