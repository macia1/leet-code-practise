package macia.leetcode;

import java.util.Arrays;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/16
 * 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class L4 {

    public static void main(String[] args) {
        L4 l4 = new L4();
        double medianSortedArrays = l4.findMiddleNum(new int[]{3}, new int[]{-2,-1});
        System.out.println(medianSortedArrays);
    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] sum = new int[nums1.length + nums2.length];
//        int l1 = nums1.length;
//        int l2 = nums2.length;
//        int pointer = -1;
//        for (int i = 0; i < sum.length; i++) {
//            int l1v = 0, l2v = 0;
//            if (l1 > i) {
//                l1v = nums1[i];
//            }
//            if (l2 > i) {
//                l2v = nums2[i];
//            }
//            if (l1v == l2v) {
//                break;
//            }
//            int minV = Math.min(l1v, l2v);
//            int maxV = Math.max(l1v, l2v);
//            if (minV != 0) {
//                ++pointer;
//                sum[pointer] = minV;
//            }
//            if (maxV != 0) {
//                ++pointer;
//                sum[pointer] = maxV;
//            }
//        }
//        int sumLen = sum.length;
//        int middle = sum.length / 2;
//        System.out.println(Arrays.toString(sum));
//        if((sumLen) % 2 == 0 ){
//            return (sum[middle - 1] + sum[middle]) / 2.0;
//        }else {
//            return sum[middle];
//        }
//
//    }

    public double findMiddleNum(int[] nums1, int[] nums2){
        // 1. 数组合并
        int[] counts = numMerge(nums1, nums2);
        // 2. 数据排序
        int[] orderlyNums = sort(counts);
        // 3. 取中位数
        return getMiddleNum(orderlyNums);
    }

    private int[] numMerge(int[] nums1, int[] nums2) {
        int i = nums1.length + nums2.length;
        int[] counts = new int[i];
        System.arraycopy(nums1,0,counts , 0, nums1.length);
        System.arraycopy(nums2,0, counts, nums1.length, nums2.length);
        return counts;
    }

    private double getMiddleNum(int[] orderlyNums) {

        if (orderlyNums.length % 2 == 0){
            return (orderlyNums[orderlyNums.length / 2 - 1] + orderlyNums[orderlyNums.length / 2]) / 2.0;
        }else {
            return orderlyNums[orderlyNums.length / 2];
        }
    }

    private int[] sort(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            int iV = counts[i];
            for (int j = i+1; j < counts.length; j++) {
                int jV = counts[j];
                if (iV > jV){
                    counts[i] = jV;
                    counts[j] = iV;
                    iV = jV;
                }
            }
        }
        return counts;
    }

}
