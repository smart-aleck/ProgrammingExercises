package com.company.codility;

import java.util.Arrays;

/**
 * Find paris in a string
 * {1,2,3,1,2,3,1,2,3,1} -> {1,1,1,1,2,2,2,3,3,3} -> 12 pairs
 */
public class MSTask1 {

    public static void runTest(){
        System.out.println(new MSTask1().solution(new int[]{1,2,3,1,2,3,1,2,3,1}));
    }

    public int solution(int[] A){
        Arrays.sort(A);

        int[] parisInA = new int[A.length]; // init with 0

        int totalPairs = 0;
        for(int i=1; i<A.length; i++){
            if(A[i-1] == A[i]){
                parisInA[i] = parisInA[i-1]+1;
                if(parisInA[i] >= 1000000000)
                    return 1000000000;
            }
        }
        for(int i=0; i<parisInA.length; i++){
            totalPairs += parisInA[i];

            if(totalPairs >= 1000000000)
                return 1000000000;
        }
        return totalPairs;
    }
}
