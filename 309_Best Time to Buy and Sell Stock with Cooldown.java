public class Solution {
    private int maxNum(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > res) res = nums[i];
        }
        return res;
    }
    
    public int maxProfit(int[] prices) {
        // we need five variables, sell, buy, keep, empty, cooldown
        int[] cur = new int[5];
        int[] next = new int[5];
        int n = prices.length;
        int[] temp;
        for(int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            next[0] = Math.max(cur[1], cur[2]) + diff;
            next[1] = Math.max(cur[3], cur[4]);
            next[2] = Math.max(cur[1], cur[2]) + diff;
            next[3] = Math.max(cur[3], cur[4]);
            next[4] = cur[0];
            temp = cur;
            cur = next;
            next = temp;
        }
        return maxNum(cur);
    }
}
