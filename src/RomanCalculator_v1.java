import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RomanCalculator_v1 {

    public static String romanFromDigits(String inputDigits){

        String[] romans = {"I", "V", "X", "L", "C", "D", "M"};

        String thousands = inputDigits.substring(0, inputDigits.length()-3);
        String hundreds = inputDigits.substring(inputDigits.length()-3, inputDigits.length());
        //System.out.println(thousands);
        //System.out.println(hundreds);
        String[] numerals = hundreds.split("");

        int[] digits = new int[3];
        for(int i=0; i<numerals.length; i++)    digits[i] = Integer.parseInt(numerals[i]);

        String resultHundreds = "";
        String resultThousands = "M".repeat(Integer.parseInt(thousands));

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
        return resultRoman;
    }
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

    public static int digitsFromRoman(String inputRomanString) {

        char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int resultArab = 0;
        //String inputRomanString = "MMMMMMCMXXXIV";


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
        return resultArab;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a Roman Number");
        String input = scan.nextLine().trim();



        while(Pattern.compile("[^IVXLCDM\\+\\-/* ]").matcher(input).find()){

            if(Pattern.compile("[1-9]").matcher(input).find()){
                System.out.println("Roman Number can not contain any digits");
            } else if (Pattern.compile("[a-z]").matcher(input).find()) {
                System.out.println("Roman Number must be all Caps");
            } else if (Pattern.compile("[^IVXLCDM]").matcher(input).find()) {
                System.out.println("Roman Number must contain only I V X L C D M");
            }
            input = scan.nextLine().trim();
        }


        char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        String inputRomanString = "MMMMMMCMXXXIV";
        int resultArab = 0;

        char[] charArray = inputRomanString.toCharArray();
        //System.out.println(charArray);
        for (int i = 0; i < charArray.length; i++) {
            //System.out.println(arab(charArray[i]));
            if (i < (charArray.length - 1) && arabic(charArray[i]) < arabic(charArray[i + 1])) {
                resultArab -= arabic(charArray[i]);
            } else {
                resultArab += arabic(charArray[i]);
            }
        }
        //System.out.println(resultArab);






    }
}
