/*
Indian Super League organizing a football match at Eden Gardens.
The teams are Bangalore and Chennai are playing opposite each other.

After Match starts, each team making some goals at certain time, 
for example, goal 'goal[i]' was made by a player at time 'time[i]'.
goal[i]: indicates the team number 0 (Bangalore) or 1 (Chennai).
time[i]: indicates the time of the goal made.

Now, your task is to find out the leading team at given time t[j].

Input Format:
------------------
Line-1: Two integers N and K, no of goals-> goal[i] and no of times-> t[j]
Line-2: N space seperated integers only 0's and 1', goals[i]
Line-3: N space seperated integers, time[i]
Line-4: K space seperated integers , t[i]
 
Output Format:
------------------
Print K space seperated integers as result.


Sample Input-1:
---------------
7 5
0 1 1 0 0 1 0
0 5 10 15 20 25 30
3 12 25 15 24

Sample Output-1:
----------------
0 1 1 0 0

Explanation:
------------
At time 3, the goals are [0], and 0 is leading.
At time 12, the goals are [0,1,1], and 1 is leading.
At time 25, the goals are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent goal)
At time 15, the goals are [0,1,1,0], and 0 is leading (as ties go to the most recent goal)
At time 24, the goals are [0,1,1,0,0], and 0 is leading.
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static int bs(int arr[],int k)
    {
        int l=0;
        int h=arr.length-1;
        while(l<h)
        {
            int mid=(l+h)/2;
            //System.out.println(arr[mid]+" val is ");
            if(arr[mid]==k)
            {
                return arr[mid];
            }
            else if(arr[mid]<k)
            {
                l=mid+1;
            }
            else
            {
                h=mid-1;
            }
        }
        return arr[l];
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[]=new int[n];
        int a[]=new int[n];
        int t[]=new int[m];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++)
        {
            t[i]=sc.nextInt();
        }
        TreeMap<Integer,int[]> mp=new TreeMap<>();
        int one=0;
        int zero=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==0)
            {
                zero++;
            }
            else {
                one++;
            }
            mp.put(a[i],new int[]{zero,one,arr[i]});
        }
        /*for(int i:mp.keySet())
        {
            System.out.println(i+" + "+Arrays.toString(mp.get(i)));
        }*/
        for(int i=0;i<m;i++)
        {
            if(mp.containsKey(t[i]))
            {
                int temp[]=mp.get(t[i]);
                if(temp[0]==temp[1])
                {
                    System.out.print(temp[2]+" ");
                }
                else
                {
                    if(temp[0]>temp[1])
                    {
                        System.out.print(0+" ");
                    }
                    else
                    {
                        System.out.print(1+" ");
                    }
                }
               
            }
            else
            {
                //int x=bs(a,t[i]);
                //System.out.println(cur);
                int x=mp.lowerKey(t[i]);
                int temp[]=mp.get(x);
                if(temp[0]==temp[1])
                {
                    System.out.print(temp[2]+" ");
                }
                else
                {
                    if(temp[0]>temp[1])
                    {
                        System.out.print(0+" ");
                    }
                    else
                    {
                        System.out.print(1+" ");
                    }
                }
            }
        }
    }
}
