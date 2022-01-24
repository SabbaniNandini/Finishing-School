/*Thomas constructing a Tree of N nodes, nodes labelled as 0, 1, 2, .. ,n-1.
He is given a list of N-1 edges[], where edge[i]=[v1, v2], is an undirected 
edge between v1 and v2.

He can construct the tree by selecting any node as root node. Your task is
to find out the trees with the smallest height, among all the trees. 
Print the root nodes of all the smallest height trees in ascending order.

NOTE: A Tree, is a connected graph without simple cycles.

Input Format:
-------------
Line-1: An integer N, number of nodes.
Next N-1 lines: Two integers, represent an edge.

Output Format:
--------------
Print the list of root nodes of Smallest Height Trees in ascending order


Sample Input-1:
---------------
4
0 1
2 1
1 3

Sample Output-1:
----------------
[1]

Explanation:
-------------
For Tree Combinations look at the hint.


Sample Input-2:
---------------
6
3 0
1 3
3 2
4 3
5 4

Sample Output-2:
----------------
[3, 4]
*/
import java.util.*;
import java.lang.*;
class ma{
    public static void minheight(int n,int [][]edges,ArrayList<Integer> ans)
    {
        if(n<=0) return ;
        
        if(n==1){
            ans.add(0);
            return ;
        }
        
        int rank[] = new int [n];
        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int e[] : edges){
            rank[e[0]]++;
            rank[e[1]]++;
            
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(rank[i]==1) q.add(i);
        }
        
        while(n>2){
            int size=q.size();
            n-=size;
            
            while(size-->0){
                int temp = q.poll();
                
                for(int i=0;i<adj.get(temp).size();i++){
                    rank[adj.get(temp).get(i)]--;
                    if(rank[adj.get(temp).get(i)]==1) q.add(adj.get(temp).get(i));
                }
            }
        }
        ans.addAll(q);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n-1][2];
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<2;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        minheight(n,arr,ans);
        System.out.println(ans);
    }
}

