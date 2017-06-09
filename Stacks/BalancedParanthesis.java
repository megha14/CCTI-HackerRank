import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedParanthesis {
    
    public static boolean isBalanced(String expression) {
    Stack stack = new Stack();
    for(int i=0;i<expression.length();i++){
    	char temp = expression.charAt(i);
    	if(checkExpression(temp,'{') ||
    		checkExpression(temp,'[') ||
    		checkExpression(temp,'('))
    		stack.push(temp);
    		
    	if(checkExpression(temp,'}') ||
    		checkExpression(temp,')') ||
    		checkExpression(temp,']')){
    			if(stack.isEmpty())
    				return false;
    			char s = (Character)stack.pop();
    			//System.out.println(s+" "+temp);
    			if(!checkPair(s, temp))
    				return false;
    		}
    	}
    	
    	if(stack.isEmpty())
    		return true;
    	else
    		return false;
    }
    
    public static boolean checkExpression(char s,char d){
    	if(s == d)
    		return true;
    	return false;
    }
    
    public static boolean checkPair(char s, char d){
    	if(s == '{' && d == '}')
    		return true;
    	else if(s == '(' && d == ')')
    		return true;
    	else if(s == '[' && d == ']')
    		return true;
    	else
    		return false;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
