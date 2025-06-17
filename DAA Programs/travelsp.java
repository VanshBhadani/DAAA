// tsp problem
import java.util.*;

public class travelsp
{
    static int g[][]={{0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}};
    static int n=4;
    static int mincost=Integer.MAX_VALUE;
    static int bestpath[]=new int[n+1];

    static void find(int level,int p[],boolean vis[],int cost)
    {
        if(level==n)
        {
            int total=cost+g[p[n-1]][p[0]];
            if(total<mincost)
            {
                mincost=total;
                System.arraycopy(p,0,bestpath,0,n);
                bestpath[n]=0;
            }
             return;
        }

        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                p[level]=i;
                vis[i]=true;
                find(level+1,p,vis,cost+g[p[level-1]][i]);
                vis[i]=false;
            }
        }
    }

    public static void main(String args[])
    {
        int p[]=new int[n];
        boolean vis[]=new boolean[n];
        p[0]=0;
        vis[0]=true;
        find(1,p,vis,0);
        System.out.println(mincost);
        for(int i=0;i<n;i++)
        {
            System.out.println(bestpath[i]+1);
        }
    }
}