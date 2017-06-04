import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IceCreamParlor {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int m = in.nextInt();
			int n = in.nextInt();
			int a[] = new int[n];
			
			for(int a_i=0; a_i < n; a_i++){
				a[a_i] = in.nextInt();
				
			}
			int[] result = getChoices(a,m);
			for(int i = 0;i<result.length;i++){
				int out = result[i]+1;
				System.out.print(out+" ");
			}
		System.out.println();
		}
	}
	
	public static int[] getIndicesFromValues(int[] menu, int value1, int value2){
		int index1 = indexOf(menu, value1, -1);
		int index2 = indexOf(menu, value2, index1);
		int[] index = {Math.min(index1,index2), Math.max(index1,index2)};
		return index;
	}
	
	public static int indexOf(int[] menu, int value, int excludeIndex){
		for(int i = 0;i<menu.length;i++){
			if(menu[i] == value && i!= excludeIndex)
				return i;
		}
		return -1;
	}
	
	
	public static int[] getChoices(int[] menu, int sum){
		int[] cloneMenu = menu.clone();
		Arrays.sort(cloneMenu);
		
		for(int i = 0;i<cloneMenu.length;i++){
			int compliment = sum - cloneMenu[i];
			int location = Arrays.binarySearch(cloneMenu, i+1, cloneMenu.length, compliment);
			if(location >=0 && location < cloneMenu.length && cloneMenu[location] == compliment){
				int[] indices = getIndicesFromValues(menu, cloneMenu[i],compliment);
				return indices;
			}
		}
		return null;
	}
    
    
}
