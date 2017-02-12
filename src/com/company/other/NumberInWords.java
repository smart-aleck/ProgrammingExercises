package com.company.other;

// Limit Int so 2billion
public class NumberInWords {

    public static void runTest(){
        System.out.println(new NumberInWords().print(2053981321));
        System.out.println(new NumberInWords().print(100000006));
    }

    final int BILLION = 1000000000;
    final int MILLION = 1000000;
    final int THOUSAND = 1000;
    final int HUNDRED = 100;

    public String print(int number){
        if(number == 0) return "zero";

        StringBuilder numInWords = new StringBuilder();
        if(number >= BILLION) {
            numInWords.append(threeDigitNumInWords(number/BILLION));
            numInWords.append(" billion ");
            number = number%BILLION;
        }
        if(number >= MILLION) {
            numInWords.append(threeDigitNumInWords(number/MILLION));
            numInWords.append(" million ");
            number = number%MILLION;
        }
        if(number >= THOUSAND) {
            numInWords.append(threeDigitNumInWords(number/THOUSAND));
            numInWords.append(" thousand ");
            number = number%THOUSAND;
        }
        numInWords.append(threeDigitNumInWords(number));

        return numInWords.toString().replace("  "," ");
    }
    private String threeDigitNumInWords(int number){
        StringBuilder numInWords = new StringBuilder();
        if(number >= HUNDRED){
            numInWords.append(numToWordsBasic(number/HUNDRED));
            numInWords.append(" hundred ");
            number = number%HUNDRED;
        }
        if(number>=20){
            int tens = (number/10)*10;
            numInWords.append(numToWordsBasic(tens));
            numInWords.append(" ");
            number -= tens;
        }
        numInWords.append(numToWordsBasic(number));
        return numInWords.toString();
    }
    // 99 and below
    private String numToWordsBasic(int number){
        String words = "";
        switch (number){
            case 90: words = "ninety"; break;
            case 80: words = "eighty"; break;
            case 70: words = "seventy"; break;
            case 60: words = "sixty"; break;
            case 50: words = "fifty"; break;
            case 40: words = "fourty"; break;
            case 30: words = "thirty"; break;
            case 20: words = "twenty"; break;
            case 19: words = "nineteen"; break;
            case 18: words = "eighteen"; break;
            case 17: words = "seventeen"; break;
            case 16: words = "sixteen"; break;
            case 15: words = "fifteen"; break;
            case 14: words = "fourteen"; break;
            case 13: words = "thirteen"; break;
            case 12: words = "twelve"; break;
            case 11: words = "eleven"; break;
            case 10: words = "ten"; break;
            case 9: words = "nine"; break;
            case 8: words = "eight"; break;
            case 7: words = "seven"; break;
            case 6: words = "six"; break;
            case 5: words = "five"; break;
            case 4: words = "four"; break;
            case 3: words = "three"; break;
            case 2: words = "two"; break;
            case 1: words = "one"; break;
        }
        return words;
    }
}
