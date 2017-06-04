import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class CountingInversions{
	
	
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            
            System.out.println(mergeSort(arr));
         
        }
        
        
    }
    
    public static int mergeSort(int[] array){
    	return mergeSort(array, new int[array.length], 0, array.length-1);
    }
    
    public static int mergeSort(int[] array, int[] temp, int leftStart, int rightEnd){
    	if(leftStart >= rightEnd)
    		return 0;
    	int counter = 0;
    	int middle = (leftStart + rightEnd) /2;
    	counter += mergeSort(array, temp, leftStart, middle);
    	counter += mergeSort(array, temp, middle+1, rightEnd);
    	counter += mergeHalves(array, temp, leftStart, rightEnd);
    	
    	return counter;
    }
    
    public static int mergeHalves(int[] array, int[] temp,int leftStart, int rightEnd){
    	int leftEnd = (rightEnd + leftStart)/2;
    	int rightStart = leftEnd + 1;
    	int size = rightEnd - leftStart + 1;
    	
    	int left = leftStart;
    	int right = rightStart;
    	int index = leftStart;
    	
    	int count = 0;
    	while(left<=leftEnd && right <= rightEnd){
    		if(array[left] <= array[right]){
    			temp[index] = array[left];    
    			left++;
    		} else{
    			temp[index] = array[right]; 
    			count += leftEnd + 1 - left;
    			right++;
    		}
    		index++;
    		
    	}
    	
    	System.arraycopy(array, left, temp, index, leftEnd - left + 1);
    	System.arraycopy(array, right, temp, index, rightEnd - right + 1);
    	System.arraycopy(temp, leftStart, array, leftStart, size);
    	
    	return count;
    }
    
}
