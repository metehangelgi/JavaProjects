package code;

import given.AbstractArraySort;

/*
 * Implement the quick-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 */

public class QuickSort<K extends Comparable<K>> extends AbstractArraySort<K> {
	// Add any fields here

	public QuickSort() {
		name = "Quicksort";

		// Initialize anything else here
	}

	// useful if we want to return a pair of indices from the partition function.
	// You do not need to use this if you are just returning and integer from the
	// partition
	public class indexPair {
		public int p1, p2;

		indexPair(int pos1, int pos2) {
			p1 = pos1;
			p2 = pos2;
		}

		public String toString() {
			return "(" + Integer.toString(p1) + ", " + Integer.toString(p2) + ")";
		}
	}

	@Override
	public void sort(K[] inputArray) {
		// TODO:: Implement the quicksort algorithm here
		quickSort(inputArray, 0, inputArray.length - 1);
	}

	// Public since we are going to check its output!
	public indexPair partition(K[] inputArray, int lo, int hi, int p) {
		// TODO:: Implement a partitioning function here
		int e = lo;
		int u = lo;
		int g = hi + 1;
		K pivotElement = inputArray[p];

		while (u < g) {
			if (compare(inputArray[u], pivotElement) < 0) {
				swap(inputArray, u, e);
				u++;
				e++;
			} else if (compare(inputArray[u], pivotElement) == 0) {
				u++;
			} else {
				g--;
				swap(inputArray, u, g);

			}
		}

		return new indexPair(e, g);
	}

	/*
	 * Alternative, if you are just returning an integer public int partition(K[]
	 * inputArray, int lo, int hi, int p) { //TODO:: Implement a partitioning
	 * function here return null; }
	 */

	// The below methods are given given as suggestion. You do not need to use them.
	// Feel free to add more methods
	protected int pickPivot(K[] inpuArray, int lo, int hi) {
		// TODO: Pick a pivot selection method and implement it
		return lo;
		// return (int) (lo+hi)/2; ---this works faster generally, but not sure for this
		// one
	}

	private void quickSort(K[] inputArray, int lo, int hi) {

		if (lo < hi) {
			int p = pickPivot(inputArray, lo, hi);
			indexPair returnPair = partition(inputArray, lo, hi, p);
			quickSort(inputArray, lo, returnPair.p1);
			quickSort(inputArray, returnPair.p2, hi);
		}
	}
}
