import java.util.Arrays;
import java.util.Random;

public class HeapSort {

   
    private static void sink(int[] arr, int n, int i) {
        while (true) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest == i) {
                break;
            }

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            i = largest;
        }
    }

    private static void buildMaxHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(arr, n, i);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        buildMaxHeap(arr);

        for (int end = n - 1; end > 0; end--) {

            int temp = arr[0];
            arr[0] = arr[end];
            arr[end] = temp;

            sink(arr, end, 0);
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] generateRandomArray(int n) {
        Random random = new Random(42);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1_000_000);
        }

        return arr;
    }

    private static int[] generateAscendingArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        return arr;
    }

    private static int[] generateDescendingArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }

        return arr;
    }

    private static double measureTime(int[] input) {

        long start = System.nanoTime();

        heapSort(input);

        long end = System.nanoTime();

        return (end - start) / 1_000_000.0;
    }

    public static void main(String[] args) {

        int[] example = {5, 2, 8, 1, 3};

        System.out.println("Before sorting: " + Arrays.toString(example));

        heapSort(example);

        System.out.println("After sorting:  " + Arrays.toString(example));
        System.out.println("Sorting correct: " + isSorted(example));

        System.out.println("\nRuntime Analysis");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-10s %-15s %-15s %-15s%n",
                "Size", "Random(ms)", "Ascending(ms)", "Descending(ms)");

        int[] sizes = {1000, 5000, 10000, 50000, 100000, 200000};

        for (int n : sizes) {

            int[] random = generateRandomArray(n);
            int[] ascending = generateAscendingArray(n);
            int[] descending = generateDescendingArray(n);

            double randomTime = measureTime(random);
            double ascendingTime = measureTime(ascending);
            double descendingTime = measureTime(descending);

            System.out.printf("%-10d %-15.4f %-15.4f %-15.4f%n",
                    n, randomTime, ascendingTime, descendingTime);
        }
    }
}