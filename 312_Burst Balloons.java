public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] num = new int[n + 2];
        for (int i = 0; i < n + 2; i++) 
            num[i] = (i == 0 || i == n + 1) ? 1 : nums[i - 1];
        int[][] dp = new int[n][n];
        for(int k = 0; k < n; k++)
            for(int i = 0; i + k < n; i++) {
                int j = i + k;
                for(int m = i; m <= j; m++){
                    int temp1 = m - 1 >= i ? dp[i][m - 1] : 0;
                    int temp2 = m + 1 <= j ? dp[m + 1][j] : 0;
                    dp[i][j] = Math.max(dp[i][j], temp1 + temp2 + num[m + 1] * num[i] * num[j + 2]);
                }
            }
        return dp[0][n - 1];
    }
}
