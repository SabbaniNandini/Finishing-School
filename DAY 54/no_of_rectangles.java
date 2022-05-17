/*A chocolate vendor prepared a big chocolate of size M*N.
This choloate is made using two kinds of chocolates, white and dark chocolate.
Where white chocolate indiactes with '0' and Dark Chocolate is with '1'.

You will be given the big chocolate of size M*N.
Your task is to find out, number of dark chacolates can be formed
with rectangular shapes from the grid.

NOTE: You can assume that all the 1*1 chocolate have same size.

Input Format:
-------------
Line-1: Two space seprated integers, M and N size of chocolate.
Next M lines: N space seprated integers, only 0's and 1's.

Output Format:
--------------
Print an integer value.


Sample Input-1:
---------------
2 3
1 1 0
0 1 1

Sample Output-1:
----------------
7

Explanation:
------------
There are 4 dark-chocolates of size 1x1.
There are 2 dark-chocolates of size 1x2.
There are 1 dark-chocolates of size 2x1.


Sample Input-2:
---------------
3 4
1 0 1 1
1 1 0 1
1 1 1 0

Sample Output-2:
----------------
20

Explanation:
------------
There are 9 dark-chocolates of size 1x1
There are 4 dark-chocolates of size 1x2
There is 1 dark-chocolate of size 1x3
There are 4 dark-chocolate of size 2x1
There is 1 dark-chocolate of size 3x1
There is 1 dark-chocolate of size 2x2
*/
import java.util.*;
class ma{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] a=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<m;i++){
            for(int j=n-2;j>=0;j--){
                if(a[i][j]==1){
                    a[i][j]+=a[i][j+1];
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int min=a[i][j];
                for(int d=i;d<m;d++){
                    if(a[d][j]==0)break;
                    min=Math.min(min,a[d][j]);
                    count+=min;
                }
                
            }
        }
        System.out.println(count);
    }
}
