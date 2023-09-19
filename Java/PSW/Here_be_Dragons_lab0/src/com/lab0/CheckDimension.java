package com.lab0;

public class CheckDimension {
    static int mazeSize = 10;
    public static boolean checkDimension(int i, int k){
        return (i > -1 || i < mazeSize) && (k > -1 || k < mazeSize);
    }
}
