package com.company.codility;

/**
 * Created by aliasghar on 03/02/2017.
 */
public class MinPerimeter {
    public int solution(int N) {
        int maxNum = N;
        int startNum = 1;
        int minPerimeter = Integer.MAX_VALUE;

        if(N == 1) return 4;

        int minNum = (int)Math.sqrt(N);
        while(startNum < maxNum && startNum <= minNum){
            if(N%startNum == 0) {
                maxNum = N / startNum;
                minPerimeter = Math.min(minPerimeter, 2 * (startNum + maxNum));
            }
            startNum++;
        }
        return minPerimeter;
    }
}
