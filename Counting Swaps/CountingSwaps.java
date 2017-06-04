import java.io.*;
import java.util.*;

public class CountingSwaps {

  
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = in.nextInt();
        in.close();
        int swaps = 0;
        for (int i = 0; i < n; i++) {
        int numberOfSwaps = 0;
        for (int j = 0; j < n - 1; j++) {
            // Swap adjacent elements if they are in decreasing order
            if (arr[j] > arr[j + 1]) {               
                swap(arr,j,j+1);
                numberOfSwaps++;
                swaps++;
            }
        }
        
        // If no elements were swapped during a traversal, array is sorted
        if (numberOfSwaps == 0) {
            break;
            }
            
        }
     
        System.out.println("Array is sorted in "+swaps+" swaps.");
        System.out.println("First Element: "+arr[0]);
        System.out.println("Last Element: "+arr[n-1]);
    
   }
         
   public static void swap(int arr[],int a, int b){
       int temp = arr[a];
       arr[a] = arr[b];
       arr[b] = temp;
   }
}
