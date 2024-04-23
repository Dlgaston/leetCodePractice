import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class validParenthesis {
    public static boolean isValid(String s){
        if(s.length()<2){
            return false;
        }
        HashMap<String,String> validKeys = new HashMap<>();
        validKeys.put("{","}");
        validKeys.put("(",")");
        validKeys.put("[","]");
        Stack<String> t = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String digit = Character.toString(s.charAt(i));
            if(validKeys.containsKey(digit)){
                t.push(digit);
            }
            else if(!validKeys.containsKey(digit) && !t.isEmpty()){
                String pair = t.peek();
                if(!digit.equals(validKeys.get(pair))){
                    return false;
                }
                t.pop();
            } else {
                return false;
            }
        }

        return  t.isEmpty();
    }
    public static void main(String[] args){
    String s1 = ")(){}";
    String s2 = "()[]{}{}{}()";
    String s3 = "){";
    String s4 = "{[]}";
    String s5 = "{{[]()}()}";

        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
    }
}
