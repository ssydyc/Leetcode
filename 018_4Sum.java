public class Solution {
    // the algorithm with n^2 time complexity
    
    HashMap<Integer,Integer> countNum=new HashMap<Integer,Integer>(); // count the Num to avoid repeteation
    HashMap<Integer,ArrayList<ArrayList<Integer>>> Sum2=new  HashMap<Integer,ArrayList<ArrayList<Integer>>>(); // sum2 result
    
    private void initialize_countNum(int[] num){
        countNum.clear();
        for(int tempNum : num){
            if(countNum.get(tempNum)==null) countNum.put(tempNum,1);
            else countNum.put(tempNum,countNum.get(tempNum)+1);
        }
        return ;
    }
    
    private void initialize_Sum2(int[] num){
        Sum2.clear();
        for(int i=0; i<num.length;i++)
            for(int j=i+1;j<num.length;j++){
                ArrayList<Integer> tempArrayList=new ArrayList<Integer>();
                tempArrayList.add(num[i]);
                tempArrayList.add(num[j]);
                int tempSum=num[i]+num[j];
                if(Sum2.get(tempSum)==null){
                    ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();
                    temp.add(tempArrayList);
                    Sum2.put(tempSum,temp);
                }
                else
                    Sum2.get(tempSum).add(tempArrayList);
            }
        return;
    }
    
    private boolean qualify(ArrayList<Integer> Candidate){
        for(int i=0;i<Candidate.size();i++){
            int testNow=Candidate.get(i);
            int count=1;
            for(int j=i+1;j<Candidate.size();j++){
                if(Candidate.get(j)==testNow) count++;
            }
            if(count>countNum.get(testNow))return false;
        }
        return true;
    }
    
    private List<List<Integer>> convertToList(HashSet<ArrayList<Integer>> result){
        //convert to the List of List
        List<List<Integer>> resultList=new ArrayList<List<Integer>>();
        for(ArrayList<Integer> temp: result){
            resultList.add(temp);
        }
        return resultList;
    }
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        initialize_countNum(num);
        initialize_Sum2(num);
        HashSet<ArrayList<Integer>> result=new HashSet<ArrayList<Integer>>(); // result of the problem, a hashset
        for(int i=0; i<num.length;i++)
            for(int j=i+1;j<num.length;j++){
                ArrayList<Integer> resultCandidate=new ArrayList<Integer>();
                resultCandidate.add(num[i]);
                resultCandidate.add(num[j]);
                int remaining=target-num[i]-num[j];
                if(Sum2.get(remaining)==null) continue;
                for(List<Integer> tempArrayList: Sum2.get(remaining)){
                    ArrayList<Integer> temp=new ArrayList<Integer>(resultCandidate);
                    temp.add(tempArrayList.get(0));
                    temp.add(tempArrayList.get(1));
                    Collections.sort(temp);
                    if(qualify(temp)) result.add(temp);
                }
            }
        return convertToList(result);
    }
}
