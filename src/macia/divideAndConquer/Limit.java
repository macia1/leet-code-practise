package macia.divideAndConquer;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zenggs
 * @Date 2022/9/9
 */
public class Limit {

    public static void main(String[] args) {
        double[] doubleArr = new double[100000];
        for (int i = 0; i < doubleArr.length; i++) {
            doubleArr[i] = ThreadLocalRandom.current().nextDouble(-99999,99999L);
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
            double left = data[0];
            double right = data[1];
            if (left > right){
                data[0] = right;
                data[1] = left;
            }
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

        double leftMinVal = leftArr[0];
        double rightMinVal = rightArr[0];
        result[0] = Math.min(leftMinVal, rightMinVal);
        double leftMinMax = Math.max(leftMinVal, rightMinVal);
        if (leftArr.length == 2 && rightArr.length == 2){
            double leftMaxVal = leftArr[1];
            double rightMaxVal = rightArr[1];
            result[1] = Math.max(leftMaxVal, rightMaxVal);
        }
        if (leftArr.length == 1 && rightArr.length == 1){
            result[1] = Math.max(leftMinVal, rightMinVal);
        }
        if (leftArr.length == 1 && rightArr.length == 2){
            double rightMaxVal = rightArr[1];
            result[1] = Math.max(leftMinMax,rightMaxVal);
        }
        if (leftArr.length == 2 && rightArr.length == 1){
            result[1] = leftArr[1];
        }
        return result;
    }

}