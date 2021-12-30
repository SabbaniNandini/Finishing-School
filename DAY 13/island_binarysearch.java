/*A group of people planned to go an Island for New Year celebrations, 
They have arrived at a boating point to reach the Island. All of them 
formed in a line to get into the boat, and you are given their weights 
as an array Weights[], where i-th person weight is Weights[i].

Each boat can carry only few people whose total weight is atmost W.
Each person get into the boat according to the given order only.
The boat takes T number of trips to transport all the people of the group.

You will be given the weights of the people in the line, and number of trips T.
Now, its your turn to find out the minimum weight, the boat can carry, 
So that the boat can transport all the people to cross the river.

Input Format:
-------------
Line-1: Two space separated integers, N and T, Number of people and T trips.
Line-2: N space separated integers, weights of the people.

Output Format:
--------------
Print an integer, minimum weight, the boat can carry.


Sample Input-1:
---------------
6 3
3 2 3 4 1 5

Sample Output-1:
----------------
7

Explanation:
------------
A boat can carry a weight 7 is the minimum to transport all the people in 3 trips:
trip-1: 3, 2
trip-2: 3, 4
trip-3: 1, 5


Sample Input-2:
---------------
8 4
1 2 3 4 5 6 7 8

Sample Output-2:
----------------
11

Explanation:
------------
A boat can carry a weight 11 is the minimum to transport all the people in 4 trips:
1st day: 1, 2, 3, 4
2nd day: 5, 6
3rd day: 7
4th day: 8

Note that the people must be transported in the order given, so using a
boat can carry a weight 10 and splitting the packages into parts like 
(8, 1), (7, 2), (6, 3), (5, 4) is not allowed.
*/
import java.util.*;
import java.lang.*;
class ma{
    public static int bs(int arr[],int n,int l,int h,int trip)
    {
        int max=0;
        int ans=0;
        int ind=0;
        while(l<=h)
        {
            
            int mid=(l+h)/2;
            //System.out.println(" l is "+l+" h is "+h+" mid is "+mid);
            
             ind=add(arr,n,l,h,mid,trip,max);
            
            if(ind==1)
            {
            
               l=mid+1;
            }
            else if(ind==-1)
            {
                h=mid-1;
            }
            else
            {
                ans=mid;
                h=mid-1;
            }
        }
        return ans;
    }
    public static int add(int arr[],int n,int l,int h,int w,int k,int max)
    {
        int i=0;
        int sum=0;
        int t=0;
        max=0;
        while(i<n)
        {
            while(i<n&&sum+arr[i]<=w){
           sum=sum+arr[i] ;
           //System.out.println(" sum is "+sum+" i is "+i);
           i=i+1;
            }
           
            
            
            t++;
            //System.out.println(" t is "+t+" sum is "+sum);
            max=Math.max(max,sum);
            sum=0;
            
            
        }
        if(t==k)
            {
                return max;
            }
            else if(t<k)
            {
                t=0;
                return -1;
            }
            else
            {
                t=0;
                return 1;
            }
        
    }
   public static void main(String[] args)
   {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int t=sc.nextInt();
       int arr[]=new int[n];
       int sum=0;
       int max=0;
       for(int i=0;i<n;i++){
           arr[i]=sc.nextInt();
           sum=sum+arr[i];
           max=Math.max(max,arr[i]);
       }
       System.out.println(bs(arr,n,max,sum,t));
   }
}
