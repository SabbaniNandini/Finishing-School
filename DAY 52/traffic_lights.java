/*Gopal used to violate the traffic rules set by Government
The list of violations he made is represented in String S2
And list of traffic violations represented in String S1.

The characters in S1 indicates TrafficViolations, each character 
is a type of traffic violation. The characters in S2 indicates All Violations, 
each character is a type of violation.

Now your task is to find the number of traffic violations made by Gopal.

NOTE: It is guaranteed that String S1 contains distinct characters.
And all the characters in both S1, S2 are case-sensitive.
i.e. 'a' is different from 'A'.

Input Format:
-------------
Two strings S1 and S2

Output Format:
--------------
Print an integer, the number of traffic violations made by Gopal.


Sample Input-1:
---------------
Aa aAAbbbb

Sample Output-1:
----------------
3

Sample Input-2:
---------------
abc  ABBCCC

Sample Output-2:
----------------
0
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String str=sc.next();
        HashSet<Character> h=new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            h.add(s.charAt(i));
        }
        int ans=0;
        for(int i=0;i<str.length();i++)
        {
            if(h.contains(str.charAt(i)))
            {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
