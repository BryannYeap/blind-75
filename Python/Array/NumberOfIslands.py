# DFS
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        foundInIsland = set()
        res = 0

        for i in range(rows):
            for j in range(cols):
                if (i,j) in foundInIsland:
                    continue
                if grid[i][j] == "1":
                    res += 1
                    queue = deque([(i,j)])
                    while queue:
                        for _ in range(len(queue)):
                            row,col = queue.popleft()
                            if (row,col) in foundInIsland:
                                continue
                            if grid[row][col] == "0":
                                continue
                            if grid[row][col] == "1":
                                foundInIsland.add((row, col))
                            if (row + 1 < rows):
                                queue.append((row + 1, col))
                            if (col + 1 < cols):
                                queue.append((row, col + 1))
                            if (row - 1 >= 0):        
                                queue.append((row - 1, col))
                            if (col - 1 >= 0):
                                queue.append((row, col - 1))
                    
        return res

#BFS
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        foundInIsland = set()
        res = 0

        for i in range(rows):
            for j in range(cols):
                if (i,j) in foundInIsland:
                    continue
                if grid[i][j] == "1":
                    res += 1
                    queue = deque([(i,j)])
                    while queue:
                        for _ in range(len(queue)):
                            row,col = queue.popleft()
                            if (row,col) in foundInIsland:
                                continue
                            if grid[row][col] == "0":
                                continue
                            if grid[row][col] == "1":
                                foundInIsland.add((row, col))
                            if (row + 1 < rows):
                                queue.append((row + 1, col))
                            if (col + 1 < cols):
                                queue.append((row, col + 1))
                            if (row - 1 >= 0):        
                                queue.append((row - 1, col))
                            if (col - 1 >= 0):
                                queue.append((row, col - 1))
                    
        return res
