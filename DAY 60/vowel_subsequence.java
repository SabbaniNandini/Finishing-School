/*Akhila is given a string S, Where S conatins only [aeiou] letters.
A special subsequence defined as a sequence of letters derived from S
that contains all five vowels in order. It means a specail subsequence 
will have one or more a's followed by the one or more e's followed by 
one or more i's followed by one or more o's followed by one or more u's.

Your task is to help Akhila to return the length of the longest special 
subsequence in S.

Input Format:
-------------
Your code should be read input from the given attached file as a string (no line breaks)

Output Format:
--------------
An integer, the length of longest subsequence.

Sample input-1:
---------------
aeeiooua

Sample Output-1:
----------------
7

Explanation:
------------
Given S = "aeeiooua", then "aeiou" and "aeeioou" are special subsequences
but "aeio" and "aeeioua" are not


Sample input-2:
---------------
aeiaaioooaauuuaeiou

Sample Output-2:
----------------
10*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        HashMap<Character,Integer> h=new HashMap<>();
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            if(s.isEmpty())
            {
                if(str.charAt(i)=='a')
                {
                    s.push('a');
                    h.put('a',1);
                }
                
                else
                {
                    continue;
                }
            }
            else
            {
                if(s.peek()=='a'&&(str.charAt(i)=='e'||str.charAt(i)=='a'))
                {
                    s.push(str.charAt(i));
                    if(!h.containsKey(str.charAt(i)))
                    {
                        h.put(str.charAt(i),1);
                    }
                }
                else if(s.peek()=='e'&&(str.charAt(i)=='i'||str.charAt(i)=='e'))
                {
                    s.push(str.charAt(i));
                    if(!h.containsKey(str.charAt(i)))
                    {
                        h.put(str.charAt(i),1);
                    }
                }
                else if(s.peek()=='i'&&(str.charAt(i)=='o'||str.charAt(i)=='i'))
                {
                    s.push(str.charAt(i));
                    if(!h.containsKey(str.charAt(i)))
                    {
                        h.put(str.charAt(i),1);
                    }
                }
                else if(s.peek()=='o'&&(str.charAt(i)=='u'||str.charAt(i)=='o'))
                {
                    s.push(str.charAt(i));
                    if(!h.containsKey(str.charAt(i)))
                    {
                        h.put(str.charAt(i),1);
                    }
                }
                else if(s.peek()=='u'&&str.charAt(i)=='u')
                {
                    s.push(str.charAt(i));
                    if(!h.containsKey(str.charAt(i)))
                    {
                        h.put(str.charAt(i),1);
                    }
                }
                else
                {
                    continue;
                }
            }
        }
        //System.out.println(s);
        if(h.size()==5){
             System.out.println(s.size());
        } 
        else
        {
            System.out.println(0);
        }
}
}
