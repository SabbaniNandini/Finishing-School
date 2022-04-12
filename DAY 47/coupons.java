/*KMIT's Technical club- "recurse" developed a UPI payment system R-UPI.
R-UPI (Rupee) payments, offers a coupon for each payment made using it.
Each coupon will come with an expiry time. R-UPI has a utilization restriction 
over the coupons earned by the user, the limit is atmost one coupon per day.
And  the coupons alloted in a single day will have same expiry time.

Nagireddy, one of the user of R-UPI made few payments each day for N days.
and he received coupons for the same. The coupons earned in each day for N days 
is given as coupons[], where coupon[i] indicates number of coupons on i-th day.
And the expiry time in days is given as expdays[], where expdays[i] indicates,
expiry of i-th day coupons and expiry days includes the day the coupons earned. 
If no coupons on i-th day, then coupons[i]=0 and expdays[i]=0.

For example: if Nagireddy earns 2 coupons on day-3, He has to utilize them on 
day-3 and day-4, he can't utilize them on day-5.

You will be given an integer N, coupons[] and expdays[].
Your task is to findout the maximum number of coupons utilized by Nagireddy. 

NOTE: if N=5 and on day-5 you are left with few coupons, you can continue 
to utilize the remaining coupons before they get expired.

Input Format:
-------------
Line-1: An integer N, number of Coupons.
Line-2: N space separated integers, number of coupons each day.
Line-3: N space separated integers, i-th coupon expires in days[i] days. 

Output Format:
--------------
Print an integer, number of coupons you can utilize.


Sample Input-1:
---------------
5
1 3 4 2 2
2 1 2 4 3

Sample Output-1: bk
----------------
7

Explanation:
------------
Nagireddy can utilize 7 coupons in total,
	- On day-1, he can use 1 coupon received on day-1.
	- On day-2, he can use 1 coupon received on day-2 and remaining 2 coupons expired.
	- On day-3, he can use 1 coupon received on day-3 and remains 3 coupons.
	- On day-4, he can use 1 coupon received on day-3 and 
	  remains with 2 coupons earned on day-4.
	- On day-5, he can use 1 coupon received on day-4 and 
	  remains with 3 coupons earned on day-4 and 2 coupons earned on day-5
	- On day-6, he can use 1 coupon received on day-5 and 
	  remains with 3 coupons earned on day-4 and coupons earned on day-5 expired.
	- On day-7, he can use 1 coupon received on day-4 and 
	  2 coupons remained on day-4 expires.


Sample Input-2:
---------------
6
2 0 0 1 0 3
1 0 0 2 0 2

Sample Output-2:
----------------
4

Explanation:
------------
Nagireddy can utilize 4 coupons in total,
	- On day-1, he can use 1 coupon received on day-1, and 1 coupon expired.
	- On day-2 and day-3, he don't have any coupons
	- On day-4, he can use 1 coupon received on day-4 and no coupons left.
	- On day-5, he don't have any coupons
	- On day-6, he can use 1 coupon received on day-6 and 
	  remains with 1 coupons earned on day-6.
	- On day-7, he can use 1 coupon received on day-6 and 
	  the remaining 1 coupon expired.
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int exp[]=new int[n];
        
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            
        }
        for(int i=0;i<n;i++)
        {
            exp[i]=sc.nextInt();
        }
        int count=0;
        int temp=1;
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                return Integer.compare(a[1],b[1]);
            }
            });
            for(int i=0;i<n;i++)
            {
                if(arr[i]>0)
                {
                    pq.offer(new int[]{arr[i],i+1,i+exp[i]});
                
                }
            }
            while(pq.size()!=0)
            {
                int t[]=pq.poll();
                if(t[1]<=temp)
                {
                    if(t[2]>=temp){
                        count++;
                        temp++;
                        t[0]--;
                        if(t[2]>=temp&&t[0]>0)
                        {
                            pq.offer(t);
                        }
                    }
                    
                }
                else
                {
                    pq.offer(t);
                    temp=t[1];
                }
            }
            System.out.println(count);
    }
}