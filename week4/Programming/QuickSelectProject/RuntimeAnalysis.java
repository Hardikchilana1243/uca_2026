import java.io.FileWriter;
import java.util.Random;

public class RuntimeAnalysis {

    public static void main(String[] args) throws Exception {

        FileWriter writer = new FileWriter("runtime.csv");

        writer.write("Size,Time\n");

        Random random = new Random();

        for(int n=1000;n<=100000;n+=5000){

            int[] arr = new int[n];

            for(int i=0;i<n;i++)
                arr[i]=random.nextInt();

            long start = System.nanoTime();

            QuickSelect.smallestK(arr,100);

            long end = System.nanoTime();

            writer.write(n + "," + (end-start) + "\n");

            System.out.println(n+" Done");
        }

        writer.close();

        System.out.println("runtime.csv generated.");
    }
}