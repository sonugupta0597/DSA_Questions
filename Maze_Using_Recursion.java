
package Amazon_Target;

import java.util.Scanner;

public class Maze_Using_Recursion {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int col = scan.nextInt();
        
        int ar[][] = new int[row][col];
        
        for(int i=0;i<3;i++)
        {
             for(int j=0;j<3;j++)
             {
                 ar[i][j]=scan.nextInt();
             }
        }
        
        int visited[][] = new int[3][3];
        
        
        double min = recursion(ar,3,3,0,0,visited);
        
        System.out.println(min);
    }

    private static double recursion(int[][] ar, int row, int col, int i, int j,int visited[][]) {
        if(i>=row || j>=col || i<0 || j<0 || ar[i][j]==0 || visited[i][j]==1)
        {
               return Integer.MAX_VALUE;
        }
        if(ar[i][j]==9)
        {
               return 0;
        }
        
        visited[i][j]=1;
        
        double a = recursion(ar,row,col,i+1,j,visited)+1d;
        
        double b = recursion(ar,row,col,i-1,j,visited)+1d;
        
        double c = recursion(ar,row,col,i,j+1,visited)+1d;
        
        double d = recursion(ar,row,col,i,j-1,visited)+1d;
        
        visited[i][j]=0;
        
        return Math.min(Math.min(a, b),Math.min(c, d));
        
    }
}
