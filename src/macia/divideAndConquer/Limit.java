package macia.divideAndConquer;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zenggs
 * @Date 2022/9/9
 */
public class Limit {

    public static void main(String[] args) {
        double[] doubleArr = new double[20000000];
        for (int i = 0; i < doubleArr.length; i++) {
            doubleArr[i] = ThreadLocalRandom.current().nextDouble(-999999999999L,999999999999L);
        }
        System.out.println(Arrays.toString(doubleArr));
        System.out.println("数组长度:" + doubleArr.length);
        double[] limit = new Limit().getLimit(doubleArr);
        System.out.println(Arrays.toString(limit));
    }

    ///////////////////////////////////////////////////////////////////////////
    // 二分求极值 最大值和最小值
    ///////////////////////////////////////////////////////////////////////////
    public double[] getLimit(double[] data){
        if (data.length == 1){
            return data;
        }
        if (data.length == 2){
            data[0] = Math.min(data[0],data[1]);
            data[1] = Math.max(data[0],data[1]);
            return data;
        }

        int mid = data.length / 2;
        double[] leftBuff = new double[mid];
        double[] rightBuff = new double[data.length - mid];
        System.arraycopy(data, 0, leftBuff, 0, mid);
        System.arraycopy(data, mid, rightBuff, 0, data.length - mid);
        double[] leftArr = getLimit(leftBuff);
        double[] rightArr = getLimit(rightBuff);

        double[] result = new double[2];
        // 最小值
        result[0] = Math.min(leftArr[0], rightArr[0]);
        // 最大值
        if (leftArr.length == 2 && rightArr.length == 2){
            result[1] = Math.max(leftArr[1], rightArr[1]);
        }
        if (leftArr.length == 1 && rightArr.length == 1){
            result[1] = Math.max(leftArr[0], rightArr[0]);
        }
        if (leftArr.length == 1 && rightArr.length == 2){
            result[1] = Math.max(leftArr[0],rightArr[1]);
        }
        if (leftArr.length == 2 && rightArr.length == 1){
            result[1] = Math.max(leftArr[1], rightArr[0]);
        }
        return result;
    }

}
