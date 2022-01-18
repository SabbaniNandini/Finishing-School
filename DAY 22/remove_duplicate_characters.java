/*Pramod is working on words. He used to remove all the duplicate letters 
from a word. Pramod is given a word W. His task to remove all the duplicate 
letters from W, in such a way that the resulatant word R, contains 
no duplicate letters and all distinct letters from W should be there in R. 
And R should appear first in the dictionary order. 

Input Format:
-------------
A String, the word W.

Output Format:
--------------
Print a String, resulatant word R.


Sample Input-1:
---------------
cbadccb

Sample Output-1:
----------------
adcb


Sample Input-2:
---------------
silicosis

Sample Output-2:
----------------
ilcos
*/
import java.util.*;
import java.lang.*;

public class ma{
    public static String k(String s) {
        int lastIndex[]=new int[26];
        
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        
        boolean visited[]=new boolean [26];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            int x=s.charAt(i)-'a';
            
            if(visited[x]) continue;
            
            while(stack.size()!=0 && stack.peek()>x && lastIndex[stack.peek()]>i){
                visited[stack.pop()]=false;
            }
            stack.push(x);
            visited[x]=true;
        }
        StringBuilder str=new StringBuilder();
        
        while(stack.size()!=0){
            str.append((char)(stack.pop()+'a'));
        }
        return str.reverse().toString();               
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(k(str));
    }
}
