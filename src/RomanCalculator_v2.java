import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RomanCalculator_v2 {

    public static String romanFromDigits(String inputDigits){
        //String inputDigits = "6434";
        String[] romans = {"I", "V", "X", "L", "C", "D", "M"};

        String thousands = inputDigits.length()>3? inputDigits.substring(0, inputDigits.length()-3):"";
        String hundreds = inputDigits.length()>3? inputDigits.substring(inputDigits.length() - 3, inputDigits.length()) : inputDigits;

        //System.out.println(thousands);
        //System.out.println(hundreds);
        String[] numerals = hundreds.split("");
        //for(String num : numerals)System.out.println(num);
        int[] digits = new int[numerals.length];
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

    public static int digitFromRoman(String inputRomanString) {

        char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int resultArabic = 0;
        //String inputRomanString = "MMMMMMCMXXXIV";

        char[] charArray = inputRomanString.toCharArray();
        //System.out.println(charArray);
        for (int i = 0; i < charArray.length; i++) {
            //System.out.println(arab(charArray[i]));
            if (i < (charArray.length - 1) && arabic(charArray[i]) < arabic(charArray[i + 1])) {
                resultArabic -= arabic(charArray[i]);
            } else {
                resultArabic += arabic(charArray[i]);
            }
        }
        return resultArabic;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a Roman Number");
        String input = scan.nextLine().trim();

        while (Pattern.compile("[^IVXLCDM\\+\\-/* ]").matcher(input).find()) {

            if (Pattern.compile("[1-9]").matcher(input).find()) {
                System.out.println("Roman Number can not contain any digits");
            } else if (Pattern.compile("[a-z]").matcher(input).find()) {
                System.out.println("Roman Number must be all Caps");
            } else if (Pattern.compile("[^IVXLCDM]").matcher(input).find()) {
                System.out.println("Roman Number must contain only I V X L C D M");
            } else if (Pattern.compile("[^\\+\\-/* ]").matcher(input).find()) {
                System.out.println("Please use only rational operations =, -, * and /");
            }
            input = scan.nextLine().trim();
        }
        String[] operands = input.split("[\\+\\-/* ]+");
        String[] members = input.split("[ ]+");
        String[] arabMembers = new String[members.length];
        for (int i = 0; i < members.length; i++)
            if (Pattern.compile("[IVXLCDM]").matcher(members[i]).find()) {
                arabMembers[i] = String.valueOf(digitFromRoman(members[i]));
            } else if (Pattern.compile("[\\+\\-/* ]+").matcher(members[i]).find()){
                arabMembers[i] = members[i];
            }

        int res = 0;
        for(int i=0; i<members.length; i++){
            if(members[i].equals("*")){
                //System.out.println(members[i]);
                res = (digitFromRoman(members[i-1]) * digitFromRoman(members[i+1]));
            } else if (i<2 && members[i].equals("/")) {
                //System.out.println(members[i]);
                res = digitFromRoman(members[i-1]) / digitFromRoman(members[i+1]);
            } else if (i<2 && members[i].equals("+")) {
                //System.out.println(members[i]);
                res = digitFromRoman(members[i-1]) + digitFromRoman(members[i+1]);
            } else if (i<2 && members[i].equals("-")) {
                //System.out.println(members[i]);
                res = digitFromRoman(members[i-1]) - digitFromRoman(members[i+1]);
            } else if (i>1 && members[i].equals("*")) {
                //System.out.println(members[i]);
                res *= digitFromRoman(members[i+1]);
            } else if (i>1 && members[i].equals("/")) {
                //System.out.println(members[i]);
                res /= digitFromRoman(members[i+1]);
            } else if (i>1 && members[i].equals("+")) {
                //System.out.println(members[i]);
                res += digitFromRoman(members[i+1]);
            } else if (i>1 && members[i].equals("-")) {
                //System.out.println(members[i]);
                res -= digitFromRoman(members[i+1]);
            }
        }
        for(String arabMember : arabMembers) System.out.print(arabMember + " ");
        System.out.print("\n");
        System.out.println(res);
        System.out.println(romanFromDigits(String.valueOf(res)));
    }
}
