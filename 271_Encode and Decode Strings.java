public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder result=new StringBuilder();
        for(String temp: strs){
            result.append(Integer.toString(temp.length()));
            result.append('$');
            result.append(temp);
        }
        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        ArrayList<String> result=new ArrayList<String>();
        StringBuilder tempS=new StringBuilder();
        int sLength=0;
        int current=0;
        while(current<s.length()){
            while(s.charAt(current)!='$') sLength=sLength*10+(int)s.charAt(current++) -(int)'0';
            current++;
            while(sLength-->0){
                tempS.append(s.charAt(current++));
            }
            result.add(tempS.toString());
            sLength=0;
            tempS=new StringBuilder();
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
