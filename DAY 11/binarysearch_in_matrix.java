/*There are B bags containing N gold boxes each. In each bag, gold boxes are 
arranged  in ascending order of their weights strictly, create a method in 
such a way that we need to return the least weight of gold box which is 
common least weight in all the given bags.

If we don’t have any common least weighted gold box, among all the bags then return -1.

Input Format:
-------------
Line-1: Two integers B and N, number of bags and number of goldboxes in each Bag.
Next B lines: N space separated integers, weights of GoldBoxes.

Output Format:
--------------
Print the least weight of gold box, if found
Print -1, if not found.


Sample Input:
---------------
5 5
1 2 3 4 5
2 3 6 7 9
1 2 3 5 8
1 3 4 6 8 
2 3 5 7 8

Sample Output:
----------------
3
*/
import java.util.*;
import java.lang.*;
class ma{
    public static boolean bs(int arr[][],int k,int l,int r,int row)
    {
        while(l<r)
        {
            int mid=(l+r)/2;
            if(arr[row][0]==k)
            {
                return true;
            }
            else if(arr[row][r]==k)
            {
                return true;
            }
            else{
            if(arr[row][mid]==k)
            {
                return true;
            }
            else if(arr[row][mid]>k)
            {
                return bs(arr,k,l,mid-1,row);
            }
            else if(arr[row][mid]<k)
            {
                return bs(arr,k,mid+1,r,row);
            }
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int arr[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> h=new ArrayList<>();
            
            
            for(int j=0;j<m;j++){
            if(bs(arr,arr[0][i],0,n-1,j)==true)
            {
                //System.out.println("true "+arr[0][i]+" row is "+j);
                h.add(arr[0][i]);
            }
                
            }
            //System.out.println(h);
            if(h.size()==m)
            {
                for(int k:h){
                System.out.println(k);
                System.exit(0);
                }
               
            }
        }
        System.out.println(-1);
        System.exit(0);
    }
}
