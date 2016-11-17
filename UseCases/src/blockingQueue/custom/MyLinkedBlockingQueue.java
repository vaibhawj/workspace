package blockingQueue.custom;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// TODO To complete using condition
public class MyLinkedBlockingQueue<E> implements IBlockingQueue<E> {

	private Node<E> head;
	private Node<E> last;
	private int capacity;
	private volatile AtomicInteger size;
	private ReentrantLock lock;
	private Condition notFullCondition;
	private Condition notEmptyCondition;

	public MyLinkedBlockingQueue(int capacity) {
		this.capacity = capacity;
		this.size = new AtomicInteger();
		lock = new ReentrantLock();
		notFullCondition = lock.newCondition();
		notEmptyCondition = lock.newCondition();
	}

	private static class Node<E> {

		E item;
		Node<E> next;

		public Node(E x) {
			this.item = x;
		}
	}

	/**
	 * Adds to the queue if size is below capacity and returns true otherwise
	 * return false
	 */
	@Override
	public boolean offer(E e) {
		if (this.size.get() == capacity) {
			return false;
		}

		enqueue(new Node<E>(e));
		return true;
	}

	private void enqueue(Node<E> node) {

		lock.lock();
		if (this.size.get() == 0) {
			head = node;
			last = node;
			this.size.incrementAndGet();

		} else {
			last.next = node;
			last = node;
			this.size.incrementAndGet();
		}
		notEmptyCondition.signalAll();
		lock.unlock();
	}

	@Override
	public E take() throws InterruptedException {
		if (this.size.get() == 0) {
			while (this.size.get() == 0) {
				lock.lock();
				notEmptyCondition.await();
				lock.unlock();
			}
			return take();
		} else {
			Node<E> currentHead = dequeue();
			return currentHead == null ? null : currentHead.item;
		}
	}

	private Node<E> dequeue() {
		lock.lock();
		if (null == head) {
			return null;
		}

		Node<E> currentHead = head;
		Node<E> nextToHead = head.next;
		head = nextToHead;
		if (null != nextToHead && null != nextToHead.next) {
			head.next = nextToHead.next;
		}
		this.size.decrementAndGet();
		notFullCondition.signalAll();
		lock.unlock();
		return currentHead;
	}

	@Override
	public void put(E e) throws InterruptedException {
		if (this.size.get() == capacity) {
			while (this.size.get() == capacity) {
				lock.lock();
				notFullCondition.await();
				lock.unlock();
			}
			put(e);
		} else {
			enqueue(new Node<E>(e));
		}

	}
}
