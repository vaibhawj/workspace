package blockingQueue.custom;

import java.util.concurrent.atomic.AtomicInteger;

public class MyLinkedBlockingQueue<E> implements IBlockingQueue<E> {

	private Node<E> head;
	private Node<E> last;
	private int capacity;
	private volatile AtomicInteger size;

	public MyLinkedBlockingQueue(int capacity) {
		this.capacity = capacity;
		this.size = new AtomicInteger();
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

		if (this.size.get() == 0) {
			head = node;
			last = node;
			this.size.incrementAndGet();

		} else {
			last.next = node;
			last = node;
			this.size.incrementAndGet();
		}
	}

	@Override
	public E take() throws InterruptedException {
		if (this.size.get() == 0) {
			while (this.size.get() == 0) {
				// busy wait
			}
			return take();
		} else {
			Node<E> currentHead = dequeue();
			return currentHead == null ? null : currentHead.item;
		}
	}

	private Node<E> dequeue() {
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
		return currentHead;
	}

	@Override
	public void put(E e) throws InterruptedException {
		if (this.size.get() == capacity) {
			while (this.size.get() == capacity) {
				// busy wait
			}
			put(e);
		} else {
			enqueue(new Node<E>(e));
		}

	}
}
