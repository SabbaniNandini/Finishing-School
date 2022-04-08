/*Shaggy Rogers is working with numbers.
He is given a number N, 
He wants to replace all occurrences of a digit in the number N,
with another digit between [0-9]. May be with same number too.

But there should not be any leading zeros in the number after the replacement,
Or the number should not become zero.

Rogers can perform the replacement of the occurrences of the digit in N for two 
times, He will generate two new numbers P and Q, such that the value of |P-Q| 
should be Maximum.

Your task is to help Shaggy Roers to find the maximum difference of P and Q possible.


Input Format:
-------------
An integer N, the number

Output Format:
--------------
Print an integer, the maximum difference of P and Q


Sample Input-1:
---------------
123

Sample Output-1:
----------------
820

Explanation:
------------
Replacement-1: replace 1 with 9 you will get P as 923
Replacement-2: replace 2 with 0 you will get Q as 103
So Max difference is 820.


Sample Input-2:
---------------
4254

Sample Output-2:
----------------
8008

Explanation:
------------
Replacement-1: replace 4 with 9 you will get P as 9259
Replacement-2: replace 4 with 1 you will get Q as 1259
So Max difference is 8008.
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String k=sc.next();
        char str[]=k.toCharArray();
        char s[]=k.toCharArray();
        if(str[0]!='9')
        {
            char ch=str[0];
            for(int i=0;i<str.length;i++)
            {
                if(str[i]==ch)
                {
                   str[i]='9'; 
                }
            }
        }
        else
        {
            int p=0;
            while(p<str.length)
            {
              if(str[p]!='9')
           {
            char ch=str[p];
            for(int i=0;i<str.length;i++)
            {
                if(str[i]==ch)
                {
                   str[i]='9'; 
                }
            }
            break;
        }
        p++;
            }
        }
        //System.out.println(Arrays.toString(str));
        if(s[0]!='1')
        {
            char ch=s[0];
            for(int i=0;i<str.length;i++)
            {
                if(s[i]==ch)
                {
                   s[i]='1'; 
                }
            }
        }
        else
        {
             int p=0;
            while(p<str.length)
            {
              if(s[p]!='1'&&s[p]!='0')
           {
            char ch=s[p];
            for(int i=0;i<s.length;i++)
            {
                if(s[i]==ch)
                {
                   s[i]='0'; 
                }
            }
            break;
        }
        p++;
            }
        }
        //System.out.println(Arrays.toString(s));
        System.out.println(Math.abs(Integer.parseInt(String.valueOf(str))-Integer.parseInt(String.valueOf(s))));
    }
}
