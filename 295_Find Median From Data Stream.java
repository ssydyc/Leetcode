class MedianFinder {
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder(){
        minHeap=new PriorityQueue<Integer>();
        maxHeap=new PriorityQueue<Integer>(1, new Comparator<Integer>(){
            public int compare(Integer n1, Integer n2) {
                return n2-n1;
            }
        } );
    }
    
    private void balanceHeap(){
        int maxSize=maxHeap.size(), minSize=minHeap.size();
        while(minHeap.size()<maxHeap.size()) minHeap.offer(maxHeap.poll());
        while(minHeap.size()-maxHeap.size()>1) maxHeap.offer(minHeap.poll());
        return;
    }
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(minHeap.size()==0||num>minHeap.peek()) minHeap.offer(num);
        else maxHeap.offer(num);
    }
    
    // Returns the median of current data stream
    public double findMedian() {
        balanceHeap();
        if(maxHeap.size()==minHeap.size()) return (maxHeap.peek()+minHeap.peek())/2.0;
        else return (double)minHeap.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
