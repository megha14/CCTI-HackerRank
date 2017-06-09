import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class StringAnagram {
    public static int getDifference(int[] first, int[] second){
		int sum = 0;
		for(int i = 0;i<26;i++)
			sum += Math.abs(first[i] - second[i]);
		return sum;
	}
	
	public static int getIndex(char character){
		int offset = (int)'a';
		return ((int)character - offset)%26;
	}
	
	public static int[] getCharacterArray(String name){
		int[] charOffsets = new int[26];
		for(int i = 0;i<name.length();i++){
			int index = getIndex(name.charAt(i));
			charOffsets[index] += 1;
		}
		return charOffsets;
	}

    public static int numberNeeded(String first, String second) {
    	int[] firstString = getCharacterArray(first);
    	int[] secondString = getCharacterArray(second);
    	return getDifference(firstString, secondString);
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
    
    
}
