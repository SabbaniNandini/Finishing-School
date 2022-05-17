/*A courier company has to deliver N items with different heights.
All the items have to deliver to one building only.

The building has K rooms inside indexed 0,1,...,K-1, and the heights of 
the rooms are different. All the rooms connected with each other and has 
two entry points, one entry is at frontside and other entry is at backside of 
the building . e.g, you can reach room-1 from room-0 only, room-2 from 
room-1 only, ..so on, and vice-versa.

Now the task of the delivery agent is to keep the items inside the building.

To keep the items into the rooms, delivery agent has to follow these rules:
 - Agent can't keep, two goods in one room.
 - Agent can enter into the building either from frontside or from back side,
   If the height of some room is less than the height of an item,
   then the item will be stopped before that room, so are the items behind it.
 - Agent can rearrange the order of items to keep them inside the building.
   
Your task is to return the maximum number of items, the delivery agent can keep 
inside the building.

Input Format:
-------------
Line-1 -> two integers N and K, number of items and number of rooms.
Line-2 -> N space separated integers, heights of the items.
Line-3 -> K space separated integers, heights of the rooms.

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
5 4
2 3 3 4 5
4 5 2 3

Sample Output-1:
----------------
4

Explanation:
------------
We can first keep the item of height 2 in room 2. 

hen we can keep the item of height 3 in room 3.
Then we can keep the item of height 3 in room 1.
Then we can keep the item of height 4 in room 0.


Sample Input-2:
---------------
4 5
4 6 6 3
3 2 4 5 6

Sample Output-2:
----------------
3

Explanation:
------------
Notice that it's not possible to keep the two items of height 6 into the building,
since there's only 1 room of height >= 6
Other valid solutions are to put the item with height 4 in room 2 or 
to put the item with height 3 in room 2 or room 0 before putting 
the the item with height 4 and 6.
*/
import java.util.*;
import java.lang.*;
public class ma{
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[]=new int[n];
        int a[]=new int[m];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int j=0;j<m;j++)
        {
            a[j]=sc.nextInt();
        }
       /* Arrays.sort(arr);//2 3 3 4 5
        int curmin[]=new int[m];
        curmin[0]=a[0];
        for(int i=1;i<m;i++)           //
        {
            curmin[i]=Math.min(curmin[i-1],a[i]);   // 4 4 2 2 
        }
       int curminback[]=new int[m];
       curminback[m-1]=a[m-1];
       for(int i=m-2;i>=0;i--)
       {
           curminback[i]=Math.min(curmin[i+1],a[i]);
       }
       for(int i=0;i<m;i++)
       {
           curmin[i]=Math.min(curmin[i],curminback[i]);
       }
       Arrays.sort(curmin);
       int ans=0;
       for(int i=0,j=0;i<arr.length&&j<m;i++)
       {
           while(j<m&&arr[i]<curmin[j])
           {
               j++;
           }
           if(j<m&&arr[i]<=curmin[j])
           {
               ans++;
               j++;
           }
       }*/
       System.out.println(solve(arr,a));;
    }
    public static int solve(int[] boxes, int[] warehouse) {
        int roomsCount = warehouse.length;
        int[] validWarehouse = new int[roomsCount];
        int leftValid = Integer.MAX_VALUE;
        for (int i = 0; i < roomsCount; i++) {
            leftValid = Math.min(leftValid, warehouse[i]);
            validWarehouse[i] = Math.max(validWarehouse[i], leftValid);
        }
        int rightValid = Integer.MAX_VALUE;
        for (int i = roomsCount - 1; i >= 0; i--) {
            rightValid = Math.min(rightValid, warehouse[i]);
            validWarehouse[i] = Math.max(validWarehouse[i], rightValid);
        }
        int maxBoxes = 0;
        Arrays.sort(boxes);
        Arrays.sort(validWarehouse);
        int boxesCount = boxes.length;
        for (int i = 0, j = 0; i < boxesCount && j < roomsCount; i++) {
            while (j < roomsCount && boxes[i] > validWarehouse[j])
                j++;
            if (j < roomsCount && boxes[i] <= validWarehouse[j]) {
                maxBoxes++;
                j++;
            }
        }
        return maxBoxes;
    }

}