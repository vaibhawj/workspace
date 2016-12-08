package ds.stackQueue;

import java.util.Stack;

public class QueueUsingStack<T> {

	public static void main(String[] args) {
		QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());

	}

	private Stack<T> s1;
	private Stack<T> s2;

	public QueueUsingStack() {
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}

	public void add(T o) {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(o);
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}

	}

	public T poll() {
		return s1.pop();
	}

	public T peek() {
		return s1.peek();
	}

}
