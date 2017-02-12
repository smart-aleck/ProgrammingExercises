package com.company.careercup;

import com.company.datastructures.BinaryTree;
import com.company.datastructures.BinaryTreeHelper;

public class BinaryTreeKSmallestElemet {

    public static void runTest(){
        BinaryTree<Integer> bTree = BinaryTreeHelper.populate(new Integer[]{2, 4, 6, 8, 10, 12, 14});
        System.out.println(new BinaryTreeKSmallestElemet().findKSmallestElement(bTree, 5));
    }

    int counter;
    public Integer findKSmallestElement(BinaryTree<Integer> bTree, Integer k){
        counter = 0;
        Integer kSmallestElement = findKSmallestElementInOrder(bTree, k);
        if(kSmallestElement == null)
            throw new RuntimeException(k + " smallest element doesn't exist");

        return kSmallestElement;
    }
    private Integer findKSmallestElementInOrder(BinaryTree<Integer> bTree, Integer k){
        if(bTree == null)
            return null;

        Integer leftValue = findKSmallestElementInOrder(bTree.getLeftTree(), k);
        if(leftValue != null)
            return leftValue;

        counter++;
        if(counter == k)
            return bTree.getValue();

        Integer rightValue = findKSmallestElementInOrder(bTree.getRightTree(), k);
        if(rightValue != null)
            return rightValue;

        return null;
    }
}
