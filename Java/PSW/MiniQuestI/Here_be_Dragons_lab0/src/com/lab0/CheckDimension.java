package com.lab0;

public class CheckDimension {
    static int MAZESIZE = 10;
    public static boolean checkDimension(int i, int k){
        return (i > -1 || i < MAZESIZE) && (k > -1 || k < MAZESIZE);
    }
}
