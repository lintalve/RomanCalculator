import java.util.ArrayList;
import java.util.List;


public class ConversionFromRoman_v1 {

    public static void main(String[] args) {

        int anInt = Integer.parseInt("994");
        int[] intArray = Integer.toString(anInt).chars().map(c -> c - '0').toArray();
        List<String> result = new ArrayList<String>();



        Roman roman = Roman.I;
        String romanName = Roman.I.name();


        /*
        private String which(Roman roman) {
            switch (roman) {
                case 1 : return "thumb";
                case 2 : return "show";
                case 3 : return "knee";
                case 4 : return "door";
                case 5 : return "hive";
                case 6 : return "sticks";
                case 7 : return "heaven";
                case 8 : return "pate";
                case 9 : return "spine";
                case 10 : return "shin";
                default: return "";

            }
        }
        */
        char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        String inputRomanString = "MMMMMMCMDLXIII";
        int outputArabicNumber = 0;

        char[] charArray = inputRomanString.toCharArray();
        ArrayList<Roman> romanArray = new ArrayList<>();
        for (int i=0; i<charArray.length; i++) {
            romanArray.add(Roman.valueOf(String.valueOf(charArray[i])));
            if (charArray[i] < charArray[i + 1])
                outputArabicNumber -= Roman.valueOf(String.valueOf(charArray[i])).arabic;
            outputArabicNumber += Roman.valueOf(String.valueOf(charArray[i])).arabic;
        }


        int[]  results = new int[4];
        int buffer = 0;
        for (int i = 0; i < charArray.length; i++) {

            if (charArray[i] == 'I' || charArray[i] == 'V' || charArray[i] == 'X'){
                if (charArray[i] == charArray[i - 1]) buffer++;
            }

            // case I or V or X   - we are dealing with units





        }
    }
}
/*
        for(int i=intArray.length-1; i>=0; i--){
            int iteration = intArray.length-i-1;
            int romanCPos = iteration * 2 + 1;
            if(intArray[i]%5 < 4){
                System.out.println(romans[romanCPos].repeat(intArray[i]/5) + romans[romanCPos-1].repeat(intArray[i]%5));
            }
            if(intArray[i]%5 == 4) {
                System.out.println(romans[romanCPos - 1] + romans[romanCPos+intArray[i]/5]);
            }
        }*/

