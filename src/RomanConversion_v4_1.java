/**
*  This version puts together roman numerals into a string
* We are also using my code to convert String input into an array of
* integers
 * working version, needs only ternary operators
 * using array of strings instead of streams that I don't know yet
 **/
import java.util.ArrayList;

import java.util.List;
import java.util.stream.IntStream;

public class RomanConversion_v4_1 {

    public static void main(String[] args){
        String input = "2365";
        String[] romans = {"I", "V", "X", "L", "C", "D", "M"};

        String thousands = input.substring(0, input.length()-3);
        String hundreds;
        if(input.length()>3) {    // here we are using if, else. But there's a better construct, more concise
            hundreds = input.substring(input.length() - 3, input.length());
        } else {
            hundreds = input;
        }
        System.out.println(thousands);
        System.out.println(hundreds);
        String[] numerals = hundreds.split("");

        int[] digits = new int[3];
        for(int i=0; i<numerals.length; i++) digits[i] = Integer.parseInt(numerals[i]);

        String resultHundreds = "";
        String resultThousands = "M".repeat(Integer.parseInt(thousands.length()>0 ? thousands : "0"));

        for(int i=digits.length-1; i>=0; i--){
            int iteration = digits.length-i-1;
            int romanCPos = iteration * 2 + 1;
            if(digits[i]%5 < 4){
                String romanNumber = romans[romanCPos].repeat(digits[i]/5) + romans[romanCPos-1].repeat(digits[i]%5);
                resultHundreds = romanNumber + resultHundreds;
                //System.out.println(romanNumber);
            }
            if(digits[i]%5 == 4) {
                String romanNumber = romans[romanCPos - 1] + romans[romanCPos+digits[i]/5];
                resultHundreds = romanNumber + resultHundreds;
                //System.out.println(romanNumber);
            }
        }
        //System.out.println(resultHundreds);
        String resultRoman = resultThousands + resultHundreds;
        System.out.println(resultRoman);
    }
}
