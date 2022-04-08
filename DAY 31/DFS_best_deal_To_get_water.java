/*As the summer season is started, the people in Hyderbad will suffer due to
water crisis. To help the citizen of Hyderabad, GHMC planned to supply the 
water using water tanks. As a pilot project, GHMC selected R routes and 
covering L locations.

To serve a water tank request by the citizen, the tank has to take 
the planned routes by GHMC, Each Route[i] => ['src','des','amt'], start 
from a source 'src' to a destination 'des' and the amount to supply 
water'amt' between src and dest.
 
Now help the citizen of hyderabd to find a best route to order a water tank
with a best deal in such a way that, if you are given all the locations and 
routes information, combined with starting location as source ‘LOC1’ and 
the destination ‘LOC2’.

Your task is to find the best deal to supply the water tanks from source to 
destination with at most ‘H’ halts. If there is no desired route found to 
supply water tank, print -1.

NOTE: if there are L locations, the locations are indexed as: 0,1,2,..,L-1.

Input Format:
-------------
Line-1: Two integers L and R, L number of locations, and H halts.
Next L lines: 3 space separated integers, src, des,  amt per water tank. 
Next line: 3 space separated integers, LOC1, LOC2, S.

Output Format:
--------------
Print an integer, best deal to get a water tank.


Sample Input-1:
---------------
3 3
0 1 50
1 2 50
0 2 250
0 2 1

Sample Output-1:
----------------
100

Explnation:
-------------
source location is '0' and destination is '2', and no.of halts are 1.
Option-1 : you can start at location-0  to location-1, 1 halt at location-1
           and the start from location-1 to location-2, 
	       amount per water tank is 100
Option-2 : you can start at location-0  to location-2 directly, 
           amount per water tank is 250, So best deal is 100.


Sample Input-2:
---------------
3 3
0 1 50
1 2 50
0 2 250
0 2 0

Sample Output-2:
----------------
250

Explnation:
-------------
source location is '0' and destination is '2', and no halts.
So, you have to start at location-0  to location-2 directly, 
amount per water tank is 250. So best deal is 250.
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void dfs(int src,int dest,ArrayList<ArrayList<Integer>> a,int k,int halts,HashMap<String,Integer> h,int amt,int ans)
    {
        for(int i=0;i<a.get(src).size();i++)
        {
            int temp=0;
            //System.out.println(" src "+a.get(src).get(i)+" dest "+dest);
            if(a.get(src).get(i)==dest&&k==halts)
            {
                temp=ans;
                //System.out.println(ans);
                ans=ans+h.get(src+"+"+a.get(src).get(i));
               // System.out.println(ans+h.get(src+"+"+a.get(src).get(i)));
               System.out.println(amt+h.get(src+"+"+a.get(src).get(i)));
                System.exit(0);
                return ;
            }
            //System.out.println(amt+h.get(src+"+"+a.get(src).get(i)));
            dfs(a.get(src).get(i),dest,a,k+1,halts,h,amt+h.get(src+"+"+a.get(src).get(i)),ans);
            
    
            //ans=temp;
        }
        return ;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[][]=new int[m][3];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<3;j++)
            {
                a[i][j]=sc.nextInt();
                //System.out.print(a[i][j]+" ");
            }
            //System.out.println();
        }
        
        int src=sc.nextInt();
        int dest=sc.nextInt();
        int halts=sc.nextInt();
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            ar.add(new ArrayList<>());
        }
        HashMap<String,Integer> h=new HashMap<>();
        for(int i=0;i<m;i++)
        {
        
            ar.get(a[i][0]).add(a[i][1]);
            h.put(a[i][0]+"+"+a[i][1],a[i][2]);
        }
       // System.out.println(h);
   //System.out.println(ar);
   int k=0;
   int amt=0;
   int ans=0;
   dfs(src,dest,ar,k,halts,h,amt,ans);
  //System.out.println(amt);
  System.out.println(-1);
    }
}
