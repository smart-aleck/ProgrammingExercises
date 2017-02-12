package com.company.datastructures;

public class BinaryTree<T>  {
    T value;
    private BinaryTree leftTree = null;
    private BinaryTree rightTree = null;

    public void setLeftTree(BinaryTree leftTree){
        this.leftTree = leftTree;
    }
    public BinaryTree getLeftTree(){
        return leftTree;
    }
    public void setRightTree(BinaryTree rightTree){
        this.rightTree = rightTree;
    }
    public BinaryTree getRightTree(){
        return rightTree;
    }
    public T getValue(){
        return value;
    }
    public BinaryTree(T value){
        this.value = value;
    }
}
