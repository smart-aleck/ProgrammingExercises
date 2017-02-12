package com.company.codility;

/**
 * Created by aliasghar on 03/02/2017.
 */
public class BinarySearch {

    public static boolean search(int[] list, int num){
        return search(list, num, 0, list.length-1);
    }
    private static boolean search(int[] list, int num, int low, int high){
        if(low > high) return false;

        int mid = ((high-low)/2)+low;
        System.out.println(list[mid]);
        if(list[mid] == num)
            return true;
        else if(list[mid] > num)
            return search(list, num, low, mid-1);
        else
            return search(list, num, mid+1, high);

    }
}
