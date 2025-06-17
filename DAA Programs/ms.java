public class ms
{
    static void mergesort(int a[],int low,int high)
    {
        if(low<high)
        {
            int mid=(low+high)/2;
            mergesort(a,low,mid);
            mergesort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }

    static void merge(int a[],int low,int mid,int high)
    {
        int left[]=new int[mid-low+1];
        int right[]=new int[high-mid];

        int i=0,j=0,k=low;

        System.arraycopy(a,low,left,0,mid-low+1);
        System.arraycopy(a,mid+1,right,0,high-mid);

        while(i<left.length && j<right.length)
        {
            if(left[i]<=right[j])
            {
                a[k]=left[i];
                i++;
            }
            else{
                a[k]=right[j];
                j++;
            }
            k++;
       }

            while(i<left.length)
            {
                a[k]=left[i];
                i++;
                k++;
            }
            while(j<right.length)
            {
                a[k]=right[j];
                j++;
                k++;
            }
        }

        public static void main(String args[])
        {
            int a[]={4,7,2,3};
            mergesort(a,0,a.length-1);
            for(int num:a)
            {
                System.out.println(num+" ");
            }
        }
}