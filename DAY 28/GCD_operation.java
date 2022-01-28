/*Ramu is a milk supplier to Somu. He has only two aluminium cups 
of capacity m and n litres. Using these two cups only, 
he can measure the milk. He has to supply exactly P litres of milk to Somu.

To measure the milk, operations allowed are:
	- Fill one of the cups completely with milk.
	- Empty the other cup.
	- Pour milk from one cup into another cup till it fills completely,
	 or the first cup itself is empty.
	 
Such that, at the end one or both cups contains P litres of the milk.
	
Please help Ramu, to check whether P litres of milk can be measured
using the two cups or not.

Input Format:
-------------
3 space separated integers, m, n and P.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
3 5 4

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 4 5

Sample Output-2:
----------------
false
*/
import java.util.*;
import java.lang.*;
public class ma
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int p = sc.nextInt();
        boolean ans = false;
        if(m+n <p)
            ans= false;
        else
        {
            if(p% gcd(m,n)==0)
                ans= true;
            else
            ans= false;
        }
        System.out.println(ans);
    }
    public static int gcd(int p ,int q)
    {
        while(q!=0)
        {
            if(p>q) p= p-q;
            else q=q-p;
        }
        return p;
    }
}
