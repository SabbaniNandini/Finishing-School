/*Given N satellite stations, numbered 1 to N.
These satellites are connected to send signals from one to other.
To send a signal from satellite 's' to satellite 'd', it takes 
an amount of time 't'.

You are given a list of travel times as directed edges times[i] = (s, d, t).

Your task to find the time taken to recieve signal from a satellite station K, 
to all N-1 satellite stations. If it is impossible, return -1 .

Input Format:
-------------
Line-1 ->   Three integers, N number of satellite stations, 
            K is the satellite to send signal and T is the number of edges.
Next T lines -> Three space separated integers, 's' is the source, 
            'd' is the destination, 
			't' is the time taken recieve signal from 's' to 'd'.

Output Format:
--------------
Print an integer as your result.


Sample Input-1:
---------------
4 2 3
2 1 1
2 3 1
3 4 1

Sample Output-1:
----------------
2


Sample Input-2:
---------------
5 2 4
2 1 1
2 3 2
3 4 3
5 1 4

Sample Output-2:
----------------
-1


Sample Input-3:
---------------
5 2 4
2 1 1
2 3 2
3 4 3
1 5 6

Sample Output-3:
----------------
7
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void dijkstras(List<List<Integer>> ar,int time[][],int a,int b,int c)
    {
        ArrayDeque<Integer> pq=new ArrayDeque<>();
        pq.offerLast(b);
        int dist[]=new int[a+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[b]=0;
        while(!pq.isEmpty())
        {
           int n=pq.size();
           for(int i=0;i<n;i++)
           {
               int cur=pq.pollFirst();
               for(int j=0;j<ar.get(cur).size();j++)
               {
                   int temp=dist[cur]+time[cur][ar.get(cur).get(j)];
                   if(dist[ar.get(cur).get(j)]>temp)
                   {
                      dist[ar.get(cur).get(j)]=temp ;
                      pq.offerLast(ar.get(cur).get(j));
                   }
               }
           }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=a;i++)
        {
            ans=Math.max(ans,dist[i]);
        }
        if(ans==Integer.MAX_VALUE)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(ans);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int arr[][]=new int[c][2];
        int time[][]=new int[a+1][a+1];
        for(int i=0;i<c;i++)
        {
           arr[i][0]=sc.nextInt();
           arr[i][1]=sc.nextInt();
           time[arr[i][0]][arr[i][1]]=sc.nextInt();
        }
        List<List<Integer>> ar=new ArrayList<>();
        for(int i=0;i<=a;i++)
        {
            ar.add(new ArrayList<>());
        }
        
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<2;j++)
            {
                ar.get(arr[i][0]).add(arr[i][1]);
                
            }
        }
        dijkstras(ar,time,a,b,c);
    }
}
