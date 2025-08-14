class MedianFinder {

    private PriorityQueue<Integer> minHeap;    
    private PriorityQueue<Integer> maxHeap;
    private int size;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((x,y) -> y - x);
        size = 0;
    }
    
    public void addNum(int num) {
        if (size == 0) {
            maxHeap.add(num);
        } else if (size % 2 == 1) {
            if (num <= maxHeap.peek()) {
                maxHeap.add(num);
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                }
            } else {
                minHeap.add(num);
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
            }
        } else if (size % 2 == 0) {
            if (num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }

        size++;
    }
    
    public double findMedian() {
        if (size % 2 == 0) {
            double mid1 = maxHeap.isEmpty() ? 0 : (double) maxHeap.peek();
            double mid2 = minHeap.isEmpty() ? 0 : (double) minHeap.peek();
            return mid1 + (mid2 - mid1) / 2;
        } else {
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */