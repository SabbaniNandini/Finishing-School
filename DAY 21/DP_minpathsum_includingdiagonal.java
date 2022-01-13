/*The bomb grid is filled with danger values, with both positive and negative integers.
positive means you will lose power of grid[i][j], 
negative means you will gain power of grid[i][j].

Naresh wants to cross the bridge, with the minimum loss of power.
He can cross the grid in the following way:
	- He can start at any bomb cell in the first row.
	- He can step on the next bomb cell in the next row that 
	  is either directly below of the current cell or diagonally left/right. 
	- Specifically, the next bomb cell from position grid(i, j) will be grid(i+1,j-1),
	(i + 1, j) , or (i + 1, j + 1) .

Can you help Naresh to lose the minimum power after crossing the bomb grid.

Input Format:
-------------
Line-1: An integer N, size of N*N grid 
Next N lines: N space separated  integers, values in the grid.

Output Format:
--------------
Print an integer, minimum sum of TopDown path.


Sample Input-1:
---------------
3
1 3 2
5 4 6
9 8 7

Sample Output-1:
----------------
12

Explanation:
-------------
Minimum lose of power is as follows:
start from bomb cell	1 -> 4 -> 7
Total lose is 12.


Sample Input-2:
---------------
3
32 10 23
-15 14 -16
19 -18 17

Sample Output-2:
----------------
-24

Explanation:
-------------
Minimum lose of power is as follows:
start from bomb cell	10 -> -16 -> -18
Total lose is -24.

*/
import java.util.*;
import java.lang.*;
class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++)
        {
            dp[0][i]=arr[0][i];
        }
       for(int i=1;i<n;i++)
       {
           for(int j=0;j<n;j++)
           {
               if(j==0)
               {
                  dp[i][j]=arr[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]); 
               }
               else if (j==n-1)
               {
                   dp[i][j]=arr[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
               }
               else
               {
                   dp[i][j]=arr[i][j]+Math.min(dp[i-1][j],Math.min(dp[i-1][j+1],dp[i-1][j-1]));
               }
           }
       }
       /*for(int i=0;i<n;i++)
       {
           for(int j=0;j<n;j++)
           {
               System.out.print(dp[i][j]+" ");
           }
           System.out.println("");
       }*/
       
       int min=Integer.MAX_VALUE;
       for(int i=0;i<n;i++)
       {
           min=Math.min(min,dp[n-1][i]);
           //System.out.println(" dp[n-1][i] is "+dp[n-1][i]+" min is "+min);
       }
       System.out.println(min);
    }
}

