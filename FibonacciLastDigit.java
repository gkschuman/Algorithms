
package fibonaccilastdigit;
import java.util.Scanner;

public class FibonacciLastDigit {

    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
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
    
    private static int getFibonacciLastDigitFast(int n) {
        int lastDigit = 0;
        if (n == 0)
            return 0;
        
        else if (n == 1)
            return 1;
        
        int first = 0, second = 1;
        
        for (int i = 2; i <= n; i++) {
            //FibArray[i] = (FibArray[i - 1] + FibArray[i-2]);
            lastDigit = (first + second) % 10;
            first = second; //i+1 --> i -2
            second = lastDigit;
            
        }
        return lastDigit;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int c = getFibonacciLastDigitNaive(n);
        long fib = calc_fib(n);
        //System.out.println("Fib: " + fib);
        int digit = getFibonacciLastDigitFast(n);
        System.out.println(digit);
    }
    
}
