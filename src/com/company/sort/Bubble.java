package com.company.sort;


public class Bubble {

    public static int[] sort(int[] list){
        for(int i=0; i<list.length; i++){
            System.out.println(i);
            boolean isSwapped = false;
            for(int j=0; j<(list.length-i-1); j++){
                if(list[j] > list[j+1]){
                    list = Swap.withExtraVar(list, j, j + 1);
                    isSwapped = true;
                }
            }
            if(!isSwapped)
                break;
        }
        return list;
    }

    public static int[] sort(int[] list, int gap){
        for(int i=0; i<list.length/gap; i++){
            boolean isSwapped = false;
            for(int j=0; j+gap < list.length; j++){
                if(list[j] > list[j+gap]){
                    list = Swap.withExtraVar(list, j, j+gap);
                    isSwapped = true;
                }
            }
            if(!isSwapped)
                break;
        }
        return list;
    }
}
