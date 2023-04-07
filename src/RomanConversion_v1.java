/**
 * Here we are using 4 steps for 4 different cases, 0-3, 4, 5-8 and 9
 * we are running out of Roman Numerals on iteration 4
 * we
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RomanConversion_v1 {

    //static String[] romans = {"I", "V", "X", "L", "C", "D", "M"};
    public static void main(String[] args){


        int anInt = Integer.parseInt("12873654");
        //System.out.println(istream);
        int[] intArray = Integer.toString(anInt).chars().map(c -> c-'0').toArray();
        //System.out.println("This is a string".getChars(0, 6););
        List<String> result = new ArrayList<String>();

        String[] romans = {"I", "V", "X", "L", "C", "D", "M"};

        for(int i=intArray.length-1; i>=0; i--){
            int iteration = intArray.length-i-1;
            System.out.println(iteration);
            int romanCPos = iteration + (iteration + 1);
            System.out.println("current digit index is " + i);
            System.out.println(intArray[i]);
            if(intArray[i] < 4){  // we are running out of Roman numerals on 4th step
                System.out.println("repeating " + romans[0]);
                System.out.println(romans[romanCPos-1].repeat(intArray[i]));
                //result.add(romans[i]);
            }
            if(intArray[i] == 4){
                System.out.println("taking middle roman and prefixing with previous " + intArray[i]);
                System.out.println(romans[romanCPos-1] + romans[romanCPos]);
            }
            if(intArray[i] >4 && intArray[i] < 9){
                System.out.println("wrighting middle roman and adding repeated first " + intArray[i]);
                System.out.println(romans[romanCPos] + romans[romanCPos-1].repeat(intArray[i]-5));
            }
            if(intArray[i] == 9){
                System.out.println("substractive notation upper " + intArray[i]);
                System.out.println(romans[romanCPos-1] + romans[romanCPos+1]);
            }
        }

        //System.out.println(result.toString());
    }
}
