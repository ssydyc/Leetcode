/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] buffer=new char[4];
    int nextRead=0;
    int end=-1; // record the end of buf
     
    public int read(char[] buf, int n) {
        int Readnum=0;
        int current=0;
        while(Readnum<n){
            if(nextRead>=end){
                if(end>=0&&end<4) break; // end of file
                end=read4(buffer);
                nextRead=0;
            }
            else{
                buf[current++]=buffer[nextRead++];
                Readnum++;
            }
        }
        return current;
    }
}
