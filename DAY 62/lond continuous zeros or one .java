/*There are some soldiers formed in a line from Kunthala and Mahishmathi together,
The soldiers from Kunthala indiacted with 0's and from Mahishmathi indiacted 
with 1's.

You need to kill the soldiers from either Kunthala or Mahishmathi.(see NOTE)
Assume that you have unlimited energy. In order to kill them, you need 
to burn the energy. If you are at position-A and kill a soldier at position-B, 
you need to burn B-A energy. 

You are given the order of soldiers as a string, consist of 0's an 1's only.
Your task is to find out the maximum amount of energy burnt to kill the soldier 
to reach the last soldier in that line.

NOTE: If the last soldier belongs to Kunthala, kill the soldiers belongs 
to Kunthala only. If the last soldier belongs to Mahishmathi, kill 
the soldiers belongs to Mahishmathi only.

Input Format:
-----------------
A String S, arrangement of soldiers.

Ourput Format:
-------------------
Print an integer result, the maximum energy burnt to kill a soldier.


Sample Input-1:
-----------------
100111010

Sample Output-1:
-------------------
4


Sample Input-2:
-----------------
1111110

Sample Output-2:
-------------------
7

Explanation:
--------------
Since to reach the last soldier in the line, You have to burn
the energy of 7 to reach from position-0 to the last soldier in the line.





//max no.of consecutive 1's or 0's +1
*/
import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int one = 0;
        int zero = 0;
        int maxo = 0;
        int maxz = 0;
        int n = str.length();
        
        for(int i=0;i<n;i++)
        {
            if(str.charAt(i) == '0')
            {
                one =0;
                zero++;
            }
            else if(str.charAt(i) == '1')
            {
                zero=0;
                one++;
            }
            //System.out.println(zero+" "+one);
            maxo = Math.max(maxo,one);
            maxz = Math.max(maxz,zero);
        }
        System.out.println(Math.max(maxo,maxz)+1);
    }
}