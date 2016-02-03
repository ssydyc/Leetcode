public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        int len = primes.length;
        int[] ind = new int[len];
        int[] val = new int[len];
        res[0] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < len; j++)
                val[j] = primes[j] * res[ind[j]];
            int choose = 0, num = val[0];
            // choose a number
            for(int j = 1; j < len; j++) {
                if(val[j] < num) {
                    choose = j;
                    num = val[j];
                }
            }
            res[i] = num;
            for(int j = 0; j < len; j++)
                if(primes[j] * res[ind[j]] == num) ind[j]++;
        }
        return res[n - 1];
    }
}
