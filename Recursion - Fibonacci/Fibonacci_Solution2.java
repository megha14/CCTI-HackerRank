import java.util.*;

public class Fibonacci_Solution2 {

   
   public static int fibonacci(int n) {
        // Complete the function.
       
        if(n <= 1)
            return n;
        int f[] = {0,1};
        for(int i = 2;i<=n;i++){
            int temp = f[0] + f[1];
            f[0] = f[1];
            f[1] = temp;
        }
        return f[1];
      
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        System.out.println(fibonacci(n));
    }
}
