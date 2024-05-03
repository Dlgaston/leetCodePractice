import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class RemoveDuplicatesfromSortArr {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        //Sorted array -- Code works without it, though I do not know why, as printing shows Array has not been modified.
        for(int i =0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        //Had to look at answer. Could not solve in O(1) while only modifying original array

        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count]) {
                //Count increments before reassignment to equal the next non-unique number, since count is skipped
                //if nums[index] are equal.
                nums[++count] = nums[i];
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,4,3,7,0,2};
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}
