public class Solution {
    public String getHint(String secret, String guess) {
        int bull=0,cow=0;
        int n=secret.length();
        int[] count= new int[10];
        Arrays.fill(count,0);
        for(int i=0;i<n;i++){
            count[(int)secret.charAt(i)-(int)'0']++;
            if(secret.charAt(i)==guess.charAt(i)) bull++;
        }    
        for(int i=0;i<n;i++){
             int temp=guess.charAt(i)-(int)'0';
             if(count[temp]>0){
                 cow++;
                 count[temp]--;
             }
        }
        return bull+"A"+(cow-bull)+"B";
    }
}
