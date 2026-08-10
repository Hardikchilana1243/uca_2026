
//Approach

// We can solve this using Binary Search on the answer.

// The maximum load will be between max(population) and max(population) / k.
// For a given maximum allowed load x, calculate how many clinics are required for each village:
// ceil(population[i] / x)
// If the total required clinics <= k, then x is possible, so try a smaller value.
// Otherwise, increase x.
// Continue until the minimum possible maximum load is found.


import java.util.*;

public class ClinicNdVillage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        double ans = minimumMaximumLoad(arr, k);

        System.out.printf("%.2f", ans);

        sc.close();
    }

    private static double minimumMaximumLoad(int[] arr, int k) {

        double low = 0.0;
        double high = 0.0;

        for (int ele : arr) {
            high = Math.max(ele, high);
        }

        for (int i = 0; i < 100; i++) {

            double mid = (low + high) / 2.0;

            int clinics = 0;

            for (int p : arr) {
                clinics += (int) Math.ceil(p / mid);

                if (clinics > k) {
                    break;
                }
            }

            if (clinics <= k) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }
}
