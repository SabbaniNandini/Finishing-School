/*You are given a phrase and a paper of size m*n.
So you can type exactly m * n characters on that paper.
i.e,. there are 'm' rows and in each row you can type 'n' characters
You need to type the phrase on the paper with some rules.

The rules are as follows:
    - A word in the phrase cannot be split into two lines.
    - The order of words in the phrase shuld not change.
    - Two consecutive words in a line must be separated by a single space.

Your task is to find out how many times the phrase can be typed on the paper.


Constraint:
-----------
Length of each word is <=10.

Input Format:
-------------
Line-1: Three space separated integers m, n, and s, grid size m*n, number of words.
Line-2: 's' space separated strings, set of words

Output Format:
--------------
Print an integer, no.of times set of words fit into the grid.


Sample Input-1:
---------------
2 8 2
socail distance

Sample Output-1:
----------------
1

Explanation:
------------
social__
distance


Sample Input-2:
---------------
3 6 3
a bc def

Sample Output-2:
----------------
2

Explanation:
------------
a_bc__
def_a_
bc_def
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int s=sc.nextInt();
        
        String str[]=new String[s];
        for(int i=0;i<s;i++)
        {
            str[i]=sc.next();
            //length=length+str[i].length();
        }
        int row=0;
        int col=0;
        int count=0;
        int i=0;
        while(row<m)
        {
            i=i%s;
            if(str[i].length()+col<=n){
            col=col+str[i].length()+1;
            i++;
            if((i%s)==0)
            {
                count++;
            }
            if(col>=n)
            {
                col=0;
                row++;
            }
            }
            else
            {
                col=0;
                row++;
            }
        }
        System.out.println(count);
    }
}
