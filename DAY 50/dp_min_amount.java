public /*Skandhanshi Infra Township constructed N Villas in a row.
They planned to paint the villas with three colors, 
snow-white, sky-blue and light-green. 
And adjacent villas should not paint with same color.

You are given the cost of painting each villa with these colors, cost[N][3].
cost[i][0] is cost of painting with snow-white.
cost[i][1] is cost of painting with sky-blue.
cost[i][2] is cost of painting with light-green.
where, 0 <= i < N.

Your task is to find the minimum cost to paint all the villas.

Input Format:
-------------
Line-1: An integer N, number of villas.
Next N lines: 3 space separated integers, cost to paint the villas.

Output Format:
--------------
Print an integer, minimum cost to paint all the villas.


Sample Input:
---------------
3
17 2 17
16 4 5
14 3 19

Sample Output:
----------------
10

Explanation: 
------------
1st Villa painted with sky-blue, 2nd Villa painted with light-green,
3rd Villa painted with sky-blue.
Minimum cost: 2 + 5 + 3 = 10.

*/
import java.util.*;
class Test{
    public static int getMinCost(int[][] cost,int n){
        int prev_sw = cost[0][0] , prev_sb = cost[0][1] , prev_lg = cost[0][2]; // cost for previous building
        int sw=0,sb=0,lg=0; //cost for cur building
        for(int i=1;i<n;i++){
            sw = Math.min(prev_sb,prev_lg)+cost[i][0];
            sb = Math.min(prev_sw,prev_lg)+cost[i][1];
            lg = Math.min(prev_sw,prev_sb)+cost[i][2];
            prev_sw = sw;
            prev_sb = sb;
            prev_lg = lg;
        }
        return Math.min(sw,Math.min(sb,lg));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cost = new int[n][3];
        for(int i=0;i<n;i++){
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }
        System.out.println(getMinCost(cost,n));
    }
}class dp_min_amount {
    
}
