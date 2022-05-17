/*Given a sorted list of integers E[], and two integers  L and U
Where L <= E[i]  <= U.

Your task is to find the ranges, which are not present in the given list
and print all the ranges

For example:
Given list is [ 1, 2, 4, 51, 52, 53, 92, 93, 94, 95 ] and L=1 U=100: 
The ranges which are not present are [3, 5->50, 54->91, 96->100]

Note: List E contain no duplicates.

Input Format:
-------------
Line-1 -> Space separated integers in sorted order

Output Format:
--------------
Print the list of ranges.


Sample Input-1:
---------------
0 1 2 3 4 5 8 9 10
0 20

Sample Output-1:
----------------
[6->7, 11->20]


Sample Input-2:
---------------
1 2 4 51 52 53 92 93 94 95
1 100

Sample Output-2:
----------------
[3, 5->50, 54->91, 96->100]
 
*/

import java.util.*;
import java.lang.*;
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
        int n=sc.nextInt();
        int m=sc.nextInt();
        //System.out.println(Arrays.toString(arr));
        ArrayList<Integer> ar=new ArrayList<>();
        for(int i=n;i<=m;i++)
        {
            ar.add(i);
        }
        for(int i=0;i<arr.length;i++)
        {
            int cur=ar.indexOf(arr[i]);
            ar.remove(cur);
        }
        //System.out.println(ar);
        ArrayList<String> ans=new ArrayList<>();
        int x=0;
        while(x<ar.size()){
            int temp=x;
            int k=ar.get(x);
            while(temp+1<ar.size()&&ar.get(temp)-ar.get(temp+1)==-1)
            {
               temp++; 
            }
            if(ar.get(x)==ar.get(temp))
            {
                ans.add(ar.get(x)+"");
            }
            else
            {
             ans.add(ar.get(x)+"->"+ar.get(temp));   
            }
            
            x=temp+1;
        }
        System.out.println(ans);
    }
}

