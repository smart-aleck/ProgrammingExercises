package com.company.careercup;

import java.util.HashMap;
import java.util.Map;

public class SubStringWithDistinct {

    public String find(String str, int subStringLength){

        String subString = "";
        Map<Character, Integer> uniqueChars = new HashMap<>();
        char[] chars = str.toCharArray();
        int start = 0;
        int end = 0;

        while (end < chars.length){

            if(uniqueChars.containsKey(chars[end]))
                uniqueChars.put(chars[end], uniqueChars.get(chars[end])+1);
            else uniqueChars.put(chars[end], 1);

            if(uniqueChars.size() == subStringLength){
                String newSubString = str.substring(start, end+1);
                if(subString.length() < newSubString.length())
                    subString = newSubString;
            }
            if(uniqueChars.size() > subStringLength){
                start += uniqueChars.get(chars[start]);
                uniqueChars.remove(chars[start-1]);
            }
            end++;
        }
        return subString;
    }
}
