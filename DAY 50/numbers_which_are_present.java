/*Given a sorted list of integers, 

Your task is to find the continuous range of numbers, make them as groups
and print all the groups as show in the sample testcases.

For example:
Given list is [ 1, 2, 3 ]: 1, 2, 3 is continuous range, grouped as 1->3
Given list is [ 1, 2, 4, 5, 7 ]: 1, 2 is continuous range, grouped as 1->2, 
4,5 grouped as 4->5, 7 is left alone.

Note: List contain no duplicates.

Input Format:
-------------
Line-1 -> Space separated integers in sorted order

Output Format:
--------------
Print the list of continuous range groups.


Sample Input-1:
---------------
1 2 4 5 7

Sample Output-1:
----------------
[1->2, 4->5, 7]

Explanation: 
------------
1,2 form a continuous range; 4,5 form a continuous range.


Sample Input-2:
---------------
1 2 3 5 6 7 9 10 12

Sample Output-2:
----------------
[1->3, 5->7, 9->10, 12]

Explanation: 
------------
1,2,3 form a continuous range 
5,6,7 form a continuous range
9,10 form a continuous range
*/
import java.util.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String a[]=str.split(" ");
        int arr[]=new int[a.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=Integer.parseInt(a[i]);
        }
        ArrayList<String> ar=new ArrayList<>();
        int x=0;
        while(x<arr.length)
        {
            int temp=x;
            while(temp+1<arr.length&&arr[temp]-arr[temp+1]==-1)
            {
                temp++;
            }
            if(arr[x]==arr[temp])
            {
                ar.add(arr[x]+"");
            }
            else
            {
                ar.add(arr[x]+"->"+arr[temp]);
            }
            x=temp+1;
        }
        System.out.println(ar);
    }
}
