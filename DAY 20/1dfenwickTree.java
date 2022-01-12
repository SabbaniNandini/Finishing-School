/*Mallika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of numbers, and asked the students 
to find the sum of numbers between indices S1 and S2 (S1<=S2),
both S1 and S2 inclusive.

There are P Students in the class, numbered from 1 to P. Each student is
given set of indices and that student has to find the sum of the numbers 
between the indices and print the result.

And return the answer in the same order of

Input Format:
-------------
Line-1: Two integers N and P, N is length of set of numbers.
		where 1<= N <= 1000
Line-2: N space separated integers, array set[]
Next P lines: Two integers S1 and S2, index positions 
		where 0 <= S1 <= S2 < N
		and 1<= set[i] <= 100000

Output Format:
--------------
Print the sum of numbers between indices(s1, s2) given to each student.


Sample Input-1:
---------------
8 2
115053 59099 681359 526248 123844 612168 920784 591204
2 6
1 5

Sample Output-1:
----------------
2864403
2002718
*/
import java.util.*;
import java.lang.*;
class ma{

    public static void create(int n,int arr[],int tree[])
    {
        for(int i=0;i<n;i++){
        update(n,i,arr[i],tree);
        }
    }
    public static void update(int n,int index,int val,int tree[])
    {
        index=index+1;
        while(index<=n)
        {
            //System.out.println(" index is "+index+" val is "+val);
            
            tree[index]=tree[index]+val;
            //System.out.println(Arrays.toString(tree));
            index=index+(index&(-index));
        }
    }
    public static int sum(int index,int arr[],int tree[])
    {
        int sum=0;
         index=index+1;
        while(index>0)
        {
            sum=sum+tree[index];
            //System.out.println(" sum is "+sum+" index is "+index);
            index=index-(index&(-index));
        }
        return sum;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
        int tree[]=new int[n+1];
        int m=sc.nextInt();
        int arr[]=new int[n+1];
        int a[][]=new int[m][2];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<2;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        create(n,arr,tree);
        for(int i=0;i<m;i++)
        {
            /*System.out.println("sum is last"+(sum(a[i][1],arr,tree)));
            System.out.println(" sum of first "+sum(a[i][0]-1,arr,tree));*/
            System.out.println((sum(a[i][1],arr,tree)-sum(a[i][0]-1,arr,tree)));
        }
    }
}
