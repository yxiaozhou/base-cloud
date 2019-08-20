package com.test;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int a[] = {6,4,1,5,6,12,7,3,11,9,90,0};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i] < a [j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            System.out.println(Arrays.toString(a));
        }
    }
}
