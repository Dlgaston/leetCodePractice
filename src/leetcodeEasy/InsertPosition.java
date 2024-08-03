package leetcodeEasy;

import java.util.Arrays;

public class InsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 6;
        System.out.println(searchIndex(arr, target));
    }

    public static int searchIndex(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int mid =0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid-1;
            }
        }
        if(right < 0 || nums[right] < target){
            return left;
        }
        return right+1;
    }
}

