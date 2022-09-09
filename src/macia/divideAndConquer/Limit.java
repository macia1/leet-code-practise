package macia.divideAndConquer;

import java.util.Arrays;

/**
 * @author zenggs
 * @Date 2022/9/9
 */
public class Limit {

    public static void main(String[] args) {
        double[] data = {-1233123.123, -999999999999L, 12312312312312L, 123121, -123123, 123123.1, 9999999999L};
        double[] limit = new Limit().getLimit(data);
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
        if (leftArr.length == 2 && rightArr.length == 2){
            double leftMinVal = leftArr[0];
            double rightMinVal = rightArr[0];
            double leftMaxVal = leftArr[1];
            double rightMaxVal = rightArr[1];
            result[0] = Math.min(leftMinVal, rightMinVal);
            result[1] = Math.max(leftMaxVal, rightMaxVal);

        }
        if (leftArr.length == 1 && rightArr.length == 1){
            return data;
        }
        if (leftArr.length == 1 && rightArr.length == 2){
            double leftMinVal = leftArr[0];
            double rightMinVal = rightArr[0];
            double rightMaxVal = rightArr[1];
            result[0] = Math.min(leftMinVal, rightMinVal);
            result[1] = rightMaxVal;
        }
        if (leftArr.length == 2 && rightArr.length == 1){
            double leftMinVal = leftArr[0];
            double rightMinVal = rightArr[0];
            double leftMaxVal = rightArr[1];
            result[0] = Math.min(leftMinVal, rightMinVal);
            result[1] = leftMaxVal;
        }
        return result;
    }

}
