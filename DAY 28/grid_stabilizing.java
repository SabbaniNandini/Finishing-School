/*AMB mall to attract kids and to increase their economy they came to have 
a separate Fun Zone. They opened a stall by name Soda Bears. We have an 
LED display panel with different colours of Soda bears.

You will be given a 2D integer panel representing the grid of a 
Soda bears, we have different color-codes as positive integer in 
panel [p][q] of each coloured soda bears. If a cell in 
panel[p][q]=0 representing at position (p,q) is empty. 

The given panel represents the state of game according to participants move. 
Now it’s your aim to make panel to a stable state by merging Soda Bears 
with certain conditions:

1. If three or more soda bears of the same colour are adjacent 
vertically or horizontally,"merge" them all at the same time - 
these locations become empty.

2. After merging all Soda Bears simultaneously, if an empty space on
the panel has soda bears on top of itself, then these bears will drop
until they hit another bear or bottom at the same time. 
(No new soda bear will drop outside the top boundary.)

3. After the above steps, there may exist more bears that can be merged. 
If so, you need to repeat the above steps.

4. If there does not exist more bears for merge (ie. the panel is stable), 
then return the current panel.

Repeat the procedure for stable panel, then return the current panel state.

Input Format:
-------------
Line-1: Two space separated integers, M and N size of panel
Next M lines: N space separated integers, color codes of soda bears.

Output Format:
--------------
Print the stable format of panel.


Sample Input:
--------------
8 4
11 5 13 5
12 13 5 13
1 2 3 4
11 2 3 4
2 2 2 5
13 13 3 4
14 13 13 14
12 12 11 13

Sample Output:
----------------
0 0 0 5
11 0 0 13
12 0 0 4
1 0 0 4
11 0 13 5
13 0 5 4
14 5 13 14
12 12 11 13
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int grid[][] = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int ans[][] = new int[r][c];
        ans = stabilize(grid,r,c);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static int[][] stabilize(int[][] grid,int r,int c){
        boolean flag=false;
        for(int i=0;i<r;i++){
            for(int j=0;j<c-2;j++){
                int a = Math.abs(grid[i][j]);
                int b = Math.abs(grid[i][j+1]);
                int d = Math.abs(grid[i][j+2]);
                if(a==b && a==d && b==d && a!=0){
                    grid[i][j]=grid[i][j+1]=grid[i][j+2]=(-1)*Math.abs(grid[i][j]);
                    flag=true;
                }
            }
        }
        for(int i=0;i<r-2;i++){
            for(int j=0;j<c;j++){
                int a = Math.abs(grid[i][j]);
                int b = Math.abs(grid[i+1][j]);
                int d = Math.abs(grid[i+2][j]);
                if(a==b && a==d && b==d && a!=0){
                    grid[i][j]=grid[i+1][j]=grid[i+2][j]=(-1)*Math.abs(grid[i][j]);
                    flag=true;
                }
            }
        }
        for(int j=0;j<c;j++){
            int level=r-1;
            for(int i=r-1;i>=0;i--){
                if(grid[i][j]>0){
                    grid[level][j] = grid[i][j];
                    level--;
                }
            }
            for(int i=0;i<=level;i++){
                grid[i][j]=0;
            }
        }
        if(flag==false) return grid;
        else return stabilize(grid,r,c);
    }
}
