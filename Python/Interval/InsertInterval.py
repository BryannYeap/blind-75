class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        added = False
        i = 0
        while i < len(intervals):
            interval = intervals[i]
            if added:
                res.append(interval)
                i += 1
                continue

            if interval[1] < newInterval[0]:
                res.append(interval)
            elif interval[0] > newInterval[1]:
                    res.append(newInterval)
                    res.append(interval)
                    added = True
            else:
                newInterval = [min(interval[0], newInterval[0]), max(interval[1], newInterval[1])]
            i += 1
       
        if not added:
            res.append(newInterval)
        return res
                    
