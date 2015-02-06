import java.util.Arrays;

public class Solution {
    private int[] adjusted(int[] result){
        if(result[0]>result[1]){
            int temp=result[0];
            result[0]=result[1];
            result[1]=temp;
        }
        return result;
    }
    
    private int[] findindex(int[] numbers, int num1, int num2){
        // find the index
        int[] result=new int[] {-1,-1};
        for(int i=0;i<numbers.length;i++){
            if(result[0]==-1 && numbers[i]==num1) result[0]=i+1;
            else if(numbers[i]==num2) result[1]=i+1;
            else continue;
        }
        return adjusted(result);
    }
    
    
    public int[] twoSum(int[] numbers, int target) {
        int[] temp_numbers=numbers.clone();
        Arrays.sort(numbers);
        int[] result=new int[] {0,numbers.length-1};
        while(result[0]<result[1]){
            if(numbers[result[0]]+numbers[result[1]]==target) break;
            else if(numbers[result[0]]+numbers[result[1]]>target) result[1]--;
            else result[0]++;
        }
        return findindex(temp_numbers, numbers[result[0]],numbers[result[1]]);
    }
}
