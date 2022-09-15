package macia.divideAndConquer;

import java.util.Arrays;

/**
 * @author zenggs
 * @Date 2022/9/15
 * 数组逆转
 */
public class ReverseList {

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        String[] testArr = {"1", "2", "3", "4"};
        // 逆转数据
        Object[] reverseResult = reverseList.revList(testArr);
        // 对逆转结果进行逆转打印
        reverseList.revListPrint(reverseResult);
        // 逆转结果
        System.out.println(Arrays.toString(reverseResult));
    }


    private void revListPrint(Object[] arr){
        if (arr == null || arr.length == 0) return;
        Object o = arr[arr.length - 1];
        System.out.println(o);
        Object[] dest = new Object[arr.length - 1];
        System.arraycopy(arr, 0, dest, 0,arr.length-1);
        revListPrint(dest);
    }

    private Object[] revList(Object[] arr){
        if (arr == null || arr.length == 0) return null;
        for (int i = 0; i < arr.length / 2; i++) {
            Object temp = arr[i];
            // 第一位赋值最后一位
            arr[i] = arr[arr.length - 1 - i];
            // 最后一位赋值给第一位
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

}
