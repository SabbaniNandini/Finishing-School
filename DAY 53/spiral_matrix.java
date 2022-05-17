/*You will be given the matrix of size R*C,

You have to return the matrix in special order as shown in the sample tescases.
 

Input Format:
-------------
Line-1 -> Two integers R and C, size of matrix.
Next R-Lines -> C space separated integers

Output Format:
--------------
Print R-Lines -> C space separated integers, in special order.


Sample Input-1:
---------------
3 3
1 2 3
4 5 6
7 8 9

Sample Output-1:
----------------
1 2 3
6 9 8
7 4 5


Sample Input-2:
---------------
3 4
1 2 3 4
5 6 7 8
9 10 11 12

Sample Output-2:
----------------
1 2 3 4
8 12 11 10
9 5 6 7
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int y=n;
        int z=m;
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        int a[]=new int[n*m];
        int x=0;
        int i=0;
        int k=0;
        int l=0;
        while(k<n&&l<m)
        {
            for(i=l;i<m;i++)
            {
               a[x++]=arr[k][i]; 
            }
            k++;
            for(i=k;i<n;i++)
            {
                a[x++]=arr[i][m-1];
            }
            m--;
            if(k<n)
            {
                for(i=m-1;i>=l;i--)
                {
                    a[x++]=arr[n-1][i];
                }
                n--;
            }
            if(l<m)
            {
                for(i=n-1;i>=k;i--)
                {
                    a[x++]=arr[i][l];
                }
                l++;
            }
        }
        //System.out.println(Arrays.toString(a));
        x=0;
        for(i=0;i<y;i++)
        {
            for(int j=0;j<z;j++)
            {
                System.out.print(a[x++]+" ");
            }
            System.out.println("");
        }
    }
}