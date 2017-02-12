package com.company.codingInterview.chapter1;

import java.util.Arrays;

/**
 * Created by aliasghar on 22/01/2017.
 */
public class Image90 {

    //int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    //System.out.println(Arrays.deepToString(matrix));
    //matrix = Image90.rotateImageBy90(matrix);
    //System.out.println(Arrays.deepToString(matrix));
    public static int[][] rotateImageBy90(int[][] matrix){
        if(matrix.length <= 1)
            return matrix;

        for(int i=0; i<matrix.length; i++)
            if(matrix.length != matrix[i].length)
                throw new RuntimeException("Matrix is not NxN");

        int temp;
        for(int layer=0; layer<matrix.length/2; layer++){
            for(int element=0; element<(matrix.length-(2*layer))-1; element++){
                temp = matrix[layer][element+layer];

                //top left
                matrix[layer][element+layer] = matrix[element+layer][matrix.length-1-layer];

                //top right
                matrix[element+layer][matrix.length-1-layer] = matrix[matrix.length-1-layer][matrix.length-1-layer-element];

                //bottom right
                matrix[matrix.length-1-layer][matrix.length-1-layer-element] = matrix[matrix.length-1-element-layer][layer];

                //bottom left
                matrix[matrix.length-1-element-layer][layer] = temp;
            }

        }
        return matrix;
    }
}
