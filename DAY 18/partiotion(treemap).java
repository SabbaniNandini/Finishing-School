/*In a class of XII, computer teacher asked one of the student 
to perform a task as practical session .

There is a box contains N balls in it, each ball is printed 
with a positive integer. The teacher ask the student to split 
all the balls in the box into ball-groups,
each group should contain exatly S balls.

The student has to pick the ball-groups as follows:
	- the balls should be numbered consecutively.
	e.g., 1,2 3, 4 or 4,5,6,7 etc.

Finally, the student should say whether it is possible to 
split all the balls in the box, into ball-groups accordingly.

Now, its your task to help the student to find whether it is possible or not.
if possible, print "true".
otherwise, print "false".


Input Format:
-------------
Line-1: Two integers N and S, number of balls and size of ball-group.
Line-2: N space separated integers, integers printed on each ball.

Output Format:
--------------
Print a boolean value, whether it is possible to split all the balls into groups.


Sample Input-1:
---------------
*
8 4
2 6 3 4 3 5 4 5

Sample Output-1:
----------------
true

Explanation:
-------------
Ball-groups are [2,3,4,5] and [3,4,5,6]


Sample Input-2:
---------------
12 3
12 2 9 5 3 4 13 7 6 8 11 7

Sample Output-2:
----------------
true

Explanation:
-------------
Ball-groups are [2,3,4], [5,6,7], [7,8,9] and [11,12,13]


Sample Input-3:
---------------
6 3
2 5 7 3 4 8

Sample Output-3:
----------------
false

Explanation:
-------------
you cannot form ball groups.
*/
import java.util.*;
import java.lang.*;
class ma{
    public static boolean partition(int a[],int s,Map<Integer,Integer> h){
        if(a.length%s !=0)
            return false;
        int n = a.length/s,count=1;
        while(count<=n)
        {
            int start=0;
            for(Integer i :h.keySet())
            {
                start = i;
                if(h.get(i)>0)
                    break;
            }
            //System.out.println(start);
            for(int i=0;i<s;i++)
            {
                if(!h.containsKey(start) || h.get(start) ==0)
                    return false;
                else
                    h.put(start,h.get(start)-1);
                start++;
            }
            count++;
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        if(arr.length%m!=0)
        {
            System.out.println(false);
            System.exit(0);
        }
        TreeMap<Integer,Integer> h=new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            if(!h.containsKey(arr[i]))
            {
                h.put(arr[i],1);
            }
            else
            {
                h.put(arr[i],h.get(arr[i])+1);
            }
        }
         /*int p=arr.length/m;
         int count=1;
         while(count<=p){
        for(int x:h.keySet())
        {
           
            int y=h.get(x);
            if(y>0){
            for(int i=0;i<m;i++)
            {
              if(!h.containsKey(x+i)||h.get(x+i)<=0) 
              {
                 // System.out.println(" An error occured at "+y+" y+i is "+(x+i));
                 System.out.println(false);
                 System.exit(0);
              }
               /*if (h.get(x+i)<=0)
              {
                System.out.println(false);
                 System.exit(0);  
              }*/
              /*else{
               h.put(x+i,h.get(x+i)-1);
              }
               
            }
            }
        }
        count++;
         }*/
        System.out.println(partition(arr,m,h));
    }
}
