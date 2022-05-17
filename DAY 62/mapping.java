/*You are given two words W1 and W2.
You need find all the mapping of W2 in W1, and 
return all the statrting indices of the mappings.

The mapping of the words w2 and w1 is as follows:
	- A shuffled word contains all the characters as original word.
	The length of the words and occurrence count of each character are same.
	- find shuffled word of W2 as a substring in W1, and 
	return the starting index of substring.


Input Format:
-------------
Single line space separated strings, two words.

Output Format:
--------------
Print the list of integers, indices.


Sample Input-1:
---------------
abcabcabc abc
 
Sample Output-1:
----------------
[0, 1, 2, 3, 4, 5, 6]



Sample Input-2:
---------------
bacacbacdcab cab

Sample Output-2:
----------------
[0, 3, 4, 5, 9]

*/





import java.util.*;
import java.lang.*;
public class Solution{
    public static boolean check(HashMap<Character,Integer> h1,HashMap<Character,Integer> h2)
    {
        for(char ch: h1.keySet())
        {
            if(h1.containsKey(ch)&&h2.containsKey(ch)){
            if(h1.get(ch)!=h2.get(ch))
            {
                return false;
            }
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String s=sc.next();
        HashMap<Character,Integer> h1=new HashMap<>();
        HashMap<Character,Integer> h2=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(!h1.containsKey(s.charAt(i)))
            {
                h1.put(s.charAt(i),1);
            }
            else
            {
                h1.put(s.charAt(i),h1.get(s.charAt(i))+1);
            }
        }
        for(int i=0;i<s.length();i++)
        {
            if(!h2.containsKey(str.charAt(i)))
            {
                h2.put(str.charAt(i),1);
            }
            else
            {
                h2.put(str.charAt(i),h2.get(str.charAt(i))+1);
            }
        }
         
        ArrayList<Integer> ans=new ArrayList<>();
        int start=0;
        int end=s.length();
        while(end<str.length()){
        if(check(h1,h2))
        {
            ans.add(start);
            
        }
        
             h2.put(str.charAt(start),h2.get(str.charAt(start))-1);
            start++;
            if(!h2.containsKey(str.charAt(end)))
            {
                h2.put(str.charAt(end),1);
            }
            else
            {
                h2.put(str.charAt(end),h2.get(str.charAt(end))+1);
            }
            end++;
        }
        if(check(h1,h2))
        {
            ans.add(start);
            
        }
        System.out.println(ans);
    }
}
