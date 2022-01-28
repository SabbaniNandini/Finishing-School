/*Ismart Shankar is given a set of N pluck cards, each card labelled 
with a number on it, and he is also given a difference value as ‘D’.
Now Ismart Shankar has to find out the length of the largest arithmetic set ‘S’.

A subset is called as arithmetic set, iff the difference between 
the numbers on any two adjacent cards is same as D.

A subset can be derived from the set of N pluck cads by deleting
some or no cards without changing the order of the remaining cards.

Input Format:
------------- 
Line-1: Two space separated integers N, D, number of cards, difference.
Line-2: N space separated integers, numbers on the set of cards.

Output Format:
--------------
Print an integer, length of longest arithmetic subset.


Sample Input-1:
---------------
6 2
1 2 3 4 6 8

Sample Output-1:
----------------
4

Sample Input-2:
---------------
8 -2
8 1 2 6 5 4 2 0 

Sample Output-2:
----------------
5
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }int max=0;
        int dp[]=new int[10001];
        for(int i : arr)
        {
            if(i-m>=0){
            dp[i]=Math.max(dp[i],1+dp[i-m]);
            
            }
            else
            {
                dp[i]=dp[i];
            }
            max=Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}
