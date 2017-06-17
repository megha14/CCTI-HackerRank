import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {
    public static long makeChange(int[] coins, int money) {
        long[] DP = new long[money + 1]; 
        DP[0] = (long) 1; 	
        for(int coin : coins) {
            for(int j = coin; j < DP.length; j++) {
                DP[j] += DP[j - coin];
            }
        }       
        return DP[money];
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}
