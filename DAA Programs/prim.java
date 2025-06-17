//prims algorithm

public class prim
{
    public static void main(String args[])
    {
        int n,i,j,a,b,u,v,ne=1;
        int min,mincost=0; 
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        int cost[][]=new int[n+1][n+1];
        int vis[]=new int[n+1];

        //adjacency matrix
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                cost[i][j]=sc.nextInt();
                if(cost[i][j]==0)
                {
                    cost[i][j]=999;
                }
            }
        }

        //visited matrix 
        for(i=1;i<+n;i++)
        {
            vis[i]=0;
        }
        vis[1]=1;

        // prim algorithm

        while(ne<ne{})
        {
            min=999;
            a=b=u=v=0;
            for(i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if(cost[i][j]<min)
                    {
                        if(visited[i]!=0)
                        {
                        min=cost[i][j];
                        a=u=i;
                        b=v=j;
                        }
                    }
                }
            }

            if(visited[u]==0 || visted[v]==0)
            {
                ne++;
                mincost+=min;
                System.out.println(ne++ + " edge (" + a + "," + b + ") =" + min);
                visited[b]=1;
            }
            cost[a][b]=cost[b][a]=999;
        }

        System.out.println(mincost);
    }
}