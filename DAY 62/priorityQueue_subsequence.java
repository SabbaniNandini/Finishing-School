/*Mr Shravan is working with Strings.
He is given a string S, and a list of words.
He wants to find a word which is maximum in length and 
appears first in lexicographical order, And the word is a subsequence of S.

Your task is to help Mr Shravan to find such a word from the given list of words.
If there is no such word, print "No Word".

Input Format:
-------------
Line-1: A string S.
Line-2: Space separated strings, words[].

Output Format:
--------------
Print a string result.



Sample Input-1:
---------------
rascapepurple
ape cape racer app apple

Sample Output-1:
----------------
apple


Sample Input-2:
---------------
abcdefhijk
bca abd abc dfe def ghi

Sample Output-2:
----------------
abc

Sample Input-3:
---------------
vivid
viva diva diya

Sample Output-3:
----------------
No Word

*/



import java.util.*;
import java.lang.*;
public class Solution{
    public static boolean check(String s1,String s2,int n,int m)
    {
        if(n==0)
        {
            return true;
        }
        if(m==0)
        {
            return false;
        }
        if(s1.charAt(n)==s2.charAt(m))
        {
            return check(s1,s2,n-1,m-1);
        }
        else{
            return check(s1,s2,n,m-1);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String dummy=sc.nextLine();
        String s=sc.nextLine();
        String arr[]=s.split(" ");
        Arrays.sort(arr,(a,b)->{
            if(a.length()==b.length())
            {
                return a.compareTo(b);
            }
            else
            {
                return b.length()-a.length();
            }
        });
        //System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++)
        {
            if(check(arr[i],str,arr[i].length()-1,str.length()-1))
            {
                System.out.println(arr[i]);
                System.exit(0);
            }
        }
        System.out.println("No Word");
    }
}
