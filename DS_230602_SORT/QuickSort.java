package DS_230602_SORT;
import java.lang.Comparable;
import java.security.cert.CertPath;

public class QuickSort {

    public static void sort(Comparable[] a){
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int low, int high){
        if(high <= low) return ;
        int j = partition(a,low,high);
        sort(a, low, j-1);
        sort(a,j+1, high);
    }

    private static int partition(Comparable[] a, int pivot, int high){
        int i = pivot;
        int j = high + 1;
        Comparable p = a[pivot];
        while(true){
            while(isless(a[++i],p)) if(i==high) break;
            while(isless(p, a[--j])) if(j==pivot) break;
            if(i >= j) break;
            swap(a,i,j);
            }
        swap(a,pivot,j);
        return j;
    }

    private static boolean isless(Comparable i, Comparable j){
        return (i.compareTo(j)<0);
    }

    private static void swap(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
