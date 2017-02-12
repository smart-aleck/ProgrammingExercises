package com.company.sort;

import java.util.Arrays;

/**
 * Created by aliasghar on 28/01/2017.
 */
public class Radix {

    public static int[] sort(int[] list, int lengthOfMaxString){

        int[] index;
        String[] listStr = new String[list.length];

        for(int l=lengthOfMaxString-1; l>=0; l--){

            for(int i=0; i<list.length; i++) {
                listStr[i] = String.format("%0" + lengthOfMaxString + "d", list[i]);
                list[i] = -1;
            }
            index = new int[10];
            for(int i=0; i<list.length; i++){
                index[listStr[i].charAt(l)-'0']++;
            }
            for(int i=1; i<index.length; i++)
                index[i] = index[i]+index[i-1];

            for(int i=0; i<list.length; i++){
                int startIndex = 0;
                if(listStr[i].charAt(l)-'0' > 0)
                    startIndex = index[listStr[i].charAt(l)-'0'-1];
                while (list[startIndex] >= 0)
                    startIndex++;
                list[startIndex] = Integer.parseInt(listStr[i]);
            }
        }
        return list;
    }

    public static int[] sortInPlace(int[] list){
        return sortInPlace(list, 1);
    }
    private static int[] sortInPlace(int[] list, int iteration){

        int mod = (int)Math.pow(10,iteration);
        int index = 0;
        for(int count=0; count<10; count++){
            for(int i=0; i<list.length; i++){
                if((list[i]%mod/(mod/10)) == count){
                    if(index != i)
                        list = Swap.withExtraVar(list, index, i);
                    index++;
                }
            }
            if(count == 0 && list.length == index)
                return list;
        }
        if(index < list.length)
            return list;
        return sortInPlace(list, iteration+1);
    }
}
