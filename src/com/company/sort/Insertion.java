package com.company.sort;

import java.util.Arrays;

/**
 * Created by aliasghar on 28/01/2017.
 */
public class Insertion {
    public static int[] sort(int[] list){
        for(int i=1; i<list.length; i++){
            int previousIndex = i-1;
            while(previousIndex >= 0 && list[previousIndex] > list[previousIndex+1]){
                list = Swap.inplace(list, previousIndex, previousIndex+1);
                previousIndex--;
                System.out.println(Arrays.toString(list));
            }
            System.out.println(Arrays.toString(list));
        }
        return list;
    }
}
