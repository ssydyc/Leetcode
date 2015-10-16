public class ValidWordAbbr {
    
    HashMap<String,Integer> abbrev= new HashMap<String,Integer>();
    HashSet<String> dict= new HashSet<String>();
    
    private String getAbbr(String temp){
        return temp.charAt(0)+Integer.toString(temp.length()-2)+temp.charAt(temp.length()-1);
    }
    
    
    public ValidWordAbbr(String[] dictionary) {
        for(String temp: dictionary){
            if(temp.length()<3) continue;
            String tempAbbrev=getAbbr(temp);
            if(abbrev.containsKey(tempAbbrev)) abbrev.put(tempAbbrev, abbrev.get(tempAbbrev)+1);
            else abbrev.put(tempAbbrev, 1);
            dict.add(temp);
        }
    }

    public boolean isUnique(String word) {
        if(word.length()<3) return true;
        else{
            String temp=getAbbr(word);
            if(dict.contains(word)&& abbrev.get(temp)>1) return false;
            if(!dict.contains(word) && abbrev.containsKey(temp)) return false;
            return true;
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
