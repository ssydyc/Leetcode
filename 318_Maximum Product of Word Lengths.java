public class Solution {
    private String process(String word) {
        boolean[] count = new boolean[26];
        String res = "";
        int n = word.length();
        for(int i = 0; i < n; i++) {
            count[word.charAt(i) - 'a'] = true ;
        }
        for(int i = 0; i < 26; i++) {
            if(count[i]) res += String.valueOf((char)((int)'a' + i));
        }
        return res;
    }
    
    private boolean compare(String str1, String str2){
        int i = 0, j = 0;
        int len1 = str1.length(), len2 = str2.length();
        while(i < len1 && j < len2) {
            if(str1.charAt(i) == str2.charAt(j)) return false;
            else if(str1.charAt(i) > str2.charAt(j)) j++;
            else i++;
        }
        return true;
    }
    
    public int maxProduct(String[] words) {
        int n = words.length;
        String[] pwords = new String[n];
        for(int i = 0; i < n; i++) {
            pwords[i] = process(words[i]);
        }
        int res = 0;
        for(int i = 0; i < n; i++)
            for(int j = i + 1; j < n; j++) {
                if(compare(pwords[i], pwords[j]) && (int temp = words[i].length() * words[j].length() >= res))
                    res = temp;
            }
        return res;
    }
}
