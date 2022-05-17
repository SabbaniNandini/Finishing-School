/*Mr Sudhakar has a set of N dices, the dice has different faces of 
movie characters. The possibility score of i-th dice to show the JOKER face
when it is rolled is given as pScore[i].

Your task is to help Mr Sudhakar to find and return the possibility score, that
the number of dices showing JOKER face equals to value F, 
when you roll all N dices only once.

NOTE:
-----
Your output will be accepted as correct,
if they are within 10^-5 of the correct output.

Input Format:
-------------
Line-1: An integer N, number of chances.
Line-2: N space separated double values, possibility pScore[]
Line-3: An integer F, number of dices to show JOKER face up.   

Output Format:
--------------
Print a double result, the possibility score.


Sample Input-1:
---------------
4
0.5 0.25 0.75 0.5
//3 1.5  4.5   3
2

Sample Output-1:
----------------
0.40625



Sample Input-2:
---------------
1
0.6
1

Sample Output-2:
----------------
0.60000


Sample Input-3:
---------------
3
0.4 0.5 0.6
0

Sample Output-3:
----------------
0.12000
*/
import java.util.*;
public class ma{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  double[] arr = new double[n];
		  for(int i=0;i<n;i++) 
		  {
		      arr[i] = sc.nextDouble();
		  }
		  int k=sc.nextInt();
		  HashMap<String,Double> h= new HashMap<>();
		  System.out.printf("%.5f",solve(n-1,arr,k,h));
		}
		public static double solve(int n,double[] arr,int k, Map<String,Double> h){
		    if(n==-1 && k==0) return 1;
		    if(n==-1 || k<0) return 0;
		    String key=n+" "+k;
		    if(h.containsKey(key)) return h.get(key);
		    h.put(key,arr[n]*solve(n-1,arr,k-1,h)+(1-arr[n])*solve(n-1,arr,k,h));
		    return h.get(key);
		}
}
