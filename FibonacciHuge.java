
package fibonaccihuge;
import java.util.Scanner;
import java.math.BigInteger; //for representing SUPER large numbers

public class FibonacciHuge {

    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    
    private static int calc_fib(int n) {
        
        if (n == 0)
            return 0;
        
        else if (n == 1)
            return 1;
        
        int[] FibArray = new int[n+1];
        FibArray[0] = 0;
        FibArray[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            FibArray[i] = (FibArray[i - 1] + FibArray[i-2]);
            
        }
        return FibArray[n];
    }
    
    private static long getFibonacciHuge(long n, long m) {
        
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
    
}
