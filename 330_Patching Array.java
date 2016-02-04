public class Solution {
    public int minPatches(int[] nums, int n) {
        int ind = 0, res = 0;
        long total = 1;
        int len = nums.length;
        while(total <= n) {
            if(ind < len && nums[ind] <= total)
                total += nums[ind++];
            else {
                total <<= 1;
                res++;
            }
        }
        return res;
    }
}
