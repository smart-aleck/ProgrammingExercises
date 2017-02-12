package com.company.codility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by aliasghar on 03/02/2017.
 */
public class FindPeaks {
    public static int find(int[] A){
        int[] peaks = new int[A.length];

        //found all peaks
        int i=1;
        int totalPeaks = 0;
        while(i<A.length-1){
            if(A[i] > A[i-1] && A[i] > A[i+1]) {
                peaks[i] = 1;
                totalPeaks++;
                i++;
            }
            i++;
        }
        System.out.println(Arrays.toString(peaks));
        System.out.println(totalPeaks);
        System.out.println();

        //finding max flags now
//        int maxFlags = 0;
//        while(totalPeaks > maxFlags){
//            int flagsOnPeaks = findFlagsOnPeaks(peaks, totalPeaks);
//            if(flagsOnPeaks > maxFlags){
//                maxFlags = flagsOnPeaks;
//                System.out.println(maxFlags);
//            }
//            totalPeaks--;
//        }
        int maxFlags = findFlagsOnPeaks(peaks, totalPeaks);
        while (totalPeaks > maxFlags){
            int currentMax = findFlagsOnPeaks(peaks, maxFlags+1);
            if(currentMax > maxFlags){
                maxFlags = currentMax;
            }
            else {
                break;
            }
            System.out.println();
        }
        return maxFlags;
    }
    private static int findFlagsOnPeaks(int[] peaks, int flagCount){
        int consumed = 0;
        int i=1;
        while(i<peaks.length-1){
            if(peaks[i] == 1){ //put a flag
                consumed++;
                i+=flagCount-1;
            }
            if(consumed == flagCount)
                break;
            i++;
        }
        System.out.print(flagCount + " " + consumed + " | ");
        return consumed;
    }
}
