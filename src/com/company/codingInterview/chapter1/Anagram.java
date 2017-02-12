package com.company.codingInterview.chapter1;

/**
 * Created by aliasghar on 22/01/2017.
 */
public class Anagram {

    public static boolean checkAnagram(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;

        int[] charArray = new int[256];
        for(char c1 : str1.toCharArray()){
            charArray[c1]++;
        }
        for(char c2 : str2.toCharArray()){
            charArray[c2]--;
        }
        for(int ch : charArray){
            if(ch > 0)
                return false;
        }
        return true;
    }
}
