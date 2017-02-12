package com.company.codility;

/*
 https://codility.com/programmers/lessons/8-leader/dominator/
 Space Complexity O(1)
 Time Complexity O(N)
 */
public class Dominator {

    public static void runTest(){
        System.out.println(new Dominator().solution(new int[]{3,4,3,2,3,-1,3,3}));
        System.out.println(new Dominator().solution(new int[]{}));
        System.out.println(new Dominator().solution(new int[]{1,1,1,1,2,2,2,2,2}));
        System.out.println(new Dominator().solution(new int[]{1,1,1,1,2,2,2,2}));
        System.out.println(new Dominator().solution(new int[]{3}));
    }

    public int solution(int[] A){

        // Using a stack approach but with 2 variables because
        // using an actual stack would make space complexity O(N)
        if(A.length == 0) return -1;

        int stackCount = 1;
        int dominator = A[0];

        for(int i=1; i<A.length; i++){
            if(A[i] == dominator){
                stackCount++;
            }
            else {
                stackCount--;
                if(stackCount == 0){
                    dominator = A[i];
                    stackCount++;
                }
            }
        }
        int dominatorIndex = -1;
        int dominatorCount = 0;
        for(int i=0; i<A.length; i++)
            if(A[i] == dominator) {
                dominatorCount++;
                dominatorIndex = i;
            }

        System.out.println("Dominator: " + dominator);

        if(dominatorCount > A.length/2)
            return dominatorIndex;
        return -1;
    }
}
