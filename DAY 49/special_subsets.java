/*There are n boxes of balls in a row, every i-th box contains balls[i] balls.

A series of boxes is called Special, if it consists of at least 
three boxes and iff the difference between the number of balls in any 
two consecutive boxes is same.

A subset of boxes is called Special Subset,
if subset[i], subset[i+1], subset[i+2], ..., subset[j] is Special.

Your task is to findout the number of Special Subsets in the row of boxes.

Input Format:
-------------
Line-1 : An integer N, number of boxes.
Line-2 : N space separated integers balls[i], i-th box contains balls[i] balls. 

Output Format:
--------------
Print an integer, number of Special Subsets.


Sample Input:
---------------
4
1 2 3 4

Sample Output:
----------------
3

Explanation:
------------
Special Subsets are: 
[1,2,3], [2,3,4], [1,2,3,4].


Sample Input:
---------------
5
1 3 5 7 9

Sample Output:
----------------
6


Explanation:
------------
Special Subsets are: 
[1,3,5], [3,5,7], [5,7,9], [1,3,5,7], [3,5,7,9], [1,3,5,7,9].
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int diff[]=new int[n];
        for(int i=1;i<n;i++)
        {
            diff[i]=arr[i]-arr[i-1];
        }
        int count=1;
        int ans=0;
        for(int i=1;i<n;i++)
        {
            if(diff[i]-diff[i-1]==0)
            {
                count++;
            }
            else
            {
                if(count>=3)
                {
                    ans=ans+(count*(count-1))/2;
                    count=1;
                }
            }
        }
        ans=ans+(count*(count-1))/2;
        System.out.println(ans);
    }
}