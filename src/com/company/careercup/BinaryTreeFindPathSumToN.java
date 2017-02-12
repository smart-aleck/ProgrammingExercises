package com.company.careercup;

import com.company.datastructures.BinaryTree;
import com.company.datastructures.BinaryTreeHelper;
import com.company.utils.Print;

import java.util.ArrayList;
import java.util.List;

// https://careercup.com/question?id=5648826070204416
public class BinaryTreeFindPathSumToN {

    public static void runTest(){
        BinaryTree<Integer> bTree = BinaryTreeHelper.populate(new Integer[]{1,2,5,9,7,-2,-4,3,0,8,6,-1,5,4});
        Print.printBinaryTree(bTree);
        Print.printListOfLists(new BinaryTreeFindPathSumToN().findSumOfPathsToN(bTree, 7));
    }

    List<List<Integer>> sumOfPathsToN = new ArrayList<>();
    public List<List<Integer>> findSumOfPathsToN(BinaryTree<Integer> bTree, Integer n){
        traverseAllPaths(bTree, n);
        return sumOfPathsToN;
    }

    private List<List<Integer>> traverseAllPaths(BinaryTree<Integer> bTree, Integer n){
        if(bTree == null)
            return new ArrayList<>();

        List<List<Integer>> leftPaths = traverseAllPaths(bTree.getLeftTree(), n);
        List<List<Integer>> rightPaths = traverseAllPaths(bTree.getRightTree(), n);

        List<List<Integer>> allPaths = new ArrayList<>();
        for(List<Integer> leftPath : leftPaths){
            allPaths = checkAndAddPathIfN(allPaths, leftPath, n, bTree.getValue());
        }
        for(List<Integer> rightPath : rightPaths){
            allPaths = checkAndAddPathIfN(allPaths, rightPath, n, bTree.getValue());
        }
        allPaths = checkAndAddPathIfN(allPaths, new ArrayList<>(), n, bTree.getValue());
        return allPaths;
    }
    private List<List<Integer>> checkAndAddPathIfN(List<List<Integer>> allPaths, List<Integer> path, Integer n, Integer nodeValue){

        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(nodeValue);

        int sum = 0;
        for(Integer node : newPath){
            sum += node;
        }
        if(sum == n)
            sumOfPathsToN.add(newPath);

        allPaths.add(newPath);
        return allPaths;
    }
}
