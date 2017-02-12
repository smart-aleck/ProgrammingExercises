package com.company.sort;

import java.util.Arrays;

/**
 * Created by aliasghar on 28/01/2017.
 */
public class Heap {
    public static int[] sort(int[] list){
        list = buildHeap(list);
        System.out.println(Arrays.toString(list));
        for(int i=list.length-1; i>0; i--){
            list = Swap.withExtraVar(list, 0, i);
            list = satisfyHeap(list, 0, i-1);
        }
        return list;
    }

    private static int[] buildHeap(int[] list){
        // Start from the parent of the last element
        for(int i=(list.length-2)/2; i>=0; i--){
            list = satisfyHeap(list, i);
        }
        return list;
    }

    private static int[] satisfyHeap(int[] list, int nodeIndex, int endIndex){
        int leftChildIndex = (nodeIndex*2)+1;
        int rightChildIndex = (nodeIndex*2)+2;

        int largestIndex = nodeIndex;
        if(leftChildIndex <= endIndex && list[leftChildIndex] > list[largestIndex])
            largestIndex = leftChildIndex;
        if(rightChildIndex <= endIndex && list[rightChildIndex] > list[largestIndex])
            largestIndex = rightChildIndex;

        if(largestIndex != nodeIndex){
            list = Swap.withExtraVar(list,largestIndex, nodeIndex);
            satisfyHeap(list, largestIndex, endIndex);
        }

        return list;
    }
    private static int[] satisfyHeap(int[] list, int nodeIndex){
        return satisfyHeap(list, nodeIndex, list.length-1);
    }
}
