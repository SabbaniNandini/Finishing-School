/*You are given a bunch of sticks with diffrent lengths.
All the even length sticks should be arranged to appear first in the bunch and 
all the odd length sticks should be arranged to appear first in the bunch.

Print the length of the sticks, after arranging them according to above conditions. 

NOTE: The arrangement of sticks should be in order.

Input Format:
-------------
Line-1: An integer N, number of sticks in the bunch
Line-2: N comma separated integers, lengths of the sticks.

Output Format:
--------------
Print the list of length of the sticks after arrangements accordingly.


Sample Input:
-------------
4
1,4,3,2

Sample Output:
--------------
[4,2,1,3]


Sample Input-2:
---------------
10
4,8,5,4,9,8,9,9,1,8

Sample Output-2:
----------------
[4,8,4,8,8,5,9,9,9,1]
*/
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String str=sc.next();
        //String arr[]=str.split(",");
             List<String> even=Stream.of(str.split(","))
             .filter(k->Integer.parseInt(k)%2==0)
             
                 //.boxed()
                 .collect(Collectors.toList());
                 
            List<String> odd=Stream.of(str.split(","))
             .filter(k->Integer.parseInt(k)%2!=0)
             
                 //.boxed()
                 .collect(Collectors.toList());
                 for(int i=0;i<odd.size();i++)
                 {
                     even.add(odd.get(i));
                 }
             System.out.println(even);
    }
}
