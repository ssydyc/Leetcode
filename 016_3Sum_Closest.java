public class Solution {
    public int threeSumClosest(int[] num, int target){
        Arrays.sort(num);
        int result=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<num.length-2;i++){
            int start=i+1;
            int end=num.length-1;
            while(start<end){
                if(num[i]+num[start]+num[end]==target) return target;
                else if(num[i]+num[start]+num[end]>target){
                    if(result>num[i]+num[start]+num[end]-target){
                        result=num[i]+num[start]+num[end]-target;
                        sum=num[i]+num[start]+num[end];
                    }
                    end--;
                }
                else{
                    if(result>target-(num[i]+num[start]+num[end])){
                        result=target-(num[i]+num[start]+num[end]);
                        sum=num[i]+num[start]+num[end];
                    }
                    start++;
                }
            }
        }
        return sum;
    }
}
