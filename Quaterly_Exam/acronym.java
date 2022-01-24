/*Ananth interested in creating the acronyms for any word. The definition
of acronym is another word with a concatenation of its first letter,
the number of letters between the first and last letter, and its last letter. 
 
If a word has only two characters, then it is an acronym of itself.

Examples:
    - Acronym of 'fog' is f1g'.
    - Acronym of 'another' is 'a5r'.
    - Acronym of 'ab' is 'ab'.

You are given a list of vocabulary, and another list of words.
Your task is to check,each word with the vocabulary and
return "true" if atleast one of the following rules satisfied:
1. acronym of the word should not match with any of the acronyms of vocabulary
2. if acronym of the word matches with any of the acronyms of vocabulary
'the word' and matching words in vocabulary should be same.

Otherwise, return 'false'.

Input Format:
-------------
Line-1: Space separated strings, vocabulary[] 
Line-2: Space separated strings, words[] 

Output Format:
--------------
Print N boolean values, where N = words.length 


Sample Input-1:
---------------
cool bell cool coir move more mike
cool char move 

Sample Output-1:
----------------
true false false
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        String str[]=a.split(" ");
        String s[]=b.split(" ");
        String word[]=new String[s.length];
        String vocab[]=new String[str.length];
        for(int i=0;i<str.length;i++)
        {
            String k=str[i];
            String temp="";
            if(k.length()>2)
            {
                int n=k.length()-2;
                temp=k.charAt(0)+Integer.toString(n)+k.charAt(k.length()-1);
                vocab[i]=temp;
            }
            else
            {
               vocab[i]=str[i]; 
            }
        }
        for(int i=0;i<s.length;i++)
        {
            String k=s[i];
            String temp="";
            if(k.length()>2)
            {
                int n=k.length()-2;
                temp=k.charAt(0)+Integer.toString(n)+k.charAt(k.length()-1);
                word[i]=temp;
            }
            else
            {
                word[i]=s[i];
            }
        }
        for(int i=0;i<s.length;i++)
        {
            int flag=0;
            for(int j=0;j<str.length;j++)
            {
                
                String check="";
                if(word[i].equals(vocab[j])&&!s[i].equals(str[j]))
                { flag=1;
                    System.out.print(false+" ");
                    break;
                    /*
                    check=str[i];*/
                }
                /*else if(flag==1&&s[i].equals(str[i])&&!str[i].equals(check))
                {
                    System.out.println(false+" ");
                    break;
                }*/
                /*else if (flag==0)
                {
                    System.out.print(true+" ");
                    break;
                }*/
            }
            if(flag==0){
            System.out.print(true+" ");
            }
        }
    }
}
