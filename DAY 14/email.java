/*Alice wants send a mail to his clients,
He has saved the clients Mail IDs in a list.
There exists an email parser, which perform the following checks 
and send the mail to the distinct clients, the checks are as follows:
- Each mail id has two parts, one is username one is domain name.
- The part before the @ symbol is username, and other is domain name.
- In username, if there exists a '.' symbol, remove it.
- In username, if there exists a '+' symbol, ignore the 
  suffix of the username from that symbol (including '+') 
- In domain name, the '.' symbol will be stays as it is.
- There will be no '+' symbol in domain name.

After performing above checks, your task is to find the count
of distinct client mail ids, who recieves the mail sent by Alice.

Input Format:
-------------
Space separated strings, emails list[].

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
a.v.nagireddy@kmit.in av.nagireddy@gmail.com avnagireddy@kmit.in a.v.nagireddy+org@kmit.in

Sample Output-1:
----------------
2

Explanation:
------------
These 3 mail id's: a.v.nagireddy@kmit.in, avnagireddy@kmit.in, a.v.nagireddy+org@kmit.in
are belons to same client with mail ID: avnagireddy@kmit.in
and another client with mail ID-av.nagireddy@gmail.com
So, there are 2 distinct clients.


Sample Input-2:
---------------
avnreddy@gmail.com avnreddy@yahoo.co.in nsudha@outlook.com

Sample Output-2:
----------------
3

Explanation:
------------
All 3 mail IDs belons to different clients.

*/
import java.util.*;
import java.lang.*;
class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String arr[]=str.split(" ");
        HashSet<String> h=new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            int k=arr[i].indexOf('@');
            String s1=arr[i].substring(0,k);
            int p=arr[i].indexOf('+');
            if(p!=-1)
            {
                s1=arr[i].substring(0,p);
            }
            String s2=arr[i].substring(k);
           // System.out.println("s1 is"+s1+" s2 is "+s2);
           
           StringBuilder a=new StringBuilder();
           StringBuilder b=new StringBuilder();
           for(int x=0;x<s1.length();x++)
           {
               if(s1.charAt(x)!='.')
               {
                   a.append(s1.charAt(x));
               }
           }
           for(int x=0;x<s2.length();x++)
           {
               if(s2.charAt(x)!='+'){
               b.append(s2.charAt(x));
               }
           }
           a=a.append(b);
           //System.out.println(a.toString());
           h.add(a.toString());
           }
           System.out.println(h.size());
    }
}
