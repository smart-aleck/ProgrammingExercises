package com.company.careercup;

import com.company.utils.Print;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://careercup.com/question?id=5750115626123264
 */
public class SubArraysOfZero {

    public static void runTest(){
        List<Integer[]> results = find(new Integer[]{-1,-1,1,1});
        for(Integer[] result : results)
            Print.print1DArray(result);
    }

    // O(n2)
    public static List<Integer[]> find(Integer[] data){

        List<Integer[]> subArraysOfZeroMaster = new ArrayList<>();

        for(int i=0; i<data.length; i++) {
            int runningSum = 0;
            for (int j = i; j < data.length; j++) {
                runningSum += data[j];
                if (runningSum == 0) {
                    Integer[] currentSubArray = new Integer[j+1-i];
                    System.arraycopy(data, i, currentSubArray, 0, j+1-i);
                    subArraysOfZeroMaster.add(currentSubArray);
                }
            }
        }

        return subArraysOfZeroMaster;
    }
}
