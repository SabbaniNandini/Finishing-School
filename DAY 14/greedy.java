/*M.P.Ahammed the founder of Malbar Gold and Diamonds merchant, announced an offer
that they will charge the minimum amount to make all the gold-biscuits into one.

Mr. Praveen, a gold supplier has different weighed gold-biscuits with him.
He wants to utilize the offer.

The processing charge to make two biscuits into one is calculated as follows:
	- To make two biscuits of weights A and B into one biscuit, 
	you have to pay the amount 'A + B'. 

Your task is to help M.P.Ahammed to keep his promise and 
to charge the minimum amount to make Mr. Praveen's gold-biscuits 
into one gold-biscuit.

Input Format:
-------------
Single line of space separated integers, number on the boxes.

Output Format:
--------------
Print an integer, minimum amount to be paid by Mr Shravan.


Sample Input-1:
---------------
4 3 6

Sample Output-1:
----------------
20


Sample Input-2:
---------------
5 2 4 3 6

Sample Output-2:
----------------
45
*/
import java.util.*;
import java.lang.*;
class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
    String str=sc.nextLine();
        String arr[]=str.split(" ");
    ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            a.add(Integer.parseInt(arr[i]));
        }
        int k=0;
        int l=0;
        int count=0;
        int m=a.size();
        int ans=0;
        Collections.sort(a);
        while(a.size()>1)
        {
           int x=a.get(0);
           a.remove(0);
           int y=a.get(0);
           a.remove(0);
           a.add(x+y);
           ans+=x+y;
           //System.out.println(" x is "+x+" y is "+y+" a is "+a);
           Collections.sort(a);
           count++;
        }
        System.out.println(ans);
        //System.out.println(a.get(0)+a.get(1));
    }
}
