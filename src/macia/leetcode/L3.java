package macia.leetcode;

/**
 * @author zengguosheng
 * @Date 2022/8/12 17:58
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 */
public class L3 {

    public int lengthOfLongestSubstring(String str) {
        int max = 0;
        int i1, len;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            i1 = tmp.indexOf(String.valueOf(s));
            if (i1 != -1) {
                len = tmp.length();
                max = Math.max(len, max);
                if (i1 == 0) {
                    tmp.deleteCharAt(0);
                } else {
                    tmp.delete(0, i1 + 1);
                }
            }
            tmp.append(s);
            max = Math.max(max, tmp.length());
        }
        return max;
    }

    public static void main(String[] args) {
        L3 l3 = new L3();
        String str = "pwwkew";
        int length = l3.lengthOfLongestSubstring(str);
        System.out.println(length);
    }

}
