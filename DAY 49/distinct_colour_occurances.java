/*You have given a bagful of N colored balls, the color codes of the balls 
are distinct. Your task is to print "true", if and only if the number of balls
having different color codes in the bag are distinct. Otherwise, print "false".

Input Format:
-------------
Line-1: An integer N, number of balls.
Line-2: N space separated integers, the color codes of the balls.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
6
1 2 2 1 1 3

Sample Output-1:
----------------
true

Explanation:
------------
The number of balls in the bag having color code-1 are 3,
The number of balls in the bag having color code-2 are 2,
The number of balls in the bag having color code-3 are 1.
The count of balls having distinct color codes are not same.


Sample Input-2:
---------------
3
1 2 3

Sample Output-2:
----------------
false
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(h.containsKey(arr[i]))
            {
                h.put(arr[i],h.get(arr[i])+1);
            }
            else
            {
                h.put(arr[i],1);
            }
        }
        HashSet<Integer> hs=new HashSet<>();
        for(int i:h.values())
        {
            hs.add(i);
        }
        if(h.size()==hs.size())
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
    }
}
