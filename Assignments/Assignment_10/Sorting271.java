public class Sorting271 {

    /**
     * Merges two sorted arrays into a single sorted array.
     * @param left The first sorted array.
     * @param right The second sorted array.
     * @return A new array containing all elements from left and right, sorted.
     */
    public int[] merge(int[] left, int[] right) {
        int[] mergedArray = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Merge elements from left and right into mergedArray
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                mergedArray[k++] = left[i++];
            } else {
                mergedArray[k++] = right[j++];
            }
        }

        // Copy remaining elements from left array
        while (i < left.length) {
            mergedArray[k++] = left[i++];
        }

        // Copy remaining elements from right array
        while (j < right.length) {
            mergedArray[k++] = right[j++];
        }

        return mergedArray;
    }

    /**
     * Sorts an array using the merge sort algorithm.
     * @param array The array to be sorted.
     * @return A new sorted array.
     */
    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;  // An array with 1 or fewer elements is already sorted
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Split the array into two halves
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        // Recursively sort both halves and merge them
        return merge(sort(left), sort(right));
    }

    public static void main(String[] args) {
        Sorting271 sorter = new Sorting271();

        int[] array = {10, 8, 5, 3, 2, 7, 6, 1, 4, 9};
        int[] sortedArray = sorter.sort(array);

        // Print the sorted array
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}