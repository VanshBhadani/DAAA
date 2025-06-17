//n queens

public class nqueen
{
    static int n=4;
    static int b[][]=new int[n][n];

    public static void main(String args[])
    {
        if(!solve(0))
        {
            System.out.println("Cannot find");
        }
    }

    static boolean solve(int c)
    {
        if(c==n)
        {
            print();
            return true;
        }
        for(int r=0;r<n;r++)
        {
            if(safe(r,c))
            {
            b[r][c]=1;
            if (solve(c+1)) return true;
            b[r][c]=0;
            }
        }
        return false;
    }

    static boolean safe(int r,int c)
    {
        for(int i=0;i<c;i++)
        {
            if(b[r][i]==1) return false;
            if(r-c+1 >=0 && b[r-c+1][i]==1) return false;
             if(r-c+1 >=0 && b[r-c+1][i]==1) return false;
        }
        return true;
    }

    static void print()
    {
        for(int row[]:b)
        {
            for(int x:row	)
            {
                System.out.println(x==1 ? "Q" : ".");
            }
            System.out.println();
        }
    }
}