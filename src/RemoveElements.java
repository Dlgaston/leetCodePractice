import java.util.Arrays;

public class RemoveElements {
    public static int removeElements(int[] nums, int val) {
        // Extremely similar to the last problem. Just needed to modify code slightly.
        if (nums == null || nums.length == 0) return 0;
        int count=0;
        // Starts at index 0, with a count of negative one.
        for (int i=0; i<nums.length; i++) {
            //If the current index value of nums does not equal the element to remove --> count is increased and
            //The index of the count is replaced with the current index.
            //If the index value of nums is equal to the el, index is increased and next value is checked.
            if (nums[i] != val) {
                // count increments after assignment
                nums[count++] = nums[i];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(removeElements(nums, 3));
        int[] nums2 = {0,1,2,2,3,0,4,2};
        System.out.println(removeElements(nums2, 2));
    }
}
