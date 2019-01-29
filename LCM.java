
package lcm;
import java.util.Scanner;
import java.math.BigInteger; //for representing SUPER large numbers

public class LCM {

    
    private static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }
    
    private static int EuclidGCD(int a, int b) {
        int remainder = 1;
        if (b == 0) {
            return a;
        }
        
        remainder = a % b;
        return EuclidGCD(b, remainder);
        
    }
    
    private static BigInteger LeastCommonDivisor(int a, int b) {
        //if you divide the product of a*b and divide by gcd, get lcm
        /*int gcd = EuclidGCD(a, b);
        BigInteger product = BigInteger.valueOf(a*b);
        System.out.println("product: " + product);
        return(product.divide(BigInteger.valueOf(gcd)));
        //return (a*b/gcd); */
        BigInteger product = (BigInteger.valueOf(b)).multiply(BigInteger.valueOf(a));
        BigInteger GCD = (BigInteger.valueOf(a)).gcd(BigInteger.valueOf(b));
        //System.out.println("gcd: " + GCD);
        return(product.divide(GCD));
        
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        //System.out.println(lcm_naive(a, b));
        //System.out.println("gcd: " + EuclidGCD(a, b));
        System.out.println(LeastCommonDivisor(a, b));
    }
}
