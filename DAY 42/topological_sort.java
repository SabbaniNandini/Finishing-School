/*Manoj is working on sets and relations.
He is given a set S consist of N integers from 1 to N, without dupliactes.
The set S may contain any shuffled order of 1 to N numbers.
And also P number of subsets also given where each subset of size Q.
Each subset is a subsequence of shuffled set S.

Manoj has to check, using the given subsets can he form the set S uniquely 
or not. i.e., the order of numbers in the subsets remains unchanged and 
can form only one unique super set using the subsets, and 
the unique super set should be S.

Your task is to help Manoj to check whether it is possible to form 
the shuffled set S uniquely from the given subsets.

For example: 
-----------
If given shuffled set is [2,4,6] and subsets are [2,4] [2,6].
You can form the following sets, [2,4,6] or [2,6,4].

So, you should return false, as the given subsets form more than 1 set.

Simply, there should be always only one unique super set can be formed.
and that set should be equal to S.


Input Format:
-------------
Line-1: An integer N, size of the shuffled array.
Line-2: N space separated integers, shuffled set S.
Line-3: Two space separated integers P and Q, number of subsets, size of subsets
Next P lines: Q space separated integers, non repeated integers from [1-N]

Output Format:
--------------
Print a boolean value, can you form the shuffled set S uniquely or not.


Sample Input-1:
---------------
4
1 3 2 4
3 2
1 2
3 2
3 4

Sample Output-1:
----------------
false

Explanation: 
------------
The subsets are [1,2], [3,2] and [3,4] cannot
form the given shuffled set [1,3,2,4].
It can form another set as [1,3,4,2] also.


Sample Input-2:
---------------
4
1 3 2 4
4 2
1 2
3 2
1 3
2 4

Sample Output-2:
----------------
true

Explanation: 
------------
The subsets are [1,2], [3,2], [1,3] and [2,4] can uniquely 
form the given shuffled set [1,3,2,4].


Sample Input-3:
---------------
5
1 3 5 4 2
3 3
3 4 2
5 4 2
1 3 5

Sample Output-3:
----------------
true

Explanation: 
------------
The subsets are [3,4,2], [5,4,2], and [1,3,5] can uniquely 
form the given shuffled set [1,3,5,4,2].

*/
import java.util.*;
import java.lang.*;
public class ma{
   
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            max=Math.max(max,arr[i]);
        }
        int freq[]=new int[max+1];
        int a=sc.nextInt();
        int b=sc.nextInt();
        int sub[][]=new int[a][b];
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<b;j++)
            {
                sub[i][j]=sc.nextInt();
                if(j!=0)
                {
                    freq[sub[i][j]]++;
                }
            }
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<max+1;i++)
        {
            adj.add(new ArrayList<>());
            }
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<b-1;j++)
            {
                adj.get(sub[i][j]).add(sub[i][j+1]);
            }
        }
        ArrayDeque<Integer> ar=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++)
        {
            if(freq[arr[i]]==0)
            {
                ar.offerLast(arr[i]);
            }
        }
        while(!ar.isEmpty())
        {
            if(ar.size()>1)
            {
                System.out.println("false");
                System.exit(0);
            }
            int k=ar.pollFirst();
            freq[k]--;
            if(freq[k]==0)
            {
                ar.offerLast(k);
            }
            for(int i=0;i<adj.get(k).size();i++)
            {
                freq[adj.get(k).get(i)]--;
                if(freq[adj.get(k).get(i)]==0)
                {
                    ar.offerLast(freq[adj.get(k).get(i)]);
                }
            }
        }
        System.out.println(true);
    }
    
}
