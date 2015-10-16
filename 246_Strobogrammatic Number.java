public class Solution {
    
    private boolean isRotate(char c1, char c2){
        if(c1=='6' && c2=='9') return true;
        if(c1=='9' && c2=='6') return true;
        if(c1=='8' && c2=='8') return true;
        if(c1=='1' && c2=='1') return true;
        if(c1=='0' && c2=='0') return true;

        return false;
    }

    public boolean isStrobogrammatic(String num) {
        for(int i=0;i<(num.length()+1)/2;i++){
            if(!isRotate(num.charAt(i),num.charAt(num.length()-1-i))) return false;
        }
        return true;
    }
}
