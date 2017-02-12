package com.company.codility;

/**
 * Created by aliasghar on 02/02/2017.
 */
public class BinaryGap {

    public int solution(int N) {
        char[] binaryString = Integer.toBinaryString(N).toCharArray();
        System.out.println(binaryString);

        int max = 0;
        int currentMax = 0;
        for(char bit : binaryString){
            if(bit == '0')
                currentMax++;
            else {  // 1
                if(currentMax > max)
                    max = currentMax;
                currentMax = 0;
            }
        }
        return max;
    }
}
