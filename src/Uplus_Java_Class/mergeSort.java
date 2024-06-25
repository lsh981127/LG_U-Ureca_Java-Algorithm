package Uplus_Java_Class;

import java.util.Arrays;

public class mergeSort {
    static int[] a = {1,23,1,26,1,41,12,16};
    static int[] s;

    static void merge(int L, int M, int R) {
        int l = L, m = M+1, r = L;
        while(l <= M && r <= R) {
            if(a[l] <= a[m]) s[r++] = a[l++];
            else s[r++] = a[m++];

        }
        if(l > M)   for(int i = l; i <= R; i++) s[r++] = a[i];
        else        for(int i = r; i <= M; i++) s[r++] = a[i];

        for(int i = l; i <= R; i++) a[i] = s[i];

    }

    static void mergeSort(int L, int R) {
        if(L < R) {
            int M = (L + R) / 2;
            mergeSort(L, M);
            mergeSort(M+1, R);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(a));
        s = new int[a.length];
        mergeSort(0, a.length-1);

    }
}
