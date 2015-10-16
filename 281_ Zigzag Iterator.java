public class ZigzagIterator {
    
    Iterator<Integer> iter1;
    Iterator<Integer> iter2;
    boolean nextIsOne;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iter1=v1.iterator();
        iter2=v2.iterator();
        nextIsOne=true;
    }

    public int next() {
        if(nextIsOne){
            nextIsOne=!nextIsOne;
            if(iter1.hasNext()) return iter1.next();
            else return iter2.next();
        }
        else{
            nextIsOne=!nextIsOne;
            if(iter2.hasNext()) return iter2.next();
            else return iter1.next();
        }
    }

    public boolean hasNext() {
        return iter1.hasNext()||iter2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
