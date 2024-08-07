package leetcodeEasy;

import java.util.HashMap;
import java.util.Objects;

public class RomanInteger {
    public static int romanToInt(String s) {
        HashMap <Character, Integer> key_map = new HashMap<>();
        key_map.put('I', 1);
        key_map.put('V', 5);
        key_map.put('X', 10);
        key_map.put('L', 50);
        key_map.put('C', 100);
        key_map.put('D', 500);
        key_map.put('M', 1000);


        if (s.isEmpty() || (s.length() ==1 )){
            if(key_map.containsKey(s.charAt(0))){
                return key_map.get(s.charAt(0));
            }
            return 0;
        }

        int sum=0;

        for(int i =s.length()-2; i>=0; i--){
            if(key_map.containsKey(s.charAt(i))&& key_map.containsKey(s.charAt(i+1))){
                int right= key_map.get(s.charAt(i+1));
                int left = key_map.get(s.charAt(i));

                if(right<left || right == left){
                    sum +=right;
                }
                if(left<right){
                    sum += Math.abs(right - left);
                    i-=1;
                }

            }
        }
        if(key_map.get(s.charAt(0))>key_map.get(s.charAt(1)) || Objects.equals(key_map.get(s.charAt(0)), key_map.get(s.charAt(1)))){
            sum += key_map.get(s.charAt(0));
        }
        return sum;
    }
    public static void main(String[] args){

        String s ="III";
        int result = romanToInt(s);
        System.out.println(result);
    }
}
