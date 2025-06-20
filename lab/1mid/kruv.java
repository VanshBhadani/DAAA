import java.util.Scanner;

public class kruv {
    
    static int a, b, u, v, i, j, n, ne = 1;
    static int min, mincost =0;
    static int[][] cost = new int [9][9];
    static int[] parent =new int [9];

    static int find(int i)
    {
        while (parent[i] != 0)
        {
            i = parent[i];
        }
        return i;
    }

    static int uni(int i, int j)
    {
        if(i!=j)
        {
            parent[j] = i;
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.println("vertices: ");
        n = s.nextInt();

        for( i=1; i<= n; i++)
        {
            for(j = 1; j<=n; j++)
            {
                cost[i][j] = s.nextInt();
                if (cost[i][j] == 0)
                {
                    cost[i][j] = 999;
                }
            }
        }

        while(ne<n)
        {
            min = 999;
            for(i = 1; i<=n; i++)
            {
                for(j = 1; j<=n; j++)
                {
                    if (cost[i][j] < min)
                    {
                        min = cost[i][j];
                        a= u = i;
                        b=v=j;
                    }
                } 
            }

            u = find(u);
            v= find(v);

            if(uni(u,v) == 1)
            {
                System.out.println(ne + "edge ("+a+""+b+")= "+ min);
                ne++;
                mincost += min;
            }
            cost[a][b] = cost[b][a] = 999;

        }

        System.out.println("mincost"+ mincost);

    }
}
