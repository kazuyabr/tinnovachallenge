package exercicios.bubblesort;

public class BubbleSort {

	// Testando a ordenação
	public static void main(String args[]) {
		BubbleSort bubble = new BubbleSort();
		int array[] = { 5, 3, 2, 4, 7, 1, 0, 6 };
		bubble.bubbleSort(array);
		bubble.show(array);
	}

	void bubbleSort(int array[]) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int troca = array[j];
					array[j] = array[j + 1];
					array[j + 1] = troca;
				}
			}
		}
	}

	void show(int array[]) {
		int n = array.length;
		for (int i = 0; i < n; ++i)
			System.out.print(array[i] + " ");
		System.out.println();
	}

}
