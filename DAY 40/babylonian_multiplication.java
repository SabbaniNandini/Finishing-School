/*Babylonians invented multiplication of numbers.

You will be given two strings consist of digits only.
You have to perform the multiplication of these two strings using 
Babylonians approach, and return the result of multiplication of two strings.


Input Format:
-------------
Two space separated strings, num1 and num2.

Output Format:
--------------
Print the product of two strings num1 and num2.


Sample Input-1:
---------------
5 4 

Sample Output-1:
----------------
20


Sample Input-2:
---------------
121 432 

Sample Output-2:
----------------
52272

Note:
-----
	- Input should contain digits only, and should not contain leading 0's 
	  except number 0.
	- Output will be in the range of integer only.
	- There will be no leading minus '-' symbol also.
	- Should not use built-in BigInteger library.
	- Should not convert the given strings into integers.
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        int ans=0;
        int x=0;
        for(int i=a.length()-1;i>=0;i--)
        {
            int y=1;
            for(int j=b.length()-1;j>=0;j--)
            {
                ans=ans+(a.charAt(i)-'0')*x*(b.charAt(j))*y;
                y=y*10;
            }
            x=x*10;
        }
        System.out.println(ans);
    }
}
    

