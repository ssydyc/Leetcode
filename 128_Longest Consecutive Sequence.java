
// Solution 1, O(n) Space and O(n) Time

public class Solution {
    
    private int increaseNum(int num, HashSet<Integer> rec) {
        int res = 1, move = num;
        if(!rec.contains(num)) return 0;
        rec.remove(move--);
        while(rec.contains(move)) {
            rec.remove(move--);
            res++;
        }
        move = num + 1;
        while(rec.contains(move)) {
            rec.remove(move++);
            res++;
        }
        return res;
    }
    
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> rec = new HashSet<Integer>(nums.length);
        int res = 0;
        for(int num : nums)
            rec.add(num);
        for(int num : nums) {
            int cur = increaseNum(num, rec);
            if(cur > res) res = cur;
        }
        return res;
    }
}

// Solution 2, O(1) Space but O(nlogn) Time

public class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int res = 0, cur = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1] + 1) cur++;
            else if (nums[i] == nums[i - 1]) continue;
            else {
                if(cur > res) res = cur;
                cur = 1;
            }
        }
        if(cur > res) res = cur;
        return res;
    }
}
