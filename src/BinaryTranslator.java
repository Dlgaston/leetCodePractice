import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class BinaryTranslator {
    public static ArrayList<String> bitStreamToBytes(String s){
        ArrayList<String> bytes = new ArrayList<>();
        while(s.length()%8!=0){
            s="0" + s;
        }
        for (int i = 0; i < s.length(); i+=8) {
            bytes.add(s.substring(i,i+8));
        }
        return bytes;
    }
    public static String asciitoString(Character c){
        return c.toString();
    }
    public static Character decimalToASCII(int d){
        return (Character) (char) d;
    }
    public static ArrayList<Integer> byteStreamArrToDec(ArrayList<String> sArr){
        ArrayList<Integer> decArr = new ArrayList<>();
        for(String s:sArr){
            decArr.add(binaryToDecimal(s));
        }
        return decArr;
    }
    public static int binaryToDecimal(String b){
        String rev = new StringBuilder(b).reverse().toString();
        int sum =0;
        for (int i = 0; i < rev.length(); i++) {
            if(rev.charAt(i)=='1') {
                sum += (int) Math.pow(2.0, i);
            }
        }
        return sum;
    }
    private static String buildBinaryToASCII(String s){
        ArrayList<String> byteStream = bitStreamToBytes(s);
        ArrayList<Integer> decStream = byteStreamArrToDec(byteStream);
        String word="";
        for(Integer dec: decStream){
            word+= asciitoString(decimalToASCII(dec));
        }
        return word;
    }
    public static ArrayList<String> convertBinaryArrToASCII(ArrayList<String> sArr){
        ArrayList<String> binaryToASCIIArr = new ArrayList<>();
        for(String s:sArr){
            binaryToASCIIArr.add(buildBinaryToASCII(s));
        }
        return binaryToASCIIArr;
    }
    public static void main(String[]args){
        ArrayList<String> message = new ArrayList<>();
        message.add("0100110101100001011011100111010101100001011011000010000001000011011011110110111001100110011010010110011101110101011100100110000101110100011010010110111101101110");
        message.add("01101000011000010110110001101100");
        message.add("01101100011010010110001001110010011000010111001001111001");
        message.add("011000110110111101101101011100000110000101110010011101000110110101100101011011100111010001110011");
        message.add("0111010001100101011000110110100001110010011011110110111101101101");
        message.add("0111001101100101011000110111010101110010011010010111010001111001");
        message.add("011011000110000101100010");
        message.add("01100010011000010110001101101011");

        ArrayList<String> completed = convertBinaryArrToASCII(message);

        completed.forEach(System.out::println);




    }
}
