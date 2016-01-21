public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        for(int i = 1; i < n; i++) nums[i] += nums[i - 1];
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] == k) res = i + 1 > res ? i + 1 : res;
            if(hm.containsKey(k + nums[i])){
                int temp = hm.get(k + nums[i]) - i;
                res = temp > res ? temp : res;
            }
            if(!hm.containsKey(nums[i])) hm.put(nums[i], i);
        }
        return res;
    }
}
