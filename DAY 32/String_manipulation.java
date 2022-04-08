/*Bunny is playing with binary strings. He wants to break
a binary string B into 3 parts, of length atleast '1',
when we merge the 3 parts will result the string B.

Your task is to find the count the various forms to break 
the Binary String B into 3 parts, where each part should 
contain equal number of 1's.


Input Format:
-------------
A string S.

Output Format:
--------------
Print an integer, count the various forms to break.


Sample Input-1:
---------------
01010010

Sample Output-1:
----------------
6

Explanation:
------------
There are six forms to break S into 3 parts 
where each part contain the equal number of  1's.
01 | 01 | 0010
01 | 010 | 010
01 | 0100 | 10
010 | 1 | 0010
010 | 10 | 010
010 | 100 | 10


Sample Input-2:
---------------
010010

Sample Output-2:
----------------
0
*/

import java.util.*;
import java.lang.*;
public class ma{
    public static void bt(String str)
    {
        int count=0;
        for(int i=1;i<str.length();i++)
        {
            for(int j=i+1;j<str.length();j++)
            {
                String a=str.substring(0,i);
                String b=str.substring(i,j);
                String c=str.substring(j,str.length());
                //System.out.println(" a is "+a+" b is "+b+" c is "+c);
                if(check(a,b,c)==true)
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static boolean check(String a,String b,String c)
    {
        int azero=0;
        int aone=0;
        int bzero=0;
        int bone=0;
        int czero=0;
        int cone=0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)=='0')
        {
            azero++;
        }
        else
        {
            aone++;
        }
        }
        for(int i=0;i<b.length();i++)
        {
            if(b.charAt(i)=='0')
        {
            bzero++;
        }
        else
        {
            bone++;
        }
        }
        for(int i=0;i<c.length();i++)
        {
            if(c.charAt(i)=='0')
        {
            czero++;
        }
        else
        {
            cone++;
        }
        }
          if(aone!=bone||bone!=cone||cone!=aone)
          {
              return false;
          }
          return true;
        
    
    
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        bt(str);
    }
}
