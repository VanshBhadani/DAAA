import java.util.*;;

public class prim
{   
    
    public static void main(String[] args)
    {
    
        int mincost =0;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int n = s.nextInt();
        int[][] cost = new int [n+1][n+1];
        int [] visited =new int[n+1];
        int  a, b, u, v, ne = 1;
        
        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j<=n; j++)
            {
                cost[i][j] = s.nextInt();
                if (cost[i][j] == 0 )
                {
                    cost[i][j] = 999;
                }
            }
        }

        for(int i=1; i<=n; i++)
        {
            visited[i] = 0;
        }
        visited[1] = 1;
        while(ne<n)
        {
            int min = 999;
            a=b=u=v=0;
            for(int i=1; i<=n; i++)
            {
                for(int j =1; j<=n; j++)
                {
                    if(cost[i][j] < min)
                    {
                        if (visited[i] != 0)
                        {
                            min = cost[i][j];
                            a=u=i;
                            b=v=j;
                        }
                    }
                }
            }
            if(visited[u] == 0 || visited[v] == 0)
            {
                System.out.println("edgr" + ne + ":("+a+""+b+")cost" +min);

                ne++;
                mincost += min;
                visited[b] = 1;
            }
            cost[a][b] = cost[b][a] = 999;
        }
        System.out.print("mincost"+ mincost);

        
        
    }   
}