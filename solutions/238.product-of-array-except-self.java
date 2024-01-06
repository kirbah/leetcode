/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for(int i=1; i < len; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        int suffix = 1;
        for(int i=len-1; i >= 0; i--) {
            res[i] = res[i] * suffix;
            suffix = suffix * nums[i];
        }

        return res;
    }

    public int[] productExceptSelfV1(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        prefix[0] = 1;
        suffix[len-1] = 1;
        for(int i=1; i < len; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
            int j = len-i-1;
            suffix[j] = suffix[j+1] * nums[j+1];
        }

        int[] res = new int[len];
        for(int i=0; i<len; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}
// @lc code=end

