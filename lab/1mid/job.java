import java.util.*;
public class job {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        int[] slot = new int[11];
        int[] d = new int[11];
        int[] p = new int[11];
        int i, j, n, profit = 0;

        System.out.println("jobs");
        n = s.nextInt();

        for(i = 1; i<=n; i++)
        {
            p[i] = s.nextInt();
            d[i] = s.nextInt();
        }


        for(i = 1; i<=n; i++)
        {
            for(j = 1; j<=n; j++)
            {
                if(p[i] > p[j])
                {
                    int temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;

                    temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }

        for(i = 1; i<=n; i++)
        {
            for(j= d[i]; j>=1; j--)
            {
                if (slot[j] == 0)
                {
                    slot[j] = i;
                    profit += p[i];
                    break;
                }
            }
        }

        System.out.println("slot");
        for (i = 1; i < n; i++)
        {
            System.out.println(slot[i] + " ");
        }

        System.out.println("jobNo\tProfit\tDeadline\tSlot\t Allotted");
        for(i = 1; i<=n; i++)
        {
            if(slot[i] > 0)
            {
                System.out.println(i + "\t" + p[slot[i]] + "\t" + d[slot[i]] + "\t" + i + "\t" + slot[i]);
            }
     
           }   }

}
