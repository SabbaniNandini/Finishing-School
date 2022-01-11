/*Mahalakshmi participated in a treasure-hunt conatins N boxes in it.
Each box is numbered from 0,1,2,3,...,N-1. 
All the boxes are intially locked with the passcodes, except Box-0.
The passcode is written in a envolope and marked with its concern box number.

Each box in the treasure hunt contains a list of envelopes, which has 
passcodes to open the other boxes. You can open the boxes in any order, 
but you have to start from box-0 intially.

The rule to win the treasure-hunt is to open all the boxes.
Your task is to find out, whether Mahalakshmi win the treasure hunt or not.
If she win, print "Win".
Otherwise, print "Lost"

Input Format:
-------------
Line-1: An integer, number of boxes.
Next N lines: space separated integers, box numbers.

Output Format:
--------------
Print a string value, Win or Lost


Sample Input-1:
---------------
5
1
2
3
4
3
Sample Output-1:
----------------
Win


Sample Input-2:
---------------
5
1
2
3
4

Sample Output-2:
----------------
Lost
*/
import java.util.*;
import java.lang.*;
class ma{
    public static void dfs(int i,ArrayList<ArrayList<Integer>> ar,int visited[])
    {
        if(visited[i]==1)
        {
            return ;
        }
        visited[i]=1;
        for(int j=0;j<ar.get(i).size();j++){
        dfs(ar.get(i).get(j),ar,visited);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       String a[]=new String[n+1];
       for(int i=0;i<n+1;i++)
       {
           a[i]=sc.nextLine();
       }
       ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
      
       for(int i=1;i<a.length;i++)
       {
           ArrayList<Integer> k=new ArrayList<>();
          String arr[]=a[i].split(" ");
          for(int j=0;j<arr.length;j++)
          {
              k.add(Integer.parseInt(arr[j]));
          }
          ar.add(k);
       }
       int visited[]=new int[n];
       dfs(0,ar,visited);
    for(int i=0;i<visited.length;i++)
    {
        if(visited[i]==0)
        {
            System.out.println("Lost");
            System.exit(0);
        }
    }
    System.out.println("Win");
    }
}
