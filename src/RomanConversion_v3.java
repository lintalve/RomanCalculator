/**
*  Here we are accomplished the algorithm in 2 steps
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RomanConversion_v3 {


    public static void main(String[] args){

        int anInt = Integer.parseInt("923");
        int[] intArray = Integer.toString(anInt).chars().map(c -> c-'0').toArray();
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
