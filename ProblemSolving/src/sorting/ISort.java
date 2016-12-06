package sorting;

public interface ISort<T> {

	T[] sort(T[] arr);

	default void print(T[] arr) {
		for (T n : arr) {
			System.out.print(n + " ");
		}
	}
}
