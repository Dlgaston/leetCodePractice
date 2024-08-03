package leetcodeEasy;

import java.util.Arrays;
import java.util.List;

public class LongestPrefix {
    public static String longestCommonPrefix(String[] strs) {
        List<String> l = Arrays.asList(strs);

        if (l.isEmpty() || l.contains("")) {
            return "";
        }
        l.sort(String::compareTo);
        String compWord = l.getFirst();
        String pref="";
        int minCount=Integer.MAX_VALUE;
        for (int i = 1; i < l.size(); i++) {
            int tempCount=0;
            String currWord = l.get(i);
            if(compWord.length()<currWord.length()|| compWord.length()==currWord.length()) {
                for (int j = 0; j <compWord.length(); j++) {
                    if(!(compWord.charAt(j) ==currWord.charAt(j))){
                        break;
                    }
                    tempCount+=1;
                }
            }
            if(compWord.length()>currWord.length()) {
                for (int j = 0; j <compWord.length(); j++) {
                    if(!(compWord.charAt(j) ==currWord.charAt(j))){
                        break;
                    }
                    tempCount+=1;
                }
            }
            if(tempCount<minCount){
                minCount = tempCount;
            }

        }
        if(minCount==0){
            return "";
        }
        return compWord.substring(0,minCount);

    }

    public static void main(String[]args){
        String [] strs = {"cir","car"};
        System.out.println(longestCommonPrefix(strs));
        String[] strs1 = {"acc","aaa","aaba"};
        System.out.println(longestCommonPrefix(strs1));
    }
}
