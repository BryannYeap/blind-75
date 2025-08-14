class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        
        LinkedList<int[]> newIntervals = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] <= intervals[i][0]) {
                newIntervals.add(newInterval);
            } 
            newIntervals.add(intervals[i]);
        }
        if (newIntervals.size() == intervals.length) newIntervals.add(newInterval);

        LinkedList<int[]> res = new LinkedList<>();
        int i = 0;
        boolean mergedNew = false;

        while (i < newIntervals.size()) {
            int[] ls = new int[2];
            int[] interval1 = newIntervals.get(i);
            ls[0] = interval1[0];
            ls[1] = interval1[1];

            boolean justMerged = false;

            int j = i + 1;
            while (j < newIntervals.size()) {
                int[] interval2 = newIntervals.get(j);
                if (interval2[0] <= ls[1]) {
                    if (interval2[1] > ls[1]) {
                        ls[1] = interval2[1];
                    } 
                    j++;
                } else {
                    break;
                }
            }

            i = j;
            res.add(ls);

        }

        return res.toArray(new int[res.size()][]);
    }
}

//================================================================================================================================

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new LinkedList<>();
	    int i = 0;
	    // add all the intervals ending before newInterval starts
	    while (i < intervals.length && intervals[i][1] < newInterval[0]){
	        result.add(intervals[i]);
	        i++;
	    }
	    
	    // merge all overlapping intervals to one considering newInterval
	    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
	    	// we could mutate newInterval here also
	        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
	        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
	        i++;
	    }
	    
	    // add the union of intervals we got
	    result.add(newInterval); 
	    
	    // add all the rest
	    while (i < intervals.length){
	    	result.add(intervals[i]); 
	    	i++;
	    }
	    
	    return result.toArray(new int[result.size()][]);
    }
}