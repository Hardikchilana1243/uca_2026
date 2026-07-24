package Assignment3;

import java.util.*;

public class CountSmallerNumbers {

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1, result);

        List<Integer> ans = new ArrayList<>();
        for (int x : result) {
            ans.add(x);
        }
        return ans;
    }

    private static void mergeSort(Pair[] arr, int low, int high, int[] result) {
        if (low >= high)
            return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid, result);
        mergeSort(arr, mid + 1, high, result);
        merge(arr, low, mid, high, result);
    }

    private static void merge(Pair[] arr, int low, int mid, int high, int[] result) {

        List<Pair> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;
        int rightCount = 0;

        while (left <= mid && right <= high) {

            if (arr[right].value < arr[left].value) {
                temp.add(arr[right]);
                rightCount++;
                right++;
            } else {
                result[arr[left].index] += rightCount;
                temp.add(arr[left]);
                left++;
            }
        }

        while (left <= mid) {
            result[arr[left].index] += rightCount;
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        sc.close();

        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        List<Integer> ans = countSmaller(nums);

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}