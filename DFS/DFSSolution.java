import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DFSSolution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        
        System.out.println(getMaxRegionLength(grid));
    }
    
    public static int getMaxRegionLength(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, countFilledConnections(grid, i, j));
            }
        }
        return max;
    }
    
    private static int countFilledConnections(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) 
        	return 0;
        if (grid[i][j] == 0) 
        	return 0;
        grid[i][j] = 0;
        int count = 1;
         for (int row = i-1; row <= i+1; row++) {
            for (int col = j-1; col <= j+1; col++) {
            	if(row != i || col != j)
            		count += countFilledConnections(grid, row, col);
            }
         }
        return count;
    }
}
