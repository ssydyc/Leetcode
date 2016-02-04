public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        Arrays.fill(res, -1);
        res[0] = 0;
        for(int i = 1; i <= amount; i++) 
            for(int temp : coins) {
                if(temp == i) res[i] = 1;
                else if(temp < i && res[i - temp] != -1) {
                    if(res[i] == -1) res[i] = res[i - temp] + 1;
                    else res[i] = Math.min(res[i], res[i - temp] + 1);
                }
            }
        return res[amount];
    }
}
