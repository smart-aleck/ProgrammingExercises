package com.company.codility;

/**
 * Created by aliasghar on 02/02/2017.
 */
public class CyclicRotation {

    public int[] solution(int[] A, int K){
        return solveUsingExtraArray(A, K);
    }
    private int[] solveUsingExtraArray(int[] A, int K){
        int[] tempArray = new int[A.length];
        for(int i=0; i<A.length; i++){
            tempArray[(K+i)%A.length] = A[i];
        }
        return tempArray;
    }
    private int[] solveUsingNoExtraArray(int[] A, int K){
        for(int n=0; n<K; n++) {
            int temp = A[A.length-1];
            for (int i=A.length-1; i > 0; i--) {
                A[i] = A[i-1];
            }
            A[0] = temp;
        }
        return A;
    }
    private int[] solveUsingExtraK(int[] A, int K){
        int[] tempArray = new int[K];
        for(int i=0; i<K; i++)
            tempArray[i] = A[A.length-K];

        for(int i=A.length-1; i>=K; i--){
            A[i] = A[i-K];
        }
        for(int i=0; i<K; i++){
            A[i] = tempArray[i];
        }
        return A;
    }
}
