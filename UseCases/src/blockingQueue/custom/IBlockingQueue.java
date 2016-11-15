package blockingQueue.custom;

public interface IBlockingQueue<E> {

	boolean offer(E e);

	void put(E e) throws InterruptedException;

	E take() throws InterruptedException;

}
