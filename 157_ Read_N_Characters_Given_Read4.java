/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int current=0;
        char[] buff4=new char[4];
        while(current<n){
            int temp=read4(buff4);
            for(int i=0;i<temp && current<n;i++) buf[current++]=buff4[i];
            if(temp<4) break; // don't have enough characters in the file
        }
        return current;
    }
}
