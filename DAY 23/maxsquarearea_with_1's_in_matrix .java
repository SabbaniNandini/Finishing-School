/*The decoration on the wall, made up of led bulbs. 
When the bulbs turned on they emit either bule color light
or white color light. The leds bulbs decorated in the form of a grid
of size m*n. And when you turned on the bulbs, the bulbs are emiting
the light in blue color (1) and white color (0).

You are given the current state of the decorated wall of size M*N,
Your task is to find the biggest square can be formed using blue colored bulbs,
and return its area.

Input Format:
-------------
Line-1: Two space separated integers, M and N size of the decoration grid.
Next M lines: N space separated integers ( either 0 or 1 only).

Output Format:
--------------
Print an integer, area of the biggest square grid of blue colored bulbs.


Sample Input:
-------------
5 6
1 0 0 1 0 1
0 1 1 1 1 1
1 1 1 1 0 1
0 1 1 1 0 1
1 0 1 0 1 1 

Sample Output:
--------------
9
*/
import java.util.*;
import java.lang.*;
class ma{
    public static int maxarea(int arr[][],int n,int m)
    {
        
          
        int S[][] = new int[n][m];     
        
       int max=0;
    
        
        for(int i = 0; i < n; i++)
            S[i][0] = arr[i][0];
    
       
        for(int j = 0; j < m; j++)
            S[0][j] = arr[0][j];
        
        
        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j < m; j++)
            {
                if(arr[i][j] == 1) 
                    S[i][j] = Math.min(S[i][j-1],
                                Math.min(S[i-1][j], S[i-1][j-1])) + 1;
                else
                    S[i][j] = 0;
            } 
        } 
        int maxi=0;
        int maxj=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(max < S[i][j])
                {
                    max= S[i][j];
                    maxi = i; 
                    maxj = j;
                }    
            }
        }
        int k=maxj-maxi+1;
        
        return max*max;
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
        System.out.println(maxarea(arr,n,m));
    }
}
