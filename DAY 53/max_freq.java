public /*Kilbil pandey is a sharp shooter. He is given a row of lamp posts with 
different heights, And He can shoot only lamps on top of the lamp posts.
Due to heights are different he can shoot the lamps, whose hieght is maximum.

In a single shot, he can break any number of lamps.

Find out and print the number of lamps, he can successfully break.

Input Format:
-------------
Line-1 -> An integers N. Number of lamp posts
Line-2 -> N space separated integers, heights of lamp posts.

Output Format:
--------------
Print an integer, the number of lamps, he can successfully break.


Sample Input-1:
---------------
4
3 2 1 3

Sample Output-1:
----------------
2


Sample Input-2:
---------------
10
18 90 90 13 90 75 90 8 90 43

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
        int arr[]=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            max=Math.max(max,arr[i]);
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==max)
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
