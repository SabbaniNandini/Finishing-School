/*Amith decided go on a holiday trip. 
Given a map of N holiday spots numbered 0,1,2,.. N-1, map shows the connecting 
routes between the holiday sopts, the routes are bidirectional, and
the connecting routes are indicates as routes[i] = [from , to , distance ]. 
He can travel only a certian distance D.

Your task is to find the holiday spot H with the smallest number of holiday-spots
that are reachable from H and whose distance is at most D, 

If there are multiple holiday spots, return H with the greatest number.


Input Format:
-------------
Line-1 : Three integers, N number of holiday spots, R is the number of connecting 
        routes and D is the distance can travel.
Next R lines : Three space separated integers, from , to and distance.

Output Format:
--------------
Print an integer, holiday spot.


Sample Input-1:
---------------
4 4 4
0 1 3        
1 2 1
1 3 4
2 3 1

Sample Output-1:
----------------
3


Explanation:
------------
Distance can travel= 4,

From			Reachable sopts
-------------------------------------
Holiday-spot 0 -> [Holiday-spot 1, Holiday-spot 2] 
Holiday-spot 1 -> [Holiday-spot 0, Holiday-spot 2, Holiday-spot 3] 
Holiday-spot 2 -> [Holiday-spot 0, Holiday-spot 1, Holiday-spot 3] 
Holiday-spot 3 -> [Holiday-spot 1, Holiday-spot 2] 

Holiday-spots 0 and 3 have 2 reachable Holiday-spots at a distance = 4, 
but we have to return Holiday-spot 3 since it has the greatest number.


Sample Input-2:
---------------
5 6 2
0 1 2
0 4 8
1 2 3
1 4 2
2 3 1
3 4 1

Sample Output-2:
----------------
0

Explanation:
------------
Distance can travel= 2,

From			Reachable sopts
-------------------------------------
Holiday-spot 0 -> [Holiday-spot 1] 
Holiday-spot 1 -> [Holiday-spot 0, Holiday-spot 4] 
Holiday-spot 2 -> [Holiday-spot 3, Holiday-spot 4] 
Holiday-spot 3 -> [Holiday-spot 2, Holiday-spot 4]
Holiday-spot 4 -> [Holiday-spot 1, Holiday-spot 2, Holiday-spot 3]

Holiday-spots 0 has 1 reachable Holiday-spot at a distance = 2, 
*/
import java.util.*;
import java.lang.*;
public class ma{
    

    public static int dijkstra(int n, int[][] arr, int d) {	
        Map<Integer, Map<Integer, Integer>> h = new HashMap<>();
    	for (int[] a : arr) {
    		if (!h.keySet().contains(a[0]))
    			h.put(a[0], new HashMap <>());
    		
    	h.get(a[0]).put(a[1], a[2]);
    		
    		if (!h.keySet().contains(a[1]))
    			h.put(a[1], new HashMap <>());
    		
    		h.get(a[1]).put(a[0], a[2]);
    	}
    	
    	int min = Integer.MAX_VALUE;
    	int res = -1;
    	
    	for (int i = 0; i < n; i++) {
    		Queue <int[]> pq = new PriorityQueue <>((a,b) -> (Integer.compare(a[1], b[1])));
    		boolean[] visited = new boolean [n];
    		int count = 0;
    		pq.add(new int[] {i, 0});
    		
    		while(!pq.isEmpty()) {
    			int[] cur = pq.poll();
    			int curNode = cur[0];
    			int curDist = cur[1];
    			
    			if (visited[curNode])
    				continue;
    			
    			visited[curNode] = true;
    			
    			count ++;
    			
    			if (h.keySet().contains(curNode)) {
        			for (int adj : h.get(curNode).keySet()) {
        				if (!visited[adj] && curDist +h.get(curNode).get(adj) <= d)
        					pq.add(new int[] {adj, curDist + h.get(curNode).get(adj)});
        			}
    			}
    		}
    		
    		if (count - 1 <= min) {
    			min = count - 1;
    			res = i;
    		}
    	}
    	
    	return res;
}
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int d=sc.nextInt();
        int arr[][]=new int[m][3];
        int dist[][]=new int[n][n];
        for(int i=0;i<m;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            arr[i][0]=a;
            arr[i][1]=b;
            arr[i][2]=c;
            if(c<=d){
            dist[a][b]=c;
            dist[b][a]=c;
            }
        }
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            ar.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            ar.get(arr[i][0]).add(arr[i][1]);
            ar.get(arr[i][1]).add(arr[i][0]);
        }
       System.out.println(dijkstra(n,arr,d)); 
    }
}
