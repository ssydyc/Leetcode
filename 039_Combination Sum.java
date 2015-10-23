public class Solution {
    
    private void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> temp, int min){
        if(target==0) {
            res.add(new LinkedList(temp));
            return;
        }
        for(int num: candidates){
            if(num>=min&&num<=target){
                temp.add(num);
                helper(res,candidates, target-num, temp,num);
                temp.remove(temp.size()-1);
            }
        }
        return;
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        List<Integer> temp=new LinkedList<Integer>();
        helper(res, candidates, target, temp, 0);
        return res;
    }
}
