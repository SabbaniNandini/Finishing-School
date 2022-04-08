/*Somesh is given a task to you on Strings.
You have given a string S ([a-z]), and an integer array Arr[]
Now your task is to modify 'S' in such way:
replace the 'i+1' characters in the string, with next i-th character 
in alphabetic order(cyclic).

For example, if S="art", Arr[]=[2,3,5] is 3, 
i=0, modify('a') = 'c' , S="crt".
i=1, modify('c') = 'f', modify('r') = 'u', S="fut".
i=2, modify('f') = 'k', modify('u') = 'z', modify('t') = 'y', S="kzy"
Finally modified string is kzy. 

Note: if arr[i]=3 modify('z') ='c'

Return the final modified string after all such modifications to S are applied.

Input Format:
-------------
Line-1 -> A String S, length of S is L
Line-2 -> L space separated integers.

Output Format:
--------------
Print modifed String.


Sample Input-1:
---------------
adbp
1 2 3 4

Sample Output-1:
----------------
kmit
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int arr[]=new int[str.length()];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        char a[]=str.toCharArray();
        char index[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<=i;j++)
            {
                
                int temp=a[j]-'a';
                int k=(temp+arr[i])%26;
                //System.out.printl()
                a[j]=index[k];
            }
        }
        System.out.println(String.valueOf(a));
    }
}