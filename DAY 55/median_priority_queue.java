/*Given a list of integers points[], the points earned or lost by N persons.

A point[a], is said to be better than a point[b],
if mod(point[a] - med) > mod(point[b] - med), where med is the median of points.
If mod(point[a] - med) == mod(point[b] - med), then point[a] is said to be 
better than point[b], if point[a] > point[b].

Median is the middle value in an ordered integer list. More formally,
if the length of the list is N, the median is the element in position 
((N - 1) / 2) in the sorted list (0-indexed).

For Example,
points[]= [7, -3, 9, 8, 1], N = 5 and the median is med = ((5 - 1) / 2) = 2. 
The element at median is points[med]= 7, as sorted list is [-3, 1, 7, 8, 9]

Your task is to return P number of better values from the points[] list.
Return the answer in sorted order.

Input Format:
-------------
Line-1: Two space seperated integers, N and P
Line-2: N space separated integers points[].

Output Format:
--------------
Print the list of integers in sorted order.


Sample Input-1:
---------------
5 2
2 3 4 5 6           2 1 0 1 2 

Sample Output-1:
----------------
2 6

Explanation:
------------
The better 2 elements are [2, 6].
Please note that although mod(6 - 4) == mod(2 - 4) but 6 is better than 2
because 6 > 2.


Sample Input-2:
---------------
6 4
3 4 9 4 3 5           6 5 0 5 6  4

Sample Output-2:
----------------
3 3 5 9
*/
import java.util.*;
import java.lang.*;
class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        ArrayList<Integer> ans=new ArrayList<>();
        int k=(n-1)/2;
        int med=arr[k];
         PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[1]==b[1])?(b[0]-a[0]):b[1]-a[1]);
         for(int i=0;i<n;i++)
         {
             pq.offer(new int[]{arr[i],Math.abs(arr[i]-med)});
         }
         while(!pq.isEmpty()&&p-->0)
         {
             ans.add(pq.poll()[0]);
         }
         Collections.sort(ans);
         System.out.println(ans);
    }
}
