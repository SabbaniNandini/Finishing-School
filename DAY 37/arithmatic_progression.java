/*Basava is interested in playing with digits.
He wants to create a set of integers of length N, using the digits[0-9].
The rules to create the integers are as follows:
	- digits in each integer are like d0,d1,d2...dn-1
	- and |d0-d1| = |d1-d2| = |d2-d3| ... |dn-2 - dn-1|= D

Basava is given two integers N and D, where N is length of the integer and 
D is the difference. Can you help Basava, to create such list of integers 
and print all the possible integers in ascending order


Note:
-----
Integers with leading 0's are not allowed


Input Format:
-------------
Two space separated integers N and K.

Output Format:
--------------
Print all the possible integers in ascending order.


Sample Input-1:
---------------
3 5

Sample Output-1:
----------------
[161, 272, 383, 494, 505, 616, 727, 838, 949]


Sample Input-2:
---------------
2 3

Sample Output-2:
----------------
[14, 25, 30, 36, 41, 47, 52, 58, 63, 69, 74, 85, 96]

*/import java.util.*;
import java.lang.*;
public class ma{
    public static TreeSet<Integer> ans=new TreeSet<>();
    public static void recur(int n,int m,int cur,int next)
    {
        if(n==0)
        {
            ans.add(cur);
            return ;
        }
        if(next+m<=9)
        {
            recur(n-1,m,cur*10+next,next+m);
        }
        if(next-m>=0)
        {
            recur(n-1,m,cur*10+next,next-m);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
    for(int i=1;i<=9;i++)
    {
        recur(n,m,0,i);
    }
    System.out.println(ans);
    }
}