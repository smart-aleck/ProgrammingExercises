package com.company.codility;

/**
 * Created by aliasghar on 03/02/2017.
 */
public class MaxCounters {

    public int[] solution(int N, int[] A){
        int[] counters = new int[N];

        int runningMax = 0;
        int currentMax = 0;
        for(int c=0; c<N; c++)
            counters[c] = 0;

        for(int i=0; i<A.length; i++){
            if(A[i] == N+1){    // Setting current max to all counters
                currentMax = runningMax;
            }
            else{
                int counterIndex = A[i]-1;
                if(counters[counterIndex] < currentMax)
                    counters[counterIndex] = currentMax;

                if(++counters[counterIndex] > runningMax)
                    runningMax = counters[counterIndex];
            }
        }
        for(int c=0; c<N; c++)
            if(counters[c] < currentMax)
                counters[c] = currentMax;

        return counters;
    }
}
