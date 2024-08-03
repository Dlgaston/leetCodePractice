package leetcodeEasy;

import java.util.Arrays;
import java.util.List;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return 0;
        String[] stringArr = s.split(" ");

        return stringArr[stringArr.length - 1].length();
    }
}
