package macia.leetcode;

/**
 * @author zengguosheng
 * @Date 2022/8/12 17:58
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
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
