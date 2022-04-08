/*Kiran is playing with strings and its subsequences.
A subsequence can be formed from a string by deleting some characters
(may be string itself)

Kiran has given two strings S and T, your task to form T by concatenating 
the subsequences of S  

Return the minimum number of subsequences required to form T.
If the task is impossible, return -1 .


Input Format:
-------------
Line-1 -> Two strings S and T

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
abc abcbc

Sample Output-1:
----------------
2

Explanation: 
------------
T = "abcbc" can be formed by "abc" and "bc",
which are subsequences of S = "abc".


Sample Input-2:
---------------
abc acdbc

Sample Output-2:
----------------
-1

Explanation: 
------------
string T cannot be constructed from the
subsequences of string S due to the character "d" in string T.
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String str=sc.next();
       char src[]=s.toCharArray();
       char tgt[]=str.toCharArray();
       int i=0;
       int j=0;
        HashSet<Character> h=new HashSet<>();
        for(int x=0;x<s.length();x++)
        {
            h.add(s.charAt(x));
        }
        for(int x=0;x<str.length();x++)
        {
            if(!h.contains(str.charAt(x)))
            {
                System.out.println(-1);
                System.exit(0);
            }
        }
        int count=1;
       while(i<tgt.length)
       {
           if(j>=src.length)
               {
                   j=0;
                   count=count+1;
                   
               }
           if(src[j]==tgt[i])
           {
               i=i+1;
               
               j=j+1;
               
               
           }
           else
           {
               
               j=j+1;
              
           }
           
       }
       System.out.println(count);
    }
}
