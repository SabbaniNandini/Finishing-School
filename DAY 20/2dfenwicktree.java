/*Somasekharam is given a 2D grid of size M*N, 
the grid is filled with integers in the range of 1 to 10000:
He need to findout the sum of the elements of the sub-grid inside
the given 2D grid defined by its upper left corner (r1,c1) and
lower right corner (r2, c2).
 
Create and Implement the NumGrid class as follows:
	- NumGrid(int[][] grid) 
		- initializes the object with the integer grid.
	- int sumOfSubGrid(int r1, int c1, int r2, int c2)
		- returns the sum of the elements of sub-grid inside 
		the sub-grid defined by its upper left corner (r1, c1) 
		and lower right corner (r2, c2) .

Somasekharam is given a 2d grid of size M*N and Q queries of sumOfSubGrid.
Your task is to help Somasekharam to create and implement the NumGrid class.

Constraints:
------------
1 <= M, N, Q <= 100
0 <= r1,r2 < M
0 <= c1,c2 < N
r1<=r2
c1<=c2
 
Input Format:
-------------
Line-1: Three space separated integers M,N and Q.
Next M lines: N space separated integers, values of arr[][].
Next Q lines: four space separated integers, r1, c1, r2, c2

Output Format:
--------------
Print Q lines of integers, the sum of the elements of sub-grid.


Sample Input-1:
---------------
6 5 4
12 7 20 17 13	
16 15 9 7 15
1 18 14 12 10
17 7 12 14 4
2 18 3 16 17
7 6 7 13 8
1 3 5 4	
2 2 3 3
1 2 4 3
0 4 4 4

Sample Output-1:
----------------
116
52
87
59
*/
import java.util.*;
import java.util.*;
class ma
{
    public static int[][] NumGrid(int[][] g,int r , int c)
    {
        int f[][] = new int[r+1][c+1];
        for(int i=0;i<=r;i++)
            Arrays.fill(f[i],0);
        for(int i=1;i<r+1;i++){
            for(int j=1;j<c+1;j++){
                for(int p=i;p<r+1;p+=p&(-p)){
                    for(int q=j;q<c+1;q+=q &(-q) ){
                        f[p][q] +=g[i][j];
                    }
                }
            }
        }
        return f;
    }
    public static int sum(int x,int y, int[][]f,int r,int c)
    {
        int sum = 0;
        int p,q;
        for(p=x+1;p>0;p-=p&(-p))
        {
            for(q=y+1;q>0;q-=q&(-q))
            {
                sum+=f[p][q];
            }
        }
        return sum;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();
        int g[][] = new int[r+1][c+1];
        for(int i=1;i<r+1;i++)
        {
            for(int j=1;j<c+1;j++)
            {
                g[i][j] = sc.nextInt();
            }
        }
        int q[][] = new int[n][4];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<4;j++)
            {
                q[i][j] = sc.nextInt();
            }
        }
        int f[][] = NumGrid(g,r,c);
        
        for(int i=0;i<n;i++)
        {
            int x1 = q[i][0];
            int y1 = q[i][1];
            int x2 = q[i][2];
            int y2 = q[i][3];
            
            int ans = sum(x2,y2,f,r,c) - sum(x1-1,y2,f,r,c) - sum(x2,y1-1,f,r,c) + sum(x1-1,y1-1,f,r,c);
            System.out.println(ans);
        }
    }
}

