package com.company.sort;

import java.util.Arrays;

/**
 * Created by aliasghar on 28/01/2017.
 */
public class Shell {
    public static int[] sort(int[] list){
        int gap = list.length/2;
        boolean swapped = false;
        while(gap >= 1){
            System.out.println(gap);
            System.out.println(Arrays.toString(list));
            list = Bubble.sort(list, gap);
            System.out.println(Arrays.toString(list));
            gap = gap/2;
        }
        return list;
    }
}
