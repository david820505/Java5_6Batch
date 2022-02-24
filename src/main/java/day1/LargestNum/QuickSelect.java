package day1.LargestNum;

import java.util.Random;

public class QuickSelect {
    int[] gNums;
    public void swap(int a, int b){
        int temp = gNums[a];
        gNums[a] = gNums[b];
        gNums[b] = temp;
    }


    public int partition(int left, int right){
        //random pick quick select
        Random rand = new Random();
        int pivot_idx = left + rand.nextInt(right-left);
        int pivot = gNums[pivot_idx];

        //we want to move the smaller element to the front
        swap(pivot_idx,right);

        int start = left;
        int end = right-1;
        while (start <= end){
            if (gNums[start]>=pivot){
                swap(start,end);
                end--;
            }else{
                start++;
            }

        }
        //move pivot to its location
        swap(start,right);

        return start;

    }

    public int quickSelect(int target,int left, int right){
        //base case
        if(left == right)
            return gNums[left];

        //every time we will pick one number in the range between left and right
        //And then we will move the number that smaller than our pivot number to the left, and larger to the right
        int pivot_idx = partition(left, right);


        //we will check the whether the len of the left side element is larger than n-k or not
        //if L < n-k then we keep sort the right side of array
        //if L > n-k then we keep sort the right side of array
        //In the end we can find the n-k element
        if(pivot_idx == target){
            return gNums[pivot_idx];
        }else if(pivot_idx > target){
            return quickSelect(target,left,pivot_idx-1);
        }else{
            return quickSelect(target,pivot_idx+1, right);
        }

    }

    public int findKthLargest(int[] nums, int k) {
        //k largest means n-k smallest
        gNums = nums;
        int n = nums.length;


        //we keep partition the array, here we will partition the array with indices
        //n-k smallest element in the nums array without using more space
        return quickSelect(n-k, 0 , n-1);
    }
}
