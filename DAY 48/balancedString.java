/*AlphaCipher is a string formed from another string by rearranging its letters

You are given a string S.
Your task is to check, can any one of the AlphaCipher is a palindrome or not.

Input Format:
-------------
A string S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
carrace

Sample Output-1:
----------------
true


Sample Input-2:
---------------
code

Sample Output-2:
----------------
false

*/
import java.util.*;
import java.lang.*;
class ma{
public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    String str=sc.next();
    int arr[]=new int[26];
    for(int i=0;i<str.length();i++)
    {
        arr[str.charAt(i)-'a']++;
    }
    int count=0;
    for(int i=0;i<26;i++)
    {
        if(arr[i]%2!=0)
        {
            count++;
        }
    }
    if(count>=2)
    {
        System.out.println(false);
    }
    else
    {
        System.out.println(true);
    }
}
}
