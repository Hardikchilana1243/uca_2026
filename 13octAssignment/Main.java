
import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static int solve(int n, int[] a) {
        long ans = 0;

        for (int bit = 0; bit < 31; bit++) {
            long ones = 0;
            long prefixXor = 0;

            // Prefix XOR initially equals 0
            ones = 0;

            for (int i = 0; i < n; i++) {
                prefixXor ^= a[i];

                if (((prefixXor >> bit) & 1L) == 1L) {
                    ones++;
                }
            }

            long totalPrefixes = n + 1L;
            long zeros = totalPrefixes - ones;

            // Include the initial prefix XOR = 0
            long contribution =
                (ones * zeros % MOD) * ((1L << bit) % MOD) % MOD;

            ans = (ans + contribution) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String line = br.readLine();
        if (line == null) return;

        int n = Integer.parseInt(line.trim());
        int[] a = new int[n];

        StringBuilder sb = new StringBuilder();
        while (sb.length() == 0 || sb.toString().trim().split("\\s+").length < n) {
            String input = br.readLine();
            if (input == null) break;
            sb.append(input).append(" ");
        }

        String[] parts = sb.toString().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(solve(n, a));
    }
}
