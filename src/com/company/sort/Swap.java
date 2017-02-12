package com.company.sort;

/**
 * Created by aliasghar on 28/01/2017.
 */
public class Swap {
    public static int[] inplace(int list[], int a, int b){
        list[a] = list[a]+list[b];
        list[b] = list[a]-list[b];
        list[a] = list[a]-list[b];
        return list;
    }
    public static int[] withExtraVar(int list[], int a, int b){
        int var = list[a];
        list[a] = list[b];
        list[b] = var;
        return list;
    }
}
