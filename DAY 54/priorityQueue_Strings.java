/*Sridhar brought his latest Apple iPhone 12 pro. He started his conversation 
with one of his friend on WhatsApp with list of words.

Now it’s our task to find and return what are the most common words 
in the list of words he used in sorted order based on occurrence from 
largest to smallest. If any of words he used are having same occurrence 
then consider the lexicographic order.

You will be given a list of words, you need to print top P number of 
most common used words as described in the statement. 

Input Format:
-------------
Line-1: comma separated line of words, list of words.
Line-2: An integer P, number of words to display. 

Output Format:
--------------
Print P number of most common used words.


Sample Input-1:
---------------
ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are,case
3

Sample Output-1:
----------------
[are, case, egg]



Sample Input-2:
---------------
ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are
3

Sample Output-2:
----------------
[are, egg, case]
*/
import java.lang.*;
import java.util.*;

class ma
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(",");
        int n = sc.nextInt();
        HashMap<String,Integer> hm = new HashMap<>();
        HashMap<String,Integer> str_map = new HashMap<>();
        HashMap<Integer,String> rev_map = new HashMap<>();
        for(int i=0;i<s.length;i++)
        {
            if(!hm.containsKey(s[i]))
            {
                hm.put(s[i],1);
                str_map.put(s[i],i);
                rev_map.put(i,s[i]);
            }
            else
                hm.put(s[i],hm.get(s[i])+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0])
                return rev_map.get(a[1]).compareTo(rev_map.get(b[1]));
            return b[0]-a[0];
        });
        for(String x : hm.keySet())
        {
            pq.offer(new int[]{hm.get(x),str_map.get(x)});
        }
        List<String> res = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int x[] = pq.poll();
            res.add(rev_map.get(x[1]));
        }
        System.out.println(res);
    }
}
