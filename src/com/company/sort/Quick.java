package com.company.sort;

import java.util.Arrays;

/**
 * Created by aliasghar on 28/01/2017.
 */
public class Quick {
    public static int[] sort(int[] list){
        return sort(list, 0, list.length-1);
    }
    static int[] sort(int[] list, int start, int end){
        if(end <= start) return list;

        int startIndex = start;
        int endIndex = end-1;
        int pivot = list[end];
        while(endIndex > startIndex){
            if(list[startIndex] > pivot){
                Swap.withExtraVar(list, startIndex, endIndex);
                endIndex--;
            }
            else startIndex++;
        }
        //startIndex and endIndex should be the same value when the loop ends
        //which should be the index of the pivot
        //Putting the pivot in the correct place
        if(pivot < list[startIndex])
            list = Swap.withExtraVar(list, startIndex, end);
        else {
            startIndex++;
            list = Swap.withExtraVar(list, startIndex, end);
        }

        list = sort(list, start, startIndex-1);
        list = sort(list, startIndex+1, end);
        return list;
    }
}
