public class Solution {
    
    private void addResult(ArrayList<String> result, int start, int end){
        if(end-start<=1) return;
        if(end-start==2) result.add(Integer.toString(start+1));
        else result.add(Integer.toString(start+1).concat("->").concat(Integer.toString(end-1)));
        return;
    }
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int start=lower-1;
        ArrayList<String> result=new ArrayList<String>();
        for(int temp: nums){
            if(temp>start) {
                if(temp-1==upper) break;
                if(temp>upper) temp=upper+1;
                addResult(result, start,temp);
                start=temp;
            }
        }
        // the case that all numbers are on the left
        addResult(result,start,upper+1);
        return result;
    }
}
