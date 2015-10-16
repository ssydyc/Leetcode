public class Solution {
    
    private int myCompare(String word, String word1, String word2){
        if(word.equals(word1)) return 1;
        if(word.equals(word2)) return 2;
        return 0;
    }
    
    
    public int shortestDistance(String[] words, String word1, String word2) {
        int temp=0;
        int result=Integer.MAX_VALUE;
        int next=0;
        for(String word: words){
            if(next==0){
                int compare=myCompare(word,word1,word2);
                if(compare==1) next=2;
                else if(compare==2) next=1;
            }
            else{
                int compare=myCompare(word, word1,word2);
                if(compare==0) temp++;
                else if(compare==next){
                    result=Math.min(result,temp);
                    if(compare==1) next=2;
                    else next=1;
                    temp=0;
                }
                else temp=0;
            }
        }
        return result+1;
    }
}
