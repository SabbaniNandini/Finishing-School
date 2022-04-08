/*FLIPKART online grocery zone offering best prices, and combo offers on a variety
of items. The store has N items which are been sold with a certian price per unit.

There are also combo offers, and each combo offer consists of one or more 
variety of items with a price tag. Each combo offer is represented in the form 
of a list, the last number represents the amount you need to pay for this combo 
offer, other values represents how many specific items you could get if you buy 
this offer. 

Customer can avail the combo offers as many times as they wanted.

Now you are been given pricelist of N items, K number of combo offers, and 
the number of items of each variety need to buy. 

Now it's your turn to find the lowest price you have to pay for to buy exactly 
certain items as given, where you could make optimal use of the combo offers.


Input Format:
-------------
Line-1: Two integers N and K, number of varieties, and number of Combo offers 
Line-2: N space seprated inteegrs, prices of N varieties.
Next K lines: 'N+1' space separated inteegrs, number of items of each variety and
              and last number is cost to buy all these variety of items.
Last Line: N space separated integers, number of items of each variety to buy.

Output Format:
--------------
Print an integer, lowest price to pay for items to buy.


Sample Input-1:
---------------
2 2
3 6
3 1 12
2 3 17
6 6

Sample Output-1:
----------------
40

Explanation:
------------
There are two variety of items, X and Y. Their prices are Rs.3 and Rs. 6 respectively.
In combo offer-1, you can pay Rs.12 for 3X and 1Y
In combo offer-2, you can pay Rs.17 for 2A and 3B.
You need to buy 6A and 6B, so you may pay Rs.34 for 4X and 6Y (combo offer-2), 
and Rs.6 for 2X. So Total of Rs.40


Sample Input-2:
---------------
3 2
1 2 3
1 2 0 4
2 1 2 8
3 4 2

Sample Output-2:
----------------
14
*/
import java.util.*;

class ma{
    public static int min = Integer.MAX_VALUE;
    
    public static boolean isSafe(int a[], int b[], int want[]){
        for(int i=0; i<a.length; i++)
            if(a[i]+b[i]>want[i])
                return false;
        return true;
    }
    
    public static int[] add(int a[], int b[]){
        int temp[] = new int[a.length];
        for(int i=0; i<a.length; i++)
            temp[i] = a[i]+b[i];
        return temp;
    }
    
    public static void func(int comb[][], int var[], int cost[], int want[], int curr, int temp[]){
        boolean flag = false;
        for(int i=0; i<comb.length; i++){
            if(isSafe(temp, comb[i], want)){
                flag = true;
                func(comb, var, cost, want, curr+cost[i], add(temp, comb[i]));
            }
        }
        if(!flag){
            for(int i=0; i<var.length; i++)
                curr+=(var[i]*(want[i]-temp[i]));
            min = Math.min(min, curr);
        }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int var[] = new int[n];
        for(int i=0; i<n; i++)
            var[i] = sc.nextInt();
        int comb[][] = new int[k][n];
        int cost[] = new int[k];
        for(int i=0; i<k; i++){
            for(int j=0; j<n; j++)
                comb[i][j] = sc.nextInt();
            cost[i] = sc.nextInt();
        }
        int want[] = new int[n];
        for(int i=0; i<n; i++)
            want[i] = sc.nextInt();
        func(comb, var, cost, want, 0, new int[n]);
        System.out.println(min);
    }
}
