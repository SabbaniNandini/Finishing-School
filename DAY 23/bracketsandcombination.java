/*Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, 
in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]
*/
import java.util.*;
import java.lang.*;
class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        ArrayList<String> a=new ArrayList<>();
        int ob=0;
        int cb=0;
        int i=0;
        while(i<str.length())
        {
            
            String s="";
            if(str.charAt(i)=='[')
            {
                i++;
                ob=1;
                while(i<str.length()&&cb==0)
                {
                    if(str.charAt(i)==']')
                    {
                        cb=1;
                        i++;
                        break;
                    }
                    else{
                 s=s+str.charAt(i);
                 
                    }
                    i++;
                }
            String arr[]=s.split(",");
            
            if(a.size()==0)
            {
                for(int p=0;p<arr.length;p++)
                {
                    a.add(arr[p]);
                }
                
            }
            else{
                
                int k=a.size();
                
                for(int x=0;x<k;x++)
                {
                     String s1=a.get(0);
                     a.remove(0);
                     for(int y=0;y<arr.length;y++)
                     {
                         a.add(s1+arr[y]);
                     }
                }
                
            }
            Arrays.fill(arr,"");
            ob=0;
            cb=0;
            }
            else
            {
                
                String s2="";
                while(i<str.length()&&str.charAt(i)!='[')
                {
                    s2=s2+str.charAt(i);
                    i++;
                }
               
                int k=a.size();
                if(k==0)
                {
                    a.add(s2);
                }
                else{
                for(int x=0;x<k;x++)
                {
                    String s1=a.get(0);
                    a.remove(0);
                    a.add(s1+s2);
                    
                    }
                }
            }
            
        }
        Collections.sort(a);
        System.out.println(a);
    

}
}
