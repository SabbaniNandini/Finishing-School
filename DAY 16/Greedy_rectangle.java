/*Vicky, an expert in gaming software, lives in Australia and never compromises
in his life, a principle that he adheres to since his childhood. After 
long time he returns to India to establish a start-up gaming company. 

He meets his uncle Jalsa Kishore and Vicky tells about his plan. 
Jalsa Kishore came up with an idea for Vicky with a new game. 
He draws a grid with combination of 0’s and 1’s of size P X Q, where
we can reorganize the columns of the grid in any order. 

Jalsa Kishore says that build a grid such that we get the area of 
the greatest subunits within the grid where every unit of the sub grid is 1
after reorganizing the columns.

Now it’s your aim to write a method which prints the area of 
the greatest subunits within the grid according to idea of Jalsa Kishore.


Input Format:
-------------
Line-1: Two integers P and Q, size of the grid.
Next P lines: Q separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, area of the greatest subunits.


Sample Input-1:
---------------
3 4
1 0 1 0
0 1 1 1
0 1 0 1

Sample Output-1:
----------------
4

Explanation:
----------
After Reorganizing the columns, the grid looks like as follows:
1 0 0 1
0 1 1 1
0 1 1 0


Sample Input-2:
---------------
1 5
1 0 1 0 1

Sample Output-2:
----------------
3
*/
import java.util.*;
import java.lang.*;
class ma{
    static int maxArea(int mat[][],int R,int C)
    {
        
        int hist[][] = new int[R + 1][C + 1];

        
        for (int i = 0; i < C; i++) 
        {
           
            hist[0][i] = mat[0][i];

            
            for (int j = 1; j < R; j++) 
             {
                hist[j][i] = (mat[j][i] == 0) ? 0 : hist[j - 1][i] + 1;
            }
        }

      
        for (int i = 0; i < R; i++)
        {
            int count[] = new int[R + 1];

            
            for (int j = 0; j < C; j++) 
            {
                count[hist[i][j]]++;
            }

           
            int col_no = 0;
            for (int j = R; j >= 0; j--) 
            {
                if (count[j] > 0)
                {
                    for (int k = 0; k < count[j]; k++) 
                    {
                        hist[i][col_no] = j;
                        col_no++;
                    }
                }
            }
        }

        
        int curr_area, max_area = 0;
        for (int i = 0; i < R; i++) 
        {
            for (int j = 0; j < C; j++)
            {
                
                curr_area = (j + 1) * hist[i][j];
                if (curr_area > max_area)
                {
                    max_area = curr_area;
                }
            }
        }
        return max_area;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        
        System.out.println(maxArea(arr,n,m));
    }
}
