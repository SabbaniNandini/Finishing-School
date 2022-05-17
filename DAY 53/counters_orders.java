/*There are S counters[] in a Restaurant and T orders[] made by customers,
counters[i] is the capacity of the i-th counter, 
and orders[k] is the time required to prepare the k-th order, in minutes.
Both the counters[] and orders[] are 0-indexed arrays.

Orders are assigned to the counters using an order queue. 
Initially, all counters are available, and the queue is empty.

At k-th minute, the k-th order is entered into the queue
(starting with the 0th order being entered at 0th minute). 

As long as the counters are available and the queue is not empty, 
the first order in the queue will be assigned to an available counter 
with the smallest capacity, and in case of a tie, it is assigned to
an available counter with the smallest index.

If there are no counters available and the queue is not empty, 
wait until a counter becomes available and immediately assign the next order.
If multiple counters become available at the same time, then multiple orders
from the queue will be assigned in order of entrance, following the capacity 
and index priorities above.

A counter that is assigned an order k at minute M will be free again 
at (M + orers[k]) minute.

Your Order is to build an array result[] of length T, where result[k] is
the index of the counter the k-th order will be assigned to, and print it.


Input Format:
-------------
Line-1: Two space separated integers, values of S and T.
Line-2: S space separated integers, 
Line-3: T space separated integers, 

Output Format:
--------------
Print T space separated integers, the final result.


Sample Input-1:
---------------
3 7
8 8 6
1 2 2 3 2 1 2

Sample Output-1:
----------------
2 2 0 2 0 1 2

Explanation: Events in chronological order go as follows:
- At minute-0, order-0 is entered and prepared using counter-2 until minute-1.

- At minute-1, counter-2 becomes available. order-1 is entered and prepared
  using counter-2 until minute-3.

- At minute-2, order-2 is entered and prepared using counter-0 until minute-4.

- At minute-3, counter-2 becomes available. order-3 is entered and prepared 
  using counter-2 until minute-6.

- At minute-4, counter-0 becomes available. order-4 is entered and prepared
  using counter-0 until minute-6.

- At minute-5, order-5 is entered and prepared using counter-1 until minute-6.

- At minute-6, all counters are available. order-6 is entered and prepared 
  using counter-2 until minute-8.

Sample Input-2:
---------------
4 8
8 2 6 4
1 2 3 4 5 6 7 8

Sample Output-2:
----------------
1 1 3 1 2 3 0 1
*/
import java.util.*;
class cal implements Comparator<pair>{
    public int compare(pair p1,pair p2){
        if(p1.a < p2.a) return -1;
        else if(p1.a > p2.a) return 1;
        else{
            if(p1.b < p2.b) return -1;
            else if(p1.b > p2.b) return 1;
            return 0;
        }
    }
}
class pair{
    int a,b;
    pair(int a,int b){
        this.a = a;
        this.b = b;
    }
}
class ma{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int[] times = new int[t];
        PriorityQueue<pair> pq1 = new PriorityQueue<pair>(new cal());
        PriorityQueue<int[]> pq3 = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
        for(int i=0;i<s;i++){
            int a = sc.nextInt();
            pq1.add(new pair(a,i));
        }
        for(int i=0;i<t;i++){
            times[i] = sc.nextInt();
        }
        ArrayList<Integer> l = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while(j<t){
            while(!pq3.isEmpty() && pq3.peek()[2] <= i){
                int[] p = pq3.poll();
                pq1.add(new pair(p[0],p[1]));
            }
            if(!pq1.isEmpty()){
                while(!pq1.isEmpty() && j<t && j <= i){
                    pair p = pq1.poll();
                    int time = times[j];
                    l.add(p.b);
                    pq3.add(new int[]{p.a,p.b,time+i});
                    j++;
                }
            }
            i++;
        }
        
        System.out.println(l);
    }
}
