import java.util.regex.*;

public class PrimalityTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            System.out.println(isPrime(n));
        }
    }
    
    public static String isPrime(int n){
        if(n==2)
            return "Prime";
        else if(n%2==0 || n<=1)
             return "Not prime";
        else{
            for(int i=3;i<Math.sqrt(n+1);i=i+2){
                if(n%i==0)
                    return "Not prime";
            }  
            return "Prime";
        }       
        
    }
}
