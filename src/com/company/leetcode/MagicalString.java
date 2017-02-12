package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  https://leetcode.com/problems/magical-string/
 */
public class MagicalString {

    public static void runTest(){
        int numOfOnes = new MagicalString().returnOnesInMagicalStringOfLength(20);
        System.out.println();
        System.out.println(numOfOnes);
    }

    public int returnOnesInMagicalStringOfLength(int n){
        List<Integer> magicalString = new ArrayList<>(Arrays.asList(1,2,2,1,1));
        int currentIndex = 3;
        int currentDigit = magicalString.get(magicalString.size()-1);
        while (magicalString.size() < n){
            currentDigit = currentDigit == 2 ? 1 : 2;
            if(magicalString.get(currentIndex) == 2){
                magicalString.add(currentDigit);
                magicalString.add(currentDigit);
            }
            else{
                magicalString.add(currentDigit);
            }
            currentIndex++;
        }

        int countOfOnes = 0;
        for(int i=0; i<n; i++) {
            System.out.print(magicalString.get(i));
            if (magicalString.get(i) == 1)
                countOfOnes++;
        }

        return countOfOnes;
    }
}
