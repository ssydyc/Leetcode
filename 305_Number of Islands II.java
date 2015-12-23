
public class Solution {
    
    private int getHead(int[] unionSet, int m) {
        while (unionSet[m] != -1 && unionSet[m] != -2) {
            m = unionSet[m];
        }
        if (unionSet[m] == -1) return -1;
        else return m;
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>(positions.length);
        int nums = 0; // result for each step, num of islands
        int[] unionSet = new int[m*n];
        Arrays.fill(unionSet, -1);
        for (int i = 0; i < positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            int pos = (row) * n + col;
            if (unionSet[pos] == -1) {
                int count = 0; // num of neigbourhoods
                unionSet[pos] = -2; // set pos as the one head
                // left
                if (col > 0) {
                    int temp = getHead(unionSet, pos - 1);
                    if (temp != -1 && temp != pos) {
                        count++ ;
                        unionSet[temp] = pos;
                    }
                }
                // right
                if (col < n-1) {
                    int temp = getHead(unionSet, pos + 1);
                    if (temp != -1 && temp != pos) {
                        count++ ;
                        unionSet[temp] = pos;
                    }
                }
                // top
                if (row > 0) {
                    int temp = getHead(unionSet, pos - n);
                    if (temp != -1 && temp != pos) {
                        count++ ;
                        unionSet[temp] = pos;
                    }
                }
                // bottom
                if (row < m-1) {
                    int temp = getHead(unionSet, pos + n);
                    if (temp != -1 && temp != pos) {
                        count++ ;
                        unionSet[temp] = pos;
                    }
                }
                // update nums
                if (count == 0) nums++;
                else nums -= count-1;
            }
            res.add(nums);
        }
        return res;
    }
    
}
