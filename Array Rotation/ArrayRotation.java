import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int tempIndex;
        int[] temp = new int[n];

        for(int i = 0;i<n;i++){
            tempIndex = (i + n - k) % n;
            temp[tempIndex] = a[i];
        }
        
        for(int a_i=0; a_i < n; a_i++){
            System.out.print(temp[a_i]+" ");
        }
    }
}
