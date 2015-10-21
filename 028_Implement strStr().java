public class Solution {
    private void kmpTable(String needle, int m, int[] T){
        T[0]=-1;
        if(m>1) T[1]=0;
        int pos=2, cnd=0;
        while(pos<m){
            if(needle.charAt(pos-1)==needle.charAt(cnd)){
                T[pos++]=++cnd;
            }
            else if(cnd>0){
                cnd=T[cnd];
            }
            else{
                T[pos++]=0;
            }
        }
    }
    
    private int kmpFind(String haystack, String needle, int[] T){
        int n=haystack.length(),m=needle.length();
        int cur=0, i=0;
        while(cur+i<n){
            if(needle.charAt(i)==haystack.charAt(cur+i)) {
                i++;
                if(i==m) return cur;
            }
            else{
                if(T[i]!=-1){
                    cur=cur+i-T[i];
                    i=T[i];
                }
                else{
                    i=0;
                    cur++;
                }
            }
        }
        return -1;
    }
    
    public int strStr(String haystack, String needle) {
        int n=haystack.length(),m=needle.length();
        if(m==0) return 0;
        if(m>n) return -1;
        int[] T=new int[m];
        kmpTable(needle, m, T);
        return kmpFind(haystack, needle, T);
    }
}
