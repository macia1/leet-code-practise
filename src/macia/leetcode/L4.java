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
        double medianSortedArrays = l4.findMedianSortedArrays(new int[]{1, 3}, new int[]{4,2});
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sum = new int[nums1.length + nums2.length];
        int l1 = nums1.length;
        int l2 = nums2.length;
        int pointer = -1;
        for (int i = 0; i < sum.length; i++) {
            int l1v = 0, l2v = 0;
            if (l1 > i) {
                l1v = nums1[i];
            }
            if (l2 > i) {
                l2v = nums2[i];
            }
            if (l1v == l2v) {
                break;
            }
            int minV = Math.min(l1v, l2v);
            int maxV = Math.max(l1v, l2v);
            if (minV != 0) {
                ++pointer;
                sum[pointer] = minV;
            }
            if (maxV != 0) {
                ++pointer;
                sum[pointer] = maxV;
            }
        }
        int sumLen = sum.length;
        int middle = sum.length / 2;
        System.out.println(Arrays.toString(sum));
        if((sumLen) % 2 == 0 ){
            return (sum[middle - 1] + sum[middle]) / 2.0;
        }else {
            return sum[middle];
        }

    }

}
