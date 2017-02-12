package com.company.datastructures;

import java.util.Arrays;

public class BinaryTreeHelper {
    public static <T> BinaryTree populate(T[] list){
        if(list.length < 1)
            return null;

        int mid = list.length/2;
        BinaryTree binaryTree = new BinaryTree(list[mid]);
        if((mid) > 0)
            binaryTree.setLeftTree(BinaryTreeHelper.populate(Arrays.copyOfRange(list, 0, mid)));
        if((list.length-(mid+1)) > 0)
            binaryTree.setRightTree(BinaryTreeHelper.populate(Arrays.copyOfRange(list, mid+1, list.length)));

        return binaryTree;
    }
}
