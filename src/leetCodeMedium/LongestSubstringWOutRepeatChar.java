package leetCodeMedium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class LongestSubstringWOutRepeatChar {
    public static void main(String[] args) {
        String s = "au";
        System.out.println(lengthOfLongestSubstring(s));

    }
    public static int lengthOfLongestSubstring(String s) {
    if(s.length() == 0) return 0;
    if(s.length() == 1) return 1;

    List<String> list = new ArrayList<>();
    for(int i = 0; i < s.length()-1; i++) {
        String temps ="";
        for(int j = i; j < s.length(); j++) {
            if(temps.contains(String.valueOf(s.charAt(j)))) {
                break;
            }
            temps += s.charAt(j);
        }
        list.add(temps);
    }
    return list.stream().max(Comparator.comparingInt(String::length)).get().length();
    }
}
