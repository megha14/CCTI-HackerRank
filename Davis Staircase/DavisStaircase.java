import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DavisStaircase{
	
	public static int[] memory = new int[50];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        Arrays.fill(memory, -1);
        memory[0] = 1;
        memory[1] = 1;
        memory[2] = 2;
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
          
            System.out.println(findWaysIterative(n));
        }
    }
    
    public static int findWays(int target){
        if(target < 0)
            return 0;
        else if(memory[target] != -1)
            return memory[target];
        else{
            memory[target]= findWays(target-1)+findWays(target-2)+findWays(target-3);
            return memory[target];
        }
            
    }
    
    public static int findWaysMemo(int target){
    	if(target < 0)
            return 0;
        return findWaysMemo(target, new int[target+1]);
    }
    
    public static int findWaysMemo(int target, int memo[]){
    	if(target < 0)
            return 0;
        else if(target == 0)
        	return 1;
        if(memo[target] == 0)
        	memo[target] = findWaysMemo(target-1, memo)+findWaysMemo(target-2, memo)+findWaysMemo(target-3, memo);
        return memo[target];
    }
    
    public static int findWaysDP(int target){
    	if(target < 0)
    		return 0;
    	else if(target <= 1)
    		return 1;
    	int[] memo = new int[target+1];
    	for(int i=2;i<=target;i++){
    		memo[target]= findWaysDP(target-1)+findWaysDP(target-2)+findWaysDP(target-3);
    	}
    	return memo[target];	
    }
    
    public static int findWaysIterative(int target){
    	if(target < 0)
    		return 0;
    	else if(target <= 1)
    		return 1;
    	int[] memo = {1, 1, 2};
    	for(int i = 3;i<=target;i++){
    		int newWay = memo[0] + memo[1] + memo[2];
    		memo[0] = memo[1];
    		memo[1] = memo[2];
    		memo[2] = newWay;
    	}
    	return memo[2];
    }
    
}
