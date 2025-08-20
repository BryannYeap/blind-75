class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        def dist(x,y):
            return math.sqrt(x**2 + y**2)
        
        heap = []
        
        for point in points:  # O(n)
            distFromOrigin = dist(point[0], point[1])
            heap.append((distFromOrigin, point))

        heapq.heapify(heap) # O(n)
        
        res = []
        for i in range(k):  # O(k)
            distPointPair = heapq.heappop(heap)
            res.append(distPointPair[1])
        return res
        

        