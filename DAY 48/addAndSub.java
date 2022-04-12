/*You are given a set of N integers, and a value to find F. Initially a variable, 
'total' is set to 0. You can perform either addition(+) or subtraction(-)
of every integer from the set to the 'total'. The resultant total should be
equal to the value F.

Your task is to find out the number of ways, you can make the 'total' equal to
the value F.

Input Format:
-------------
Line-1: Two integers N and F.
Line-2: N space separated integers 

Output Format:
--------------
Print an integer, number of ways.


Sample Input:
---------------
5 3
1 1 1 1 1

Sample Output:
----------------
5

Explanation:
------------
total = -1+1+1+1+1 = 3 -> total=value-F
total = +1-1+1+1+1 = 3 -> total=value-F
total = +1+1-1+1+1 = 3 -> total=value-F
total = +1+1+1-1+1 = 3 -> total=value-F
total = +1+1+1+1-1 = 3 -> total=value-F

NOTE: + means addition, - means subtraction
*/
import java.util.*;
import java.lang.*;
public class ma{
    static int dp[][];
    public static int solve(int arr[],int index,int n,int m,int cur,int sum)
    {
       if(index==n)
       {
           if(cur==m)
           {
              return 1; 
           }
           else
           {
               return 0;
           }
       }
       else
       {
           if(dp[index][cur+sum]!=Integer.MIN_VALUE)
           {
               return dp[index][cur+sum];
           }
           int a=solve(arr,index+1,n,m,cur+arr[index],sum);
           int b=solve(arr,index+1,n,m,cur-arr[index],sum);
           dp[index][sum+cur]=a+b;
           return dp[index][sum+cur];
       }
    }
public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    int arr[]=new int[n];
    int sum=0;
    
    
    for(int i=0;i<n;i++)
    {
        arr[i]=sc.nextInt();
        sum=sum+arr[i];
    }
    dp=new int[n][2*sum+1];
    for(int row[]:dp)
    {
        Arrays.fill(row,Integer.MIN_VALUE);
    }
    System.out.println(solve(arr,0,n,m,0,sum));
}
}
