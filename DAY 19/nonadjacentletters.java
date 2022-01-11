/*Gnanesh is working on Machine Learning domain. He wants train the machine 
in such a way that, if he provided an image printed with a string on it,
the machine has to extract the text as a string and verify that, 
after shuffling  the letters in the string, 'the shuffled string should be 
like no two adjacent letters should be same' 

You will be given extracted string, and
Can you help Gnanesh to train the machine with the given constraint 
The machine has to print "true", if the constarint is met, 
Otherwise, print "false".

Input Format:
-------------
A String S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
aaabd

Sample Output-1:
----------------
true

Sample Input-2:
---------------
aaab

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
       String s=sc.next();
       int map[]=new int[26];
       int max=0;
       for(int i=0;i<s.length();i++)
       {
           int k=s.charAt(i)-'a';
           map[k]++;
           max=Math.max(max,map[k]);
       }
       if(s.length()%2!=0)
       {
           if(max>(s.length()/2)+1)
           {
               System.out.println(false);
           }
           else
           {
               System.out.println(true);
           }
       }
       else
       {
           if(max>(s.length()/2)){
               System.out.println(false);
           }
           else
           {
               System.out.println(true);
           }
       }
    }
}

