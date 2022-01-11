/*"Emphatic Pronunciation" of a given word is where we take the word and
replicate some of the letter to emphasize their impact.

Instead of saying 'oh my god', someone may say "ohhh myyy goddd", 
We define emphatic pronunciation of a word, which is derived by replicating 
a group (or single) of letters in the original word. 

So that the replicated group is atleast 3 characters or more and 
greater than or equal to size of original group. 
For example Good -> Goood is an emphatic pronunciation,
but Goodd is not because in Goodd the 'd' are only occuring twice consecutively.
 
In the question you are given the "Emphatic pronunciation" word, 
you have to findout how many words can legal result in the 
"emphatic pronunciation" word.

Input Format:
-------------
Line-1 -> A String contains a single word, Emphatic Pronunciation word
Line-2 -> Space seperated word/s

Output Format:
--------------
Print an integer as your result


Sample Input-1:
---------------
Goood
Good

Sample Output-1:
----------------
1


Sample Input-2:
---------------
heeelllooo
hello hi helo

Sample Output-2:
----------------
2
*/
import java.util.*;
import java.lang.*;
class ma{
    public static boolean isEmphatic(String s,String t)
    {
        int i=0;int j=0;
        int n=s.length();int m=t.length();
        while(i<s.length()&&j<t.length())
        {
            int x=i;
            int y=j;
            
            int count1=0;
            int count2=0;
            while(y<m&&t.charAt(y)==t.charAt(j))
            {
                
                y++;
                count2++;
            }
            
            while(x<n&&s.charAt(x)==t.charAt(j))
            {
                 
                x++;
                count1++;
            }
              
            if(count1<count2||(count1>count2&&count1<3))
            {
               
                return false;
            }
            i=x;
            j=y;
            
        }
    if((i==n)&&(j==m)){
        return true;
    }
    return false;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String s=sc.nextLine();
        String arr[]=s.split(" ");
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(isEmphatic(str,arr[i])==true){
            count++;
            }
        }
        System.out.println(count);
    }
}
