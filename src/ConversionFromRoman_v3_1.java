import java.util.ArrayList;
import java.util.List;


public class ConversionFromRoman_v3_1 {
    public static int arab(char rom){
        return Roman.valueOf(String.valueOf(rom)).arabic;
    }

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

        String inputRomanString = "MMMMMMCMXXXIV";
        int resultArab = 0;

        char[] charArray = inputRomanString.toCharArray();
        System.out.println(charArray);
        for (int i = 0; i < charArray.length; i++) {
            //System.out.println(arab(charArray[i]));
            if (i < (charArray.length - 1) && arab(charArray[i]) < arab(charArray[i + 1])) {
                resultArab -= arab(charArray[i]);
            } else {
                resultArab += arab(charArray[i]);
            }



        }
        System.out.println(resultArab);
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

