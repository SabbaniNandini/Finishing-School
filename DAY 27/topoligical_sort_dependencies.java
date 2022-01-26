/*EA Sports, developed a video game. They designed a game in such a way that, 
there are L number of levels from 1 to L. There are D number of dependencies
where each dependency[m] = [ Xm, Ym ], represents a prerequisite relationship,
that is, in order to play level-Ym, you must have completed the level-Xm.

In one day you can complete any number of levels as long as you 
have completed all the prerequisites levels in the game. 

You cannont play a level-Ym which has some prerequisite level-Xm on same day.

Write a method to return the minimum number of days to complete all the levels
in the game. If there is no way to complete all the levels, return -1.


Input Format:
-------------
Line-1: An integer L, number of levels.
Line-2: An integer D, number of dependencies.
Next D lines: Two space separated integers, Xm and Ym.

Output Format:
--------------
An integer, the minimum number of days to complete all the levels in the game.


Sample Input-1:
---------------
3
2
1 3
2 3

Sample Output-1:
----------------
2

Explanation-1:
--------------
On the first day, levels 1 and 2 are completed. 
On the second day, level-3 is completed.


Sample Input-2:
---------------
3
3
1 2
2 3
3 1

Sample Output-2:
----------------
-1

Explanation-2:
-------------
No level can be completed because they depend on each other.
*/
import java.util.*;

public class ma{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Queue<Integer> q=new LinkedList<>();
        int n=sc.nextInt(),m=sc.nextInt();
        int level=0;
        int[] indegree=new int[n+1];
        int[][] arr=new int[n+1][n+1];
        
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(arr[a][b]==0){
            indegree[b]++;
            }
            arr[a][b]=1;
        }
        
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int temp=q.size();
            for(int j=0;j<temp;j++){
            int curr=q.poll();
            for(int i=1;i<=n;i++){
                if(arr[curr][i]==1){
                    if(--indegree[i]==0){
                        q.offer(i);
                    }
                }
            }
            }
            level++;
        }
        for(int i:indegree){
            if(i>0){
                System.out.println("-1");
                return;
            }
        }
        System.out.println(level);
    }
}