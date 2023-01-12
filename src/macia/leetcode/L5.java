package macia.leetcode;

/**
 * @author zenggs
 * @Date 2023/1/11
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * 最长回文字符串
 */
public class L5 {
    public static void main(String[] args) {
        L5 l5 = new L5();
        String reqStr = l5.longestPalindrome("babad");
        System.out.println(reqStr);
    }

    public String longestPalindrome(String s) {
        if ("".equals(s) || s == null) {
            return "";
        }
        int left = 0,right = 0,len = 1,maxLen = 0,maxStart = 0;
        int strLen = s.length();
        for (int k = 0; k < strLen; k ++){
            left = k - 1;
            right = k + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(k)){
                left--;
                len++;
            }
            while(right < strLen && s.charAt(right) == s.charAt(k)){
                right++;
                len++;
            }
            while (left >=0 && right < strLen && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                len = len + 2;
            }
            if (len > maxLen){
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart+1,maxStart+maxLen+1);
    }

}
