public class WordDistance {

    private HashMap<String,ArrayList<Integer>> result;

    public WordDistance(String[] words) {
        result=new HashMap<String,ArrayList<Integer>>();
        for(int i=0;i<words.length;i++){
            String word=words[i];
            if(result.containsKey(word)) result.get(word).add(i);
            else{
                result.put(word,new ArrayList<Integer>());
                result.get(word).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        int distance=Integer.MAX_VALUE;
        ArrayList<Integer> word1List=result.get(word1); // won't be empty
        ArrayList<Integer> word2List=result.get(word2);
        int index1=0, index2=0;
        while(index1<word1List.size()&& index2<word2List.size()){
            int temp=word1List.get(index1)-word2List.get(index2);
            distance=Math.min(Math.abs(temp),distance);
            if(temp<0) index1++;
            else index2++;
        }
        return distance;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
