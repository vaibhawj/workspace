package day16;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class References {

	static PhantomReference<A> phantom;

	public static void main(String[] args) throws InterruptedException {
		// WeakReference
		System.out.println("****************Weak reference**************");
		WeakReference<A> w = getWeakReference();
		System.gc();
		Thread.sleep(2000);
		System.out.println("just woke up");
		System.out.println(w.get());

		// Real Reference
		System.out.println("****************Real reference**************");
		A a = getRealReference();
		System.gc();
		Thread.sleep(2000);
		System.out.println("just woke up");
		System.out.println(a);

		// Soft reference
		System.out.println("****************Soft reference**************");
		SoftReference<A> s = getSoftReference();
		System.gc();
		Thread.sleep(2000);
		System.out.println("just woke up");
		System.out.println(s.get());

		// Phantom reference
		System.out.println("****************Phantom reference**************");
		ReferenceQueue<A> refQueue = new ReferenceQueue<References.A>();
		PhantomReference<A> p1 = getPhantomReference(refQueue);
		System.gc();
		Thread.sleep(2000);
		System.out.println("just woke up");
		System.out.println(p1.get());
		Reference<? extends A> p2 = refQueue.poll();
		System.out.println(p2);
		System.out.println(phantom.get());

	}

	private static PhantomReference<A> getPhantomReference(
			ReferenceQueue<A> refQueue) {
		A a = new A("Phantom");
		phantom = new PhantomReference<References.A>(a, refQueue);
		PhantomReference<A> p = new PhantomReference<References.A>(a, refQueue);
		return p;
	}

	private static SoftReference<A> getSoftReference() {
		A a = new A("Soft");
		return new SoftReference<A>(a);
	}

	static A getRealReference() {
		A a = new A("Real");
		return a;
	}

	static WeakReference<A> getWeakReference() {
		A a = new A("Weak");
		return new WeakReference<References.A>(a);
	}

	static class A {

		private String name;

		public A(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}

		@Override
		protected void finalize() throws Throwable {

			super.finalize();
			System.out.println("Finalize called for " + this.name);
		}
	}

}
