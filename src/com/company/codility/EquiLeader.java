package com.company.codility;

import java.util.HashMap;
import java.util.Map;

/*
 https://codility.com/programmers/lessons/8-leader/equi_leader/
 Space Complexity O(N)
 Time Complexity O(N)
 */
public class EquiLeader {

    public static void runTest(){
        System.out.println(new EquiLeader().solution(new int[]{-1000000000,-1000000000}));
        System.out.println(new EquiLeader().solution(new int[]{4,3,4,4,3,3,3,3,3,3,2}));
        System.out.println(new EquiLeader().solution(new int[]{1,2,3,4,5}));
        System.out.println(new EquiLeader().solution(new int[]{}));
        System.out.println(new EquiLeader().solution(new int[]{4,3,4,4,4,2}));
        System.out.println(new EquiLeader().solution(new int[]{3}));
    }

    public int solution(int[] A){

        if(A.length == 0) return 0;

        Integer[] leaderFromLeft = determineLeader(A, 0, 1);
        Integer[] leaderFromRight = determineLeader(A, A.length-1, -1);

        int countOfEquiLeaders = 0;
        for(int i=0; i<A.length-1; i++)
            if(leaderFromLeft[i] != null && leaderFromLeft[i].equals(leaderFromRight[i+1]))
                countOfEquiLeaders++;

        return countOfEquiLeaders;
    }

    private Integer[] determineLeader(int[] A, int arrayStart, int increment){
        Map<Integer, Integer> integerMap = new HashMap<>();
        Integer[] leaders = new Integer[A.length];
        Integer leader = null;
        Integer maxCount = 0;
        for(int i=0; i<A.length; i++){
            int countOfCurrent = integerMap.getOrDefault(A[arrayStart],0)+1;
            if(countOfCurrent > maxCount) {
                maxCount = countOfCurrent;
                leader = A[arrayStart];
            }
            if(maxCount <= (i+1)/2) // If less than half then it is not a leader
                leader = null;

            leaders[arrayStart] = leader;
            integerMap.put(A[arrayStart], countOfCurrent);

            arrayStart += increment;
        }
        return leaders;
    }
}
