/*Mohan is given a task to decorate a wall with balloons.
He is given an unlimited set of ballons of three different colors.

The decoration should have N rows of 3 balloons each. 
He has to make sure that no two adjacent balloons have the same colour.
both vertically and horizontally.

Your task is to help Mr Mohan to find the number of ways to decorate the wall,  
the answer must be computed modulo 10^9 + 7

Input Format:
-------------
An integer N

Output Format:
--------------
Print an integer as outpur, number of ways to decorate.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
12

Explanation:
------------
Suppose the colors are, B-Blue, W-White, R-Red. Given N is 1
RBR	BRB	WRB
RBW	BRW	WRW
RWR	BWR	WBR
RWB	BWB	WBW


Sample Input-2:
---------------
2

Sample Output-2:
----------------
54

*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(math(n));
    }
    public static int math(int n)
    {
        long k=(long) Math.pow(10,9)+7;
        long a=6;
        long b=6;
        long c=0;
        long d=0;
        for(long i=1;i<n;i++)
        {
            c=a*3+b*2;
            d=a*2+b*2;
            b=d%k;
            a=c%k;
        }
        return (int)((a+b)%k);
    }
}
