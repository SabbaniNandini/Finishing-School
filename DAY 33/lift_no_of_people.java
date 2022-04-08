/*In Dubai's Burj Khalifa, there is an elevator moves only in upwards direction, 
the elevator can carry N members.

The people are waiting for the elevator at different floors, made P requests, 
request[i] = [ num_people, enter_floor, exit_floor ], each request indicates, 
number of people to enter into elevator, entering floor number, 
exiting floor number.

Initially the elevator is empty.

Your task is to find and return true, iff it is possible to enter the people
into elevator and exit from elevator of all the requests made by the people.


Input Format:
-------------
Line-1 -> Two integers P and N, number of requests and number of members 
          can be carried by elevator.
Next N Lines -> three space separated integers, num_people, enter_floor, exit_floor.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 5
2 1 5
3 3 7

Sample Output-1:
----------------
true



Sample Input-2:
---------------
2 4
2 1 5
3 3 7

Sample Output-2:
----------------
false



Sample Input-3:
---------------
3 11
3 2 7
3 7 9
8 3 9

Sample Output-3:
----------------
true
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][]=new int[n][3];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<3;j++)
            {
                arr[i][j]=sc.nextInt();
            }
            max=Math.max(max,arr[i][2]);
        }
        int ans[]=new int[max+1];
        for(int i=0;i<n;i++)
        {
            int entry=arr[i][1];
            int exit=arr[i][2];
            for(int j=entry;j<exit;j++)
            {
                ans[j]=ans[j]+arr[i][0];
                if(ans[j]>m)
                {
                    System.out.println(false);
                    System.exit(0);
                }
            }
        }
        System.out.println(true);
        //Arrays.sort(arr, Comparator.comparingInt(row -> row[1]));
       /* for(int []k:arr)
        {
            System.out.println(Arrays.toString(k));
        }*/
       /* int count=0;
        for(int i=0;i<n-1;i++)
        {
            if(arr[i][2]==arr[i+1][1]||arr[i][2]<arr[i+1][1])
            {
                count=0;
            }
            else
            {
                count=count+arr[i][0];
                if(count>m)
                {
                    //System.out.println(" i is "+i+"count is "+count);
                    System.out.println(false);
                    System.exit(0);
                }
            }
        }
        count=count+arr[n-1][0];
        if(count>m)
                {
                   // System.out.println(" i is "+(n-1)+"count is "+count);
                    System.out.println(false);
                    System.exit(0);
                }
        System.out.println(true);*/
    }
}
