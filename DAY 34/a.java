public import java.util.*;
import java.lang.*;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<m;i++)
        {
            int k=sc.nextInt();
            if(k==1)
            {
                if(arr[0]!=1)
                {
                    arr[0]=1;
                }
                else if(arr[n-1]!=1)
                {
                    arr[n-1]=1;
                }
                else
                {
                    int max=0;
                    int p=0;
                    int q=0;
                    for(int x=0;arr[x]==1;x++)
                    {
                        for(int y=x;arr[y]==1;y++)
                        {
                            if(arr[x]==1&&arr[y]==1)
                            {
                                if(max<y-x)
                                {
                                    p=x;
                                    q=y;
                                    max=y-x;
                                }
                            }
                        }
                    }
                    System.out.println(" p  is "+p+" q is "+q);
                    if(arr[(p+q)/2]==0){
                        System.out.println(" i  is "+i+" index is "+(p+q)/2);
                    arr[(p+q)/2]=1;
                    }
                    
                }
            }
            else
            {
                int s=sc.nextInt();
                arr[s]=2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}class a {
    
}
