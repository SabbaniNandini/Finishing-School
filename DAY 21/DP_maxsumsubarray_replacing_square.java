/*Aziz is given a set of integers SOI[], consists of both +ve and -ve integers.

Aziz wants to find the maximum sum of contiguous subset of the SOI, with a twist.

You have to perform the following operation before finding the maximum sum:
- You are allowed to replace exactly one integer X, with its square value (X*X).

Can you please help Aziz to find out the maximum sum of contiguous subset.


Input Format:
-------------
Single line of space separated integers, values of the array.

Output Format:
--------------
Print an integer value as result.


Sample Input-1:
---------------
-5 -3 1 2 -3 4 -4 3

Sample Output-1:
----------------
26

Explanation:
------------
max sum is: (-5)^2 + (-3) + 1 + 2 + (-3) + 4 = 26


Sample Input-2:
---------------
2 -2 2 2 -2 -2 2

Sample Output-2:
----------------
10

Explanation:
------------
max sum is: 2 +(-2)^2 + 2 + 2 = 10
*/
import java.util.*;
import java.lang.*;
class ma{
    public static void main(String[] args)
    {
      Scanner sc=new Scanner(System.in);
     String s=sc.nextLine();
     String a[]=s.split(" ");
     int arr[]=new int[a.length];
     for(int i=0;i<a.length;i++)
     {
         arr[i]=Integer.parseInt(a[i]);
     }
     int n=a.length;
     int dp[][]=new int[n][2];
     dp[0][0]=arr[0];
     dp[0][1]=arr[0]*arr[0];
     int max=Math.max(dp[0][0],dp[0][1]);
     for(int i=1;i<n;i++)
     {
        dp[i][0]=Math.max(dp[i-1][0]+arr[i],arr[i]);
        dp[i][1]=Math.max(arr[i]*arr[i],Math.max(dp[i-1][0]+arr[i]*arr[i],dp[i-1][1]+arr[i]));
        max=Math.max(max,Math.max(dp[i][1],dp[i][0]));
        
     }
     /*for(int i=0;i<n;i++)
     {
         System.out.println(dp[i][0]+" "+dp[i][1]);
     }*/
     System.out.println(max);
    }
}
