/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int VIP=0;
        for(int i=1; i<n; i++){
            if(knows(VIP,i)) VIP=i;
        }
        for(int i=0;i<n;i++){
            if(i==VIP) continue;
            if(knows(VIP,i)|| !knows(i,VIP)) return -1;
        }
        return VIP;
    }
}
