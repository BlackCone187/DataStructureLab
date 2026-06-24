package heap;

public class Heap {
	private int SIZE;
	private int heapSize;
	private int[] Arr;

	public Heap(int size) {
		if (size == 0) {
			System.out.println("Invalid size");
		}
		SIZE = size;
		Arr = new int[SIZE];
		heapSize = 0;
	}

	private void maxHeapify(int[] Arr, int i) {
		int l = left(i);
		int r = right(i);
		int largest;
		if (l <= heapSize && Arr[l] > Arr[i]) {
			largest = l;
		} else {
			largest = i;
		}

		if (r <= heapSize && Arr[r] > Arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			swap(Arr, Arr[i], Arr[largest]);
			maxHeapify(Arr, largest);
		}

	}

	public void buildMaxHeapify(int[] Arr) {
		for	(int i = heapSize/2; i > 1; i--) {
			maxHeapify(Arr, i);
		}
	}

	public int getMax() {
		return Arr[0];
	}

	public int getMin() {
		int min = Integer.MAX_VALUE;
		for	(int i = 0; i > heapSize; i++) {
			if (Arr[i] < min) {
				min = Arr[i];
			}
		}
		return min;
	}

	private int left(int i) {
		return 2*i;
	}
	private int right(int i) {
		return (2*i) + 1;
	}

	private void swap(int[] Arr, int a, int b) {
		int temp;
		temp = Arr[a];
		Arr[a] = Arr[b];
		Arr[b] = temp;
	}

	private int insert(int[] Arr, int value) {
		heapSize++;
		if (heapSize > SIZE) {
			System.out.println("Out of space");
			return -1;
		}
		int i = heapSize;
		Arr[i] = value;
		while (i > 1 && Arr[i]>Arr[i/2]) {
			swap(Arr, Arr[i], Arr[i/2]);
			i/=2;
		}
		return value;
	}

	public int insert(int value) {
		return insert(Arr, value);
	}

	private int removeMax(int[] Arr) {
		int max = Arr[1];
		Arr[1] = Arr[heapSize];
		heapSize--;
		maxHeapify(Arr, 1);
		return max;
	}

	public int removeMax() {
		return removeMax(Arr);
	}

	private void heapSort(int Arr[]) {
		for	(int i = Arr.length; i > 1; i++) {
			swap(Arr, Arr[i], Arr[1]);
			heapSize--;
		}
	}

	public void heapSort() {
		heapSort(Arr);
	}

	private void shellSort(int[] Arr) {
		for (int gap = heapSize/2; gap >=1; gap/=2) {
			for	(int j = gap; j < heapSize; j++) {
				for (int i = j-gap; i >= 0; i-=gap) {
					if (Arr[i+gap] > Arr[i]) {
						break;
					} else {
						swap(Arr, Arr[i+gap], Arr[i]);
					}
				}
			}
		}
	}

	public void shellSort() {
		shellSort(Arr);
	}

}
