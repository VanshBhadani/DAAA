//job scheduling
import java.util.*;

public class jobb
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p[]=new int[11];
        int d[]=new int[11];
        int slot[]=new int[11];

        // profit and deadline
        int i,j;

        for(i=1;i<=n;i++)
        {
            p[i]=sc.nextInt();
            d[i]=sc.nextInt();
        }

        //swap profit and deadline
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                if(p[i]<p[j])
                {
                    int temp=p[i];
                    p[i]=p[j];
                    p[j]=temp;
                    temp=d[i];
                    d[i]=d[j];
                    d[j]=temp;
                }
            }
        }

        int profit=0;

        // reverse loop
        for(i=1;i<=n;i++)
        {
            for(j=d[i];j>=1;j--)
            {
                if(slot[j]==0)
                {
                    slot[j]=i;
                    profit+=p[i];
                    break;
                }
            }
        }
        System.out.println("Slots:");
        for(i=1;i<=n;i++)
        {
            System.out.println(slot[i]+" ");
        }
        System.out.println("JOBNO    PROFIT   DEADLINE    SLOT   ALLOCATED");
        for(i=1;i<=n;i++)
        {
            System.out.printf("\n \n %d %d %d [%d-%d] \n",slot[i],p[slot[i]],d[slot[i]],i-1,i);
        }
        System.out.println(profit);
    }
}