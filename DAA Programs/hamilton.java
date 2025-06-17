//hamilton cycle

public class hamilton{
    static int v=5;
    static int p[]=new int[v];
    static boolean vis[]=new boolean[v];

    static boolean f(int g[][],int pos)
    {
        if(pos==v)
        {
            return g[p[pos-1]][p[0]]==1;
        }

        for(int i=0;i<v;i++)
        {
            if(!vis[i] && g[p[pos-1]][i]==1)
            {
                p[pos]=i;
                vis[i]=true;
                if(f(g,pos+1)) return true;
                vis[i]=false;
            }
        }
        return false;
    }

    public static void main(String args[])
    {
        int g[][]={{0,1,0,1,0},{0,0,1,1,0},{1,0,1,1,0},{1,1,0,0,1},{0,1,1,1,0}};
        p[0]=0;
        vis[0]=true;
        System.out.println(f(g,1) ? java.util.Arrays.toString(p) : "no cycle");
    }
}