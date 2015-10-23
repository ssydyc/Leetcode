public class Solution {
    
    private void helper(Set<List<Integer>> res, int[] candidates, int target, List<Integer> temp, int start){
        if(target==0) {
            res.add(new LinkedList(temp));
            return;
        }
        if(start<candidates.length&&candidates[start]<=target){
            helper(res,candidates, target, temp,start+1);
            temp.add(candidates[start]);
            helper(res,candidates, target-candidates[start], temp,start+1);
            temp.remove(temp.size()-1);
        }
        return;
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res=new HashSet<List<Integer>>();
        List<Integer> temp=new LinkedList<Integer>();
        helper(res, candidates, target, temp, 0);
        List<List<Integer>> res1=new ArrayList<List<Integer>>();
        for(List<Integer> temp1: res){
            res1.add(temp1);
        }
        return res1;
    }
}
