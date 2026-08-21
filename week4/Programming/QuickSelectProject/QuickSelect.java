import java.util.*;

public class QuickSelect {

    static Random random = new Random();

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    static void quickSelect(int[] arr, int low, int high, int k) {

        if (low >= high)
            return;

        int pivotIndex = low + random.nextInt(high - low + 1);

        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp;

        int p = partition(arr, low, high);

        if (p == k)
            return;

        if (p > k)
            quickSelect(arr, low, p - 1, k);
        else
            quickSelect(arr, p + 1, high, k);
    }

    static int[] smallestK(int[] arr, int k) {

        quickSelect(arr, 0, arr.length - 1, k - 1);

        return Arrays.copyOf(arr, k);
    }

    public static void main(String[] args) {

        int[] arr = {12,7,5,18,2,9,3,15,10};

        int k = 4;

        int[] ans = smallestK(arr, k);

        System.out.println("Smallest " + k + " elements:");

        for(int x: ans)
            System.out.print(x+" ");
    }
}