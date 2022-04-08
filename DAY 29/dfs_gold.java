import java.util.*;
import java.lang.*;

class ma{
    static int maxGold;
    public static int getMaximumGold(int[][] grid) {
        maxGold = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] != 0) {
                    int[][] visited = new int[m][n];
                    getMaxGold(grid, visited, grid[i][j], i, j);
                }
            }
        }
        return maxGold;
    }
    
    public static void getMaxGold(int[][] grid, int[][] visited, int curr, int i, int j) {
        maxGold = Math.max(maxGold, curr);
        int m = grid.length;
        int n = grid[0].length;
        
        visited[i][j] = 1;
        if(i<m && j<n) {
			// Check if the grid cell not already visited and grid value non-zero 
            if(i-1>=0 && visited[i-1][j] != 1 && grid[i-1][j] != 0) // left
                getMaxGold(grid, visited, curr+grid[i-1][j], i-1, j);
            if(j-1>=0 && visited[i][j-1] != 1 && grid[i][j-1] != 0) // up
                getMaxGold(grid, visited, curr+grid[i][j-1], i, j-1);
            if(i+1<m && visited[i+1][j] != 1 && grid[i+1][j] != 0) // down
                getMaxGold(grid, visited, curr+grid[i+1][j], i+1, j);
            if(j+1<n && visited[i][j+1] != 1 && grid[i][j+1] != 0) // left
                getMaxGold(grid, visited, curr+grid[i][j+1], i, j+1);
        }
        visited[i][j] = 0;
    }
    public static  void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int grid[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println(getMaximumGold( grid));
        
    }
    
}
