/*Crazy Mohan is interested to disturb the order of the items.
There is a number N, each digit of the number is printed on a cube
and arranged accordingly in a row. Now, Crazy Mohan is allowed to swap 
the positions of the cubes, It is not allowed to add or remove the cubes.

You have to stop Crazy Mohan, when you find the new sequence of the cubes 
forms a new number W, such that W>N and W should be minimum.

If it is possible to form W from N, print the value of W, otherwise print '-1'

Input Format:
-------------
An integer N, given number.

Output Format:
--------------
Print an integer, the next nearest higher number.


Sample Input-1:
---------------
121

Sample Output-1:
----------------
211


Sample Input-2:
---------------
321

Sample Output-2:
----------------
-1
*/
import java.util.*;
import java.lang.*;
class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int arr[]=new int[s.length()];
        for(int i=0;i<s.length();i++)
        {
            arr[i]=Character.getNumericValue(s.charAt(i));
        }
        //System.out.println(Arrays.toString(arr));
        int peak=-1;
        int n=arr.length;
        for(int i=1;i<n;i++)
        {
            if(arr[i]>arr[i-1]){
                peak=i;
            }
        }
        //System.out.println(peak);
        if(peak==-1)
        {
            System.out.println(-1);
        }
        else if(peak==n-1)
        {
            int temp=arr[n-1];
            arr[n-1]=arr[n-2];
            arr[n-2]=temp;
            for(int j=0;j<n;j++)
              {
                  System.out.print(arr[j]);
              }
        }
        else
        {
            int swap=peak;
            for(int i=peak;i<n;i++)
            {
                if(arr[i]>arr[peak-1]&&arr[i]<arr[peak])
                {
                    swap=i;
                }
            }
            int k=arr[peak-1];
            arr[peak-1]=arr[swap];
            arr[swap]=k;
              Arrays.sort(arr,peak,n); 
              for(int j=0;j<n;j++)
              {
                  System.out.print(arr[j]);
              }
        }
        
    }
}
