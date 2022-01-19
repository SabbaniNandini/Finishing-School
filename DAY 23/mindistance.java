/*Sreedhar is a farmer, and he started harvesting the watermelon crop, 
the crop grown very well. There are several watermelons in the crop. 
Sreedhar started picking up the watermelons one by one.
After each pick, he keeps the watermelon in a truck placed inside the crop.

The crop is in the from of 2D grid of size m*n.
You will be given the positions of the truck, Sreedhar's, and the watermelons.  
Positions are represented by the cells in the 2D grid. 

Your task is to find the minimum distance for Sreedhar to collect 
all the watermelons and put them inside the truck one by one. 

Sreedhar can only take at most one watermelon at one time 
and can move in four directions - up, down, left and right, to the adjacent cell. 
The distance is represented by the number of moves.

Input Format:
-------------
Line-1: Two space separated integers m and n, size of crop. 
Line-2: Two space separated integers, position of the truck. 
Line-3: Two space separated integers, position of Sreedhar.
Line-4: An integer W, number of watermelons in the crop.
Next W lines: Two space separated integers, positions of watermelon. 

Output Format:
--------------
An integer, minimum distance covered by Sreedhar to pickup all the watermelons


Sample Input-1:
---------------
5 7		//size of the crop as 2D grid.
2 2		//Truck Position
4 4		//Sreedhar Position
2		//Number of watermelons
3 0		//Watermelon positions
2 5

Sample Output-1:
----------------
12
*/
import java.util.*;
import java.lang.*;
class ma{
    public static int distance(int x1,int y1,int x2,int y2)
    {
        return Math.abs(y1-y2)+Math.abs(x1-x2);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
    
        int ti=sc.nextInt();
        int tj=sc.nextInt();
    
        int si=sc.nextInt();
        int sj=sc.nextInt();
    
        int a=sc.nextInt();
        int total=0;
        int w[][]=new int [a][2];
        for(int i=0;i<a;i++)
        {
             w[i][0]=sc.nextInt();
            w[i][1]=sc.nextInt();
        total=total+2*(distance(ti,tj,w[i][0],w[i][1]));
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<a;i++)
        {
            int d=total-distance(ti,tj,w[i][0],w[i][1])+distance(si,sj,w[i][0],w[i][1]);
            if(d<min)
            {
                min=d;
            }
        }
        System.out.println(min);
        }
}
