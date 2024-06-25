package Uplus_Java_Class;

import java.util.Arrays;

public class sortkmp {
    public static void main(String[] args) {
        int[] a = {30,20,590,1,2,49,4,10};
        for(int i = 1; i < a.length; i++) {
            int k = i;
            for(int j = i-1; j >= 0; j--) {
                if(a[j] > a[k]) {
                    int T = a[j];
                    a[j] = a[k];
                    a[k] = T;
                    k = j;
                }
            }
            System.out.println(Arrays.toString(a));
        }
    }
}
