public class NumArray {
    int[] BIT;
    
    public NumArray(int[] nums) {
        BIT = new int[nums.length+1];
        Arrays.fill(BIT, 0);
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int temp = sumRange(i, i);
        i++;
        val -= temp;
        while (i > 0 && i < BIT.length) {
            BIT[i] += val;
            i += (i & -i);
        }
    }
    
    private int getSum(int i) {
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= (i & -i);
        }
        return res;
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) return getSum(j+1);
        return getSum(j+1) - getSum(i);
    }
}
