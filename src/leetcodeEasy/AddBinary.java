package leetcodeEasy;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class AddBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        System.out.println(new BigInteger(a.getBytes(StandardCharsets.UTF_8)));
        System.out.println(addBinary(a, b));
    }
    public static String addBinary(String a, String b) {
        BigInteger ai = new BigInteger(a.getBytes());
        BigInteger bi = new BigInteger(b.getBytes(StandardCharsets.UTF_8));
        BigInteger sum = ai.add(bi);
       return decimalToBinary(sum);
    }
    public static String decimalToBinary(BigInteger a){
        String binary ="";
        while(a.compareTo(BigInteger.ZERO)!=0){
            BigInteger[] bigIntArr = a.divideAndRemainder(BigInteger.valueOf(2));
            a = bigIntArr[0];
            binary += bigIntArr[1];
        }
        return binary;
    }
}
