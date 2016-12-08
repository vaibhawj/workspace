package ds.stackQueue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class StackUsingQueue<T> {

	public static void main(String[] args) {
		StackUsingQueue<Integer> stack = new StackUsingQueue<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

	private Queue<T> q1;
	private Queue<T> q2;

	public StackUsingQueue() {
		q1 = new LinkedBlockingQueue<T>();
		q2 = new LinkedBlockingQueue<T>();
	}

	public void push(T o) {
		q2.add(o);
		while (!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		Queue<T> temp = q1;
		q1 = q2;
		q2 = temp;

	}

	public T pop() {
		return q1.poll();
	}

	public T peek() {
		return q1.peek();
	}

}
