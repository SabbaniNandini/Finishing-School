/*Ashok is given a list of integers nums[].
His task is to find the longest contiguous sublist of S, 
the product of all the numbers in the sublist should be positive.

Your task is to return the length of longest contiguous sublist.

Input Format:
-------------
Space separated integers nums[], list of numbers.

Output Format:
--------------
Print the length of the longest contiguous sublist


Sample Input-1:
---------------
1 -1 2 -2

Sample Output-1:
----------------
4


Sample Input-2:
---------------
-1 -2 -3 0 1

Sample Output-2:
----------------
2

Explanation:
------------
0 is not considered as positive number.


Sample Input-3:
---------------
1 2 3 4 -5 6  7 8

Sample Output-3:
----------------
4
*/
import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String arr[]=s.split(" ");
        int nums[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            nums[i]=Integer.parseInt(arr[i]);
        }
       int positive=0,negative=0, max=0;
        for(int num : nums)
        {
            if(num ==0)
            {
                positive=0;
                negative=0;
            }
            else if(num > 0)
            {
                positive++;
                negative = negative == 0? negative : negative+1;
            }
            else
            {
                int temp = positive;
                positive = negative == 0? negative : negative+1; 
                negative = temp+1;
            }
            
        max = Math.max(positive,max);
        }
        System.out.println(max);
    }
}
