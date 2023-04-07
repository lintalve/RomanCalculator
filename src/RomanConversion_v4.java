/**
 * Here we're not yet splitting incoming Roman string into thousands and hundreds
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RomanConversion_v4 {

    public static void main(String[] args){

        //int anInt = Integer.parseInt("994");
        int inputArabic = 3662;
        int[] digits = Integer.toString(inputArabic).chars().map(c -> c-'0').toArray();
        List<String> result = new ArrayList<String>();

        String[] romans = {"I", "V", "X", "L", "C", "D", "M"};

        for(int i=digits.length-1; i>=0; i--){
            int iteration = digits.length-i-1;
            int romanCPos = iteration * 2 + 1;
            if(digits[i]%5 < 4){    //goes out of bounds because there are only 7 numerals in romans[]
                System.out.println(romans[romanCPos].repeat(digits[i]/5) + romans[romanCPos-1].repeat(digits[i]%5));
            }
            if(digits[i]%5 == 4) {
                System.out.println(romans[romanCPos - 1] + romans[romanCPos+digits[i]/5]);
            }
        }
    }
}
