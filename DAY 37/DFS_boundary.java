/*A forest is represented as a square grid consist of 0's an 1's only. Few people
stuck in the forest, where 1's indicate people, and 0's indicate trees. 
The people cannot pass through the tree.

Your target is to save people, a person can be saved, if he/she connected
to other person who is at the boundary of forest, like as follows:
    - If 'a' is connected to 'b' and 'b' is connected to 'c',
      then you can consider that 'a' is also connected to 'c'. 
    - The people can connect each other in 4 directions only. 
      (up, right, left and down)

You need to find out the number of persons, who cannot be saved from the forest.


Input Format:
-------------
Line-1 -> An integer N, size of the grid N*N
next N lines -> N space separated integers(0's and 1's)

Output Format:
--------------
Print an integer as your result


Sample Input-1:
---------------
5
0 0 1 1 0
1 0 0 1 0
0 0 1 0 0
0 1 1 0 1
1 0 0 1 0

Sample Output-1:
----------------
3

Explanation:
------------
In the given grid, 1's at (2,2), (3,1), (3,2) positions are not connected to
the boundary. So, number of people cannot be saved are 3.


Sample Input-2:
---------------
5
0 0 1 1 0
1 0 0 1 0
0 0 1 1 0
0 1 1 0 1
1 0 0 1 0

Sample Output-2:
----------------
0

Explanation:
------------
In the given grid, each 1 is either at the boundary or connceted to 1 at boundary.
So, number of people cannot be saved are '0'
*/
import java.util.*;
import java.lang.*;
public class ma{
     static int count=0;
    public static boolean dfs(int arr[][],int i,int j,int visited[][])
    {
        if(i<0||j<0||i>=arr.length||j>=arr.length||visited[i][j]==1||arr[i][j]==0)
        {
            return false;
        }
        visited[i][j]=1;
        if(check(i,j,arr.length)==true)
        {
            //count++;
            
            //System.out.println(" i is "+i+" j is "+j);
            
            return true ;
        }
        return dfs(arr,i+1,j,visited)|| dfs(arr,i-1,j,visited)||dfs(arr,i,j+1,visited)||dfs(arr,i,j-1,visited);
       
        
        
    }
    public static boolean check(int i,int j,int n)
    {
        if(i==0||j==0||i==n-1||j==n-1)
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            arr[i][j]=sc.nextInt();
        }
    }
    int ans=0;
    
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(arr[i][j]==1)
            {
                int visited[][]=new int[n][n];
                //System.out.println(i+"+"+j);
                ans++;
                if(dfs(arr,i,j,visited)==true)
                {
                    count++;
                }
            }
        }
    }
    /*for(int row[]:arr)
    {
        System.out.println(Arrays.toString(row));
    }*/
    /*System.out.println(count);
    System.out.println(ans);*/
    System.out.println(ans-count);
    }
}
