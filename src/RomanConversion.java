import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RomanConversion {
    static String[] romansUnits = {"I", "II", "III", "IV", "V", "VI", "VII", "IX"};
    static String[] romansTens = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static String[] romansHundreds = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    static String[] romansThousands = {"M", "MM", "MMM", "MMMM", "MMMMM", "MMMMMM", "MMMMMMM", "MMMMMMMM", "MMMMMMMMM"};
    static String[] romans = {"I", "V", "X", "L", "C", "D", "M"};
    public static void main(String[] args){
        if(args.length <1) System.out.println("please provide a valid input");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
        }

        //String str = Integer.toString(18376215);
        //IntStream istream = "325234".chars();

        int[] array = new int[5];
        int anInt = Integer.parseInt("12873654");
        //System.out.println(istream);
        int[] intArray = Integer.toString(anInt).chars().map(c -> c-'0').toArray();
        //System.out.println("This is a string".getChars(0, 6););

        List<String> result = new ArrayList<String>();
        for(int i=intArray.length-1; i>=0; i--){
            System.out.print(intArray[i]);
            if(i==intArray.length-1){
                System.out.println("we are dealing with single digits " + intArray[i]);
                System.out.println(romansUnits[intArray[i-1]]);
                //result.add(romans[i]);


            }
            if(i==intArray.length-2){
                System.out.println("we are dealing with tens " + intArray[i]);
                //if(intArray[i] < 4)
                System.out.println(romansTens[intArray[i+1]]);
                //result.add(romans[i]);
            }
            if(i==intArray.length-3){
                System.out.println("we are dealing with hundreds " + intArray[i]);
                System.out.println(romansHundreds[intArray[i+1]]);
                //result.add(romans[i]);
            }
            if(i==intArray.length-4){
                System.out.println("we are dealing with thousands " + intArray[i]);
                System.out.println(romansThousands[intArray[i+1]]);
                //result.add(romans[i]);
            }
        }
        for(String s : result){
            System.out.print(s);
        }
        //System.out.println(result.toString());
    }
}
