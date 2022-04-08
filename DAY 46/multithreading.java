/*Priyanka taught a new fun time program practice for Engineering Students.
As a part of this she has given set of numbers and given set of ranges, 
and asked the students to find the sum of numbers between the given range,
S and E (S<=E), both are inclusive.

You need to find the total sum of all given range sum's, and 
print the total sum. 

NOTE: Set conatins 1000 numbers.
You have to implement the code using Callable and Future using Java.


Input Format:
-------------
Line-1: An integer N, number of ranges.
Line-2: Two integers S and E, index positions 
		where 0 <= S1 <= E < 1000

Output Format:
--------------
An integer(may be long), total sum of N ranges(s, e).


Sample Input-1:
---------------
3
12 125
10 500
175 350

Sample Output-1:
----------------
4078093
*/
import java.io.*; 
import java.util.*;
import java.util.concurrent.*;
class calculate implements Callable<Integer>{
    private Integer s,e;
    private int arr[];
    public calculate(Integer s,Integer e,int num[]){
        this.s=s;
        this.e=e;
        this.arr=num;
    }
    @Override
    public Integer call() throws Exception{
        int sum=0;
        for(int i=s;i<=e;i++){
            sum+=arr[i];
        }
        return sum;
    }
}
public class RangeSum {
    public static void main(String[] args) throws Exception{
        //Implement your code here
        
        // read set of integers input
        File file = new File("MyFile.txt");
        Scanner sc1=new Scanner(file);
        String[] list=sc1.nextLine().split(" ");
        int numbers[]=new int[list.length];

        for(int i=0;i<list.length;i++)
            numbers[i]=Integer.parseInt(list[i]);
          
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.newFixedThreadPool(n);
         long res=0;
         for(int i=0;i<n;i++){
             int x=sc.nextInt();
             int y=sc.nextInt();
             calculate cal=new calculate(x,y,numbers);
             Future<Integer> temp=executor.submit(cal);
             res+=temp.get();
         }
         System.out.println(res);
         executor.shutdown();
    }
}
