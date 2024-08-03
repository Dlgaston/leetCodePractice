package leetcodeEasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOnew {
    public static void main(String[] args) {
        int[] intArr = new int[]{9,9,3,9};
        System.out.println(Arrays.toString(plusOne(intArr)));
    }
    public static int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>(Arrays.stream(digits).boxed().toList());
        int marker = list.size() -1;
        while(marker > -1 && list.get(marker) == 9) {
            list.set(marker, 0);
            if(marker == 0){
                list.addFirst(1);
            }
            marker -= 1;
        }
        if(marker != -1) {
            list.set(marker, list.get(marker) + 1);
        }
        return list.stream().mapToInt(e->e).toArray();
    }
}
