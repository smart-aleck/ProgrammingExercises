package com.company.codility;

/**
 * Created by aliasghar on 04/02/2017.
 */
public class CountFactors {
    public int solution(int N) {
        if(N == 1) return 1;
        int factors = 2; // 1 and N

        int i=2;
        int end = N/2;
        while(i<=end) {
            if (N % i == 0) {
                factors++;
            }
            if (N%end == 0 && i != end){
                factors++;
            }
            end--;
            i++;
        }
        return factors;
    }
}
