public class Solution {
    private void update(int[] res, int x, int y) {
        if (res[0] > x) res[0] = x;
        else if (res[1] < x) res[1] = x;
        if (res[2] > y) res[2] = y;
        else if (res[3] < y) res[3] = y;
        return ;
    }
    
    private void helper(char[][] image, int[] res, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        image[x][y] = '0';
        update(res, x, y);
        if (x-1 >= 0 && image[x-1][y] == '1' ) helper(image, res, x-1, y);
        if (x+1 < m && image[x+1][y] == '1') helper(image, res, x+1, y);
        if (y-1 >= 0 && image[x][y-1] == '1') helper(image, res, x, y-1);
        if (y+1 < n && image[x][y+1] == '1') helper(image, res, x, y+1);
        return ;
    }
    
    public int minArea(char[][] image, int x, int y) {
        int[] res = {x, x, y, y};
        helper(image, res, x, y);
        return (res[1] - res[0] + 1) * (res[3] - res[2] + 1);
    }
}
