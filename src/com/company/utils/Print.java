package com.company.utils;

import com.company.datastructures.BinaryTree;

import java.util.Arrays;
import java.util.List;

public class Print {

    public static <T> void print1DArray(T[] input){
        System.out.println(Arrays.toString(input));
    }
    public static <T> void printList(List<T> input){
        print1DArray(input.toArray());
    }
    public static <T> void printListOfLists(List<List<T>> input){
        for(List<T> list : input)
            printList(list);
    }

    public static <T> void print2DArray(T[][] matrix){
        printMatrix(matrix);
    }
    public static <T> void printMatrix(T[][] matrix){
        System.out.println();
        for(int x=0; x<matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                System.out.print(matrix[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static <T> void printBinaryTree(BinaryTree bTree){
        printBinaryTreeInOrder(bTree);
        System.out.println();
    }
    private static  <T> void printBinaryTreeInOrder(BinaryTree bTree){
        if(bTree == null)
            return;
        printBinaryTreeInOrder(bTree.getLeftTree());
        System.out.print(bTree.getValue().toString() + ", ");
        printBinaryTreeInOrder(bTree.getRightTree());
    }

}
