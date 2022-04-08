/*Kohinoor diamond is robbed by Hrithik, He kept the diamond in a suitcase, 
the suitcase has a lock with 4 circular wheels, and each wheel consist of
0-9 digits in the order 0,1,2,3,4,5,6,7,8,9 only.
You can rotate a wheel from 0 to 9 or 9 to 0.

As the diamond is most valuable, the lock has some traps,
if anybody try to unlock the suitcase and reached any one of the traps,
the suitcase will be blasted. And you will be dead.

Initially, the suitcase lock is set to 0000.
and you will be given the unlock key, your task to find and print
the minimum number of rotations required to unlock the suitcase.
If it is not possible to unlock the suitcase without blasting, print -1.

NOTE:
In one rotation you can choose any one wheel and 
rotate to its next or previous digit.


Input Format:
-------------
Line-1: space separated strings, each string of length 4 and contains only digits [0-9]
Line-2: A string, key to unlock.

Output Format:
--------------
Print an integer, the minimum number of rotations required to unlock.


Sample Input-1:
---------------
0302 0202 0203 2323 3003
0303 

Sample Output-1:
----------------
8

Explanation:
------------
To unlock the suitcase the valid rotations are as follows:
0000 > 1000 > 1100 > 1200 > 1201 > 1202 > 1302 > 1303 > 0303.


Sample Input-2:
---------------
6656 6676 6766 6566 5666 7666 6665 6667
6666 

Sample Output-2:
----------------
-1

Explanation:
------------
You can't unlock the suitcase.
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String arr[]=str.split(" ");
        String target=sc.next();
        HashSet<String> h=new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            h.add(arr[i]);
        }
        int count=0;
        ArrayDeque<String> a=new ArrayDeque<>();
        String temp="0000";
        a.offerLast(temp);
        if(h.contains(temp))
        {
            System.out.println(-1);
            System.exit(0);
        }
        while(!a.isEmpty())
        {
            //System.out.println(1);
            //System.out.println(a);
            
            int n=a.size();
            for(int j=0;j<n;j++)
            {
                String k=a.pollFirst();
                /*if(h.contains(k))
                {
                    continue;
                }*/
                for(int i=0;i<4;i++)
                {
                    char c=k.charAt(i);
                    String f=k.substring(0,i)+(c-'0'+1)%10+k.substring(i+1,k.length());
                    String b=k.substring(0,i)+(c-'0'+9)%10+k.substring(i+1,k.length());
                    if(f.equals(target)||b.equals(target))
                    {
                        System.out.println(count+1);
                        System.exit(0);
                    }
                    
                    if(!h.contains(f))
                    {
                       h.add(f); 
                       a.offerLast(f);
                    }
                    if(!h.contains(b))
                    {
                        h.add(b);
                        a.offerLast(b);
                    }
                    
                }
            }
            count++;
        }
        System.out.println(-1);
        //System.out.println(a);
    }
}
