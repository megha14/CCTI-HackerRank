import java.util.*;

public class Fibonacci_Solution1 {

   private static int[] f = new int[40];
   
   public static int fibonacci(int n) {
        // Complete the function.
       
        if(n <= 1)
            return n;
        else if(f[n] != -1)
            return f[n];
        else{
            f[n] = fibonacci(n-1)+fibonacci(n-2);           
            return f[n];
        }
            
      
      
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        Arrays.fill(f, -1);
        System.out.println(fibonacci(n));
    }
}
