public class Partitions {

    public static int lomutoPartition(int[] array, int low, int high) {
        // check for invalid input (null array, empty array, or bad bounds)
        if (array == null) {
            throw new IllegalArgumentException("array cannot be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("array cannot be empty");
        }
        if (low < 0 || high < 0 || low > high || high >= array.length) {
            throw new IllegalArgumentException("invalid low/high bounds");
        }

        // choose the last element as the pivot
        int pivot = array[high];

        // i keeps track of elements smaller than or equal to pivot
        int i = low - 1;

        // loop through the array
        for (int j = low; j < high; j++) {

            // if current element is smaller than or equal to pivot,
            // move it to the left side
            if (array[j] <= pivot) {
                i++;                       // move boundary
                int temp = array[i];      // swap array[i] and array[j]
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // place pivot in the correct position
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the pivot index
        return i + 1;
    }

    public static int hoarePartition(int[] array, int low, int high) {
        // check for invalid input (null array, empty array, or bad bounds)
        if (array == null) {
            throw new IllegalArgumentException("array cannot be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("array cannot be empty");
        }
        if (low < 0 || high < 0 || low > high || high >= array.length) {
            throw new IllegalArgumentException("invalid low/high bounds");
        }

        // choose the first element as the pivot
        int pivot = array[low];

        // i moves from left to right
        int i = low - 1;

        // j moves from right to left
        int j = high + 1;

        // continue until pointers cross
        while (true) {

            // move i until element >= pivot is found
            do {
                i++;
            } while (array[i] < pivot);

            // move j until element <= pivot is found
            do {
                j--;
            } while (array[j] > pivot);

            // if pointers cross, partitioning is done
            if (i >= j) {
                return j;
            }

            // swap elements at i and j
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
