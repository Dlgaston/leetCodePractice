import java.util.ArrayList;
import java.util.HashMap;

public class validParenthesis {
    public static boolean sequentialValid(String s, HashMap<String,String> validKeys){
        int count =0;
        for (int i = 0; i <s.length(); i+=2) {
            if(validKeys.containsKey(Character.toString(s.charAt(i))) && Character.toString(s.charAt(i+1)).equals(validKeys.get(Character.toString(s.charAt(i))))){
                count +=1;
            }
        }
        return count == s.length() / 2;
    }
    public static boolean palindromeValid(String s, HashMap<String,String>validKeys){
        int count=0;
        for (int i = 0; i < s.length()/2; i++) {
            if(validKeys.containsKey(Character.toString(s.charAt(i))) && Character.toString(s.charAt((s.length()-1)-i)).equals(validKeys.get(Character.toString(s.charAt(i))))){
                count +=1;
            }
        }
        return count == s.length() / 2;
    }
    public static boolean isValid(String s){
        HashMap<String,String> validKeys = new HashMap<>();
        validKeys.put("{","}");
        validKeys.put("(",")");
        validKeys.put("[","]");
        if(s.isEmpty()||s.length()%2!=0){
            return false;
        }
        return (sequentialValid(s,validKeys)||palindromeValid(s,validKeys));
    }
    public static void main(String[] args){
    String s1 = "()";
    String s2 = "()[]{}{}{}()";
    String s3 = "(]";
    String s4 = "{[]}";

        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
    }
}
