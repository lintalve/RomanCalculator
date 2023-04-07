import java.util.ArrayList;
import java.util.List;


public class ConversionFromRoman_v3_2 {
    public static int arab(char rom){
        return Roman.valueOf(String.valueOf(rom)).arabic;
    }
    static public int arabic(char romanNumeral) {
        switch (romanNumeral) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;

            default: return 3;

        }
    }

    public static void main(String[] args) {

        int anInt = Integer.parseInt("994");
        int[] intArray = Integer.toString(anInt).chars().map(c -> c - '0').toArray();
        List<String> result = new ArrayList<String>();


        char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        String inputRomanString = "MMMMMMCMXXXIV";
        int resultArab = 0;

        char[] charArray = inputRomanString.toCharArray();
        System.out.println(charArray);
        for (int i = 0; i < charArray.length; i++) {
            //System.out.println(arab(charArray[i]));
            if (i < (charArray.length - 1) && arabic(charArray[i]) < arabic(charArray[i + 1])) {
                resultArab -= arabic(charArray[i]);
            } else {
                resultArab += arabic(charArray[i]);
            }
        }
        System.out.println(resultArab);
    }
}
