package week6.programming;

public class FindingNumberInArray {

    public static int findNumberRepeatingFourTimes(int[] arr) {

        int answer = 0;

        // Integer has 32 bits
        for (int bit = 0; bit < 32; bit++) {

            int count = 0;

            // Count how many numbers have this bit set
            for (int num : arr) {

                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            // Normal numbers occur 3 times,
            // so only the extra occurrence remains.
            if (count % 3 != 0) {
                answer = answer | (1 << bit);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {
            1, 2, 3, 4,
            1, 2, 4,
            1, 2, 3, 4,
            3, 3
        };

        int result = findNumberRepeatingFourTimes(arr);

        System.out.println("Number repeating 4 times: " + result);
    }
}