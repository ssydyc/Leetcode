public class Solution {
    
    private boolean compareThree(List<Integer> array1, ArrayList<Integer> array2){
        if(array1.get(0)!=array2.get(0)) return false;
        if(array1.get(1)!=array2.get(1)) return false;
        if(array1.get(2)!=array2.get(2)) return false;
        return true;
    }
    
    private boolean findArray(ArrayList<Integer> temp, ArrayList<List<Integer>> result ){
        for(List<Integer> temp1: result){
            if(compareThree(temp1,temp)) return true;
        }
        return false;
    }
    
    private ArrayList<List<Integer>> findZero(int[] num){
        ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
        for(int i=0;i<num.length-2;i++){
            int start=i+1;
            int end=num.length-1;
            while(start<end){
                if(num[i]+num[start]+num[end]==0){
                    ArrayList<Integer> temp=new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[start]);
                    temp.add(num[end]);
                    if(!findArray(temp,result)) result.add(temp);
                    start++;
                    end--;
                }
                else if(num[i]+num[start]+num[end]>0) end--;
                else start++;
            }
        }
        return result;
    }
    
    
    public List<List<Integer>> threeSum(int[] num) {
        if(num.length<3) return new ArrayList<List<Integer>>();
        Arrays.sort(num);
        ArrayList<List<Integer>> result=findZero(num);
        return result;
    }
}
