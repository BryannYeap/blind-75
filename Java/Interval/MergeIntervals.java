class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x,y) -> x[0] - y[0]);

        LinkedList<int[]> res = new LinkedList<>();

        int i = 0;
        int j = 1;
        while (i < intervals.length) {
            int[] ls = new int[2];

            int[] interval1 = intervals[i];
            ls[0] = interval1[0];
            ls[1] =interval1[1];
            
            j = i + 1;
            while (j < intervals.length) {
                int[] interval2 = intervals[j];
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