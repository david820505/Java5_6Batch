package day1.MergeIntArr;

public class MergeIntApp {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{8,7,6,5,4};
        int[] res = merge(a,b);

        for(int i = 0; i < res.length;i++)
            System.out.println(res[i]);

    }

    public static int[] merge(int[] arr1, int[] arr2){
        int len = arr1.length + arr2.length;
        int m = arr1.length;
        int[] res = new int[len];
        for(int i = 0; i < m;i++)
            res[i] = arr1[i];

        for(int j = m; j < len; j++)
            res[j] = arr2[j-m];

        return res;
    }
}
