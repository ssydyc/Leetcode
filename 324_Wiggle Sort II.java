public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] res = new int[n];
        int end = n - 1;
        int mid = end / 2;
        for(int i = 0; i < n; i++)
            res[i] = i % 2 == 0 ? nums[mid--] : nums[end--];
        for(int i = 0; i < n; i++)
            nums[i] = res[i];
    }
}
