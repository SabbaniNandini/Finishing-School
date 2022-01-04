/*You are given a list of N integers List[], list contains both +ve and -ve integers.
Your task is to findout, the Highest Product possible,
Where the product is the product of all the elements of contiguous sublist sList[],
and sublist should conatin atleast 1 integer.

Input Format:
-------------
Line-1: An integer N.
Line-2: N space separated integers, List[].

Output Format:
--------------
Print an integer output, the highest product.

Sample Input-1:
---------------
4
2 3 -2 4

Sample Output-1:
----------------
6

Explanation:
------------
Product of contiguous sub list [2,3].


Sample Input-2:
---------------
3
-2 0 -3

Sample Output-2:
----------------
0

Explanation:
------------
Product of sub list [0], where [-2,-3] is not a contiguous sublist
*/
import java.util.*;
import java.lang.*;
class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int curmax=Integer.MIN_VALUE;
        int curmin=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        curmin=arr[0];
        curmax=arr[0];
        for(int i=1;i<n;i++)
        {
            int temp = Math.max(arr[i], Math.max(arr[i] * curmax, arr[i] * curmin));
        curmin = Math.min(arr[i], Math.min(arr[i] * curmax, arr[i] * curmin));
        curmax= temp;
        max = Math.max(max, curmax);
        }
        System.out.println(max);
    }
}
