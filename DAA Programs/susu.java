// sum of subsets
import java.util.*;
public class susu
{
    static void find(int a[],int target,int i,List<Integer> list)
    {
        if(target==0)
        {
            System.out.println(list);
            return;
        }
        if(i==a.length || target<0)
        {
            return;
        }
        find(a,target-a[i],i+1,new ArrayList<>(list) {{ add(a[i]);}});
        find(a,target,i+1,list);
    }

    public static void main(String args[])
    {
        int a[]={1,2,5,6,8};
        int target=9;
        System.out.println("sum of subset:"+target);
        find(a,target,0,new ArrayList<> ());
    }
}