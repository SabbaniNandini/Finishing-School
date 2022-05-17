/*Karthik is going on a world tour, He prefers to travel in airplanes.
He is given a list of planes avaialble , where a plane[i]=[src-i, dest-i].
i.e, plane[i] indiactes airplane from source city to destination city.

Your task is to findout in which city karthk will end up his world tour.
end up the tour means, he cannot travel further from that city.

Note: It is guaranteed that there is no loop. 

Input Format:
-------------
Line-1: An integer N, number of airplanes routes.
next N lines: two comma (',') separated Strings, source and destination.

Output Format:
--------------
Print a string, City Name.


Sample Input:
---------------
3
London,New York
New York,Sydney
Sydney,New Delhi

Sample Output:
----------------
New Delhi
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String arr[][]=new String[n][2];
        String dummy=sc.nextLine();
        for(int i=0;i<n;i++)
        {
           
             arr[i]=sc.nextLine().split(",");
            
            
            
        }
        HashMap<String,String> h=new HashMap<>();
        for(String row[]:arr)
        {
            h.put(row[0],row[1]);
        }
        String k=arr[0][0];
        
        while(true)
        {
          String d=h.get(k);
          //System.out.println(d);
          if(h.containsKey(d))
          {
              k=d;
          }
          else
          {
              System.out.println(d);
              System.exit(0);
          }
        }
    }
}
