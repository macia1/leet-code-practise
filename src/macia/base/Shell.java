package macia.base;

import java.util.Arrays;

/**
 * @author zenggs
 * @Date 2022/12/26
 * 希尔排序
 */
public class Shell extends AbstractSort {
    @Override
    protected void sort(Comparable[] a) {
        int ARR_LENGTH = a.length;
        int h = 1;
        while (h < ARR_LENGTH / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < ARR_LENGTH; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }

    }

    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{1, 2, 3,123,23,1,23, 123, 234, 2134, 132, 4, 12, 34, 12, 34};
        Shell shell = new Shell();
        shell.sort(a);
        System.out.println(a);
    }
}
