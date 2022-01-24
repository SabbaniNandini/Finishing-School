/*Murali playing a mobile game, Blast the letters.

In the game he is given a word W and value R.
Murali has to perform the blasting operation as follows:
	- He has to blast the mimeograph M of length R in W, 
	  a mimeograph is a string such that each letter in it should be same.
	- After blasting the mimeograph, the rest of the string on its
	  left side and right side, concatenated together.

Murali has to perform the blasting operation repeatedly, 
until no more blasting is possible. Your task is to return 
the final string after all the blast operations have been done.

Input Format:
-------------
Line-1: A string and an integer, W and R.

Output Format:
--------------
Print a string, the final string after all the blast operations have been done.


Sample Input-1:
--------------- 
ababbaaab 3

Sample Output-1:
----------------
aba


Sample Input-2:
--------------- 
caaabbbaacdddd 2

Sample Output-2:
----------------
cabc
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static String find(String str,ArrayList<Character> ar,int n)
    {
        for(int i=0;i<ar.size();i++)
        {
            String k="";
            for(int j=0;j<n;j++)
            {
                k=k+ar.get(i);
            }
            if(str.contains(k))
            {
                String temp="";
        for(int x=0;x<n;x++)
        {
            temp=temp+k.charAt(x);
        }
        //System.out.println(" temp is "+temp);
                return temp;
            }
        }
        return "";
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int n=sc.nextInt();
       ArrayList<Character> ar=new ArrayList<>();
       for(int i=0;i<str.length();i++)
       {
           if(!ar.contains(str.charAt(i)))
           {
               ar.add(str.charAt(i));
           }
       }
       int length=str.length();
       for(int i=0;i<length;i++){
       String x=find(str,ar,n);
       if(x!=""){
          /*System.out.println(true);
          System.out.println(str);
          //System.out.println(temp);*/
           String temp=str.replaceAll(x,"");
          str="";
          for(int j=0;j<temp.length();j++)
          {
              str=str+temp.charAt(j);
          }
       }
       else{
       System.out.println(str);
       System.exit(0);
       }
       }
    }
}
