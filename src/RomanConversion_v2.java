/**
 * Here we are using 2 steps for 2 different cases, 0-3, 5-8, and 4, 9
 * because Roman counting system is 5 based, not 10
 * we are running out of Roman Numerals on iteration 4
 * we
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RomanConversion_v2 {

    //static String[] romans = {"I", "V", "X", "L", "C", "D", "M"};
    public static void main(String[] args){



        //int anInt = Integer.parseInt("12873654");
        int anInt = Integer.parseInt("494");
        //System.out.println(istream);
        int[] intArray = Integer.toString(anInt).chars().map(c -> c-'0').toArray();
        //System.out.println("This is a string".getChars(0, 6););
        List<String> result = new ArrayList<String>();

        String[] romans = {"I", "V", "X", "L", "C", "D", "M"};

        for(int i=intArray.length-1; i>=0; i--){
            int iteration = intArray.length-i-1;
            //System.out.println(iteration);
            int romanCPos = iteration + (iteration + 1);
            //System.out.println("current digit index is " + i);
            //System.out.println(intArray[i]);
            if(intArray[i]%5 < 4){
                int romanPosition = romanCPos + intArray[i]/5;
                //System.out.println("repeating " + romans[0]);
                System.out.println(romans[romanCPos].repeat(intArray[i]/5) + romans[romanCPos-1].repeat(intArray[i]%5));
                //result.add(romans[i]);
            }
            if(intArray[i]%5 == 4) {
                //System.out.println("taking middle roman and prefixing with previous " + intArray[i]);
                System.out.println(romans[romanCPos - 1] + romans[romanCPos+intArray[i]/5]);
            }
        }

        //System.out.println(result.toString());
        //romans[romanCPos-1].repeat(intArray[i])
    }
}
