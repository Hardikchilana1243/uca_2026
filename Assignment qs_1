import java.util.*;
class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(SumOfFibonacci(n));
    }

    public static int SumOfFibonacci(int n){
        int a=0;
        int b=1;
        int sum=0;
        while(a<=n){
            if(a%2==0){
                sum+=a;
            }
            int c=a+b;
            a=b;
            b=c;
        }
        return sum;
    }

}
