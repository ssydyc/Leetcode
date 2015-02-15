public class Solution {
    private int convertRoman(Character s){
        if(s=='M') return 1000;
        if(s=='D') return 500;
        if(s=='C') return 100;
        if(s=='L') return 50;
        if(s=='X') return 10;
        if(s=='V') return 5;
        if(s=='I') return 1;
        return 0;
    }
    
    public int romanToInt(String s) {
        boolean increase=true;
        int result=0;
        for(int i=s.length()-1;i>=0;i--){
            if(i==s.length()-1){
                result+=convertRoman(s.charAt(i));
                continue;
            }
            
            if(convertRoman(s.charAt(i))>convertRoman(s.charAt(i+1))) increase=true;
            if(convertRoman(s.charAt(i))<convertRoman(s.charAt(i+1))) increase=false;
            if(increase) result+=convertRoman(s.charAt(i));
            else result-=convertRoman(s.charAt(i));
        }
        return result;
    }
}
