package medium;

import java.util.*;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Question3 {
    public int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int end = 0;
        int result = 0;

        HashSet<Character> set = new HashSet<Character>();
        ArrayList<Character> list = new ArrayList<Character>();

        while (end < s.length()) {
            char endChar = s.charAt(end);
            list.add(endChar);
            set.add(endChar);

            if (list.size() == set.size()) {
                end++;
                result = result >= end - begin ? result : end - begin;
            } else {
                char beginChar = 0;
                while (beginChar != endChar) {
                    begin++;
                    beginChar = list.remove(0);
                    if (beginChar != endChar) {
                        set.remove(beginChar);
                    }
                }
                end++;
            }
        }
        return result;
    }

    /**
     * 两个有趣的解法
     * 这个解法和我的解法思路是一样的，但是非常简洁，而且我的解法中的list其实也是没有必要的
     * 只需要原先的s，就能实现list的所有功能
     */
    public int betterSolution1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}
