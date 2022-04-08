/*You are given a square box with square cubes in it.
Each cube of size 1*1*1, and colored with either yellow or blue.
yellow cube represented by 1 and blue cube represented by 0.

In one operation, You can choose any two adjacent horizontal lines of cubes in 
the box and swap them. The box is said to be diagonal box, if all the square 
cubes above the main diagonal are blue colored.

Your task is to find the the minimum number of operations needed to arrange 
the box as diagonal box , if it is not possible to arrange return  -1.

The main diagonal of a box is the diagonal that starts at cube (0, 0) and
ends at cube (n-1, n-1) .

Input Format:
-------------
Line-1: An integer, N size of the box.
Next N lines: N space separated integers, colors of the cubes in the box.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3
0 1 0
1 0 1
1 0 0

Sample Output-1:
----------------
2

Explanation:
------------
Please do look at the Hint.


Sample Input-2:
---------------
4
1 1 0 0
1 0 1 0
0 1 0 0
1 0 1 0

Sample Output-2:
----------------
-1
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static int greedy(int[][] grid) {
        int n = grid.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int zeroCnt = 0;
            boolean updated = false;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    zeroCnt++;
                } else {
                    arr[i] = zeroCnt;
                    updated = true;
                    break;
                }
            }
            if (!updated) {
                arr[i] = zeroCnt;
            }            
        }

        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = arr[i];
        }

        Arrays.sort(arr);
        int target = n - 1;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < target) {
                return -1;
            }
            target--;
        }
        
        int res = 0;

        int i = 0; // index of arr1

        for (int t = n - 1; t >= 0; t--) {
            if (arr1[i] >= t) {
                i++;
                continue;
            }            
            int j = i + 1;
            for (; j < n; j++) {
                if (arr1[j] >= t) {
                    break;
                }
            }
            int cur = arr1[j];
            for (int k = j; k > i; k--) {
                arr1[k] = arr1[k - 1];
            }
            arr1[i] = cur;
            res+= j - i;
            i++;
        }
        return res;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(greedy(arr));
}
}
