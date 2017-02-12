package com.company.sort;

import java.util.Arrays;

/**
 * Created by aliasghar on 28/01/2017.
 */
public class Merge {
    public static int[] sort(int[] list){

        if(list.length <= 1)
            return list;

        int[] left = sort(Arrays.copyOfRange(list,0,list.length/2));
        int[] right = sort(Arrays.copyOfRange(list,list.length/2,list.length));

        int leftIndex = 0;
        int rightIndex = 0;

        //merging
        for(int i=0; i<list.length; i++){
            if(leftIndex >= left.length)
                list[i] = right[rightIndex++];
            else if(rightIndex >= right.length)
                list[i] = left[leftIndex++];
            else if(left[leftIndex] < right[rightIndex])
                list[i] = left[leftIndex++];
            else list[i] = right[rightIndex++];
        }
        return list;
    }
}
