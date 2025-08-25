"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        adjList = {}
        visited = set([node.val])
        queue = deque([node])
        while queue:
            for _ in range(len(queue)):
                currNode = queue.popleft()
                newNeighbors = []
                for neighbor in currNode.neighbors:
                    newNeighbors.append(neighbor.val)
                    if neighbor.val not in visited:
                        visited.add(neighbor.val)
                        queue.append(neighbor)
                adjList[currNode.val] = newNeighbors
        print(adjList)
        nodes = [None]

        for i in range(1, len(adjList) + 1):
            nodes.append(Node(i))
            print(nodes[i].val)
        
        for nodeIndex in adjList:
            currNode = nodes[nodeIndex]
            neighbors = []
            for neighborIndex in adjList[nodeIndex]:
                neighbors.append(nodes[neighborIndex])
            currNode.neighbors = neighbors
        return nodes[node.val]
                
        