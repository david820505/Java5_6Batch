package day1.LargestNum;

public class FindSecLarge {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,7,8,9,10};
        QuickSelect qs = new QuickSelect();
        int res = qs.findKthLargest(a,2);
        System.out.println(res);
    }
}
