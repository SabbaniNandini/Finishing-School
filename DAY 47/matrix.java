/*Venkatadri is a maths teacher.
He is teaching matrices to his students.
He is given a matrix of size m*n, and it contains only positive numbers.
He has given a task to his students to find the special matrix, 
in the iven matrix A[m][n].
A special matrix has following property:
	- The sum of elements in each row, each column and the two diagonals are equal.
	- Every 1*1 matrix is called as a special matrix.
	- The size of the special matrix should be a square, i.e., P*P.

Your task is to help the students to find the speical matrix  with max size P.


Input Format:
-------------
Line-1: Two space separated integers M and N, size of the matrix.
Next M lines: N space separated integers m and n.

Output Format:
--------------
Print an integer, maximum size P of the special matrix.


Sample Input-1:
---------------
5 5
7 8 3 5 6
3 5 1 6 7
3 5 4 3 1
6 2 7 3 2
5 4 7 6 2

Sample Output-1:
----------------
3

Explanation:
------------
The special matrix is:
5 1 6
5 4 3
2 7 3


Sample Input-2:
---------------
4 4
7 8 3 5
3 2 1 6
3 2 3 3
6 2 3 3

Sample Output-2:
----------------
2

Explanation:
------------
The special matrix is:
3 3
3 3
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int[][] rsum = new int[m][n+1];
        int[][] csum = new int[n][m+1];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rsum[i][j+1] = rsum[i][j]+mat[i][j];
                csum[j][i+1] = csum[j][i]+mat[i][j];
            }
        }
        int size = Math.min(m,n);
        int max = 1;
        while(size>1){
            for(int r = 0;r < m-size+1;r++){
                for(int c = 0;c<n-size+1;c++){
                    int val = rsum[r][c+size] - rsum[r][c];
                    if(check(rsum,csum,r,c,size,val)){
                        if(checkdiag(mat,r,c,size,val)){
                            max = Math.max(max,size);
                        }
                    }
                }
            }
            size-=1;
        }
        System.out.println(max);
        
    }
    static boolean checkdiag(int[][] mat,int r,int c,int size,int val){
        int d1 = 0;
        int d2 = 0;
        for(int i=0;i<size;i++){
            d1+=mat[r+i][c+i];
            d2+=mat[r+i][c+size-i-1];
        }
        if(val==d1 && val==d2){
            return true;
        }
        
        return false;
    }
    static boolean check(int[][] rsum,int[][] csum,int r,int c,int size,int val){
        for(int i=0;i<size;i++){
            if(val!=rsum[r+i][c+size]-rsum[r+i][c] || val!=csum[c+i][r+size]-csum[c+i][r]){
                return false;
            }
        }
        
        return true;
        
    }
}
