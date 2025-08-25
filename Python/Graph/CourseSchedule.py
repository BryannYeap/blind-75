class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        prereqMap = {}
        for prereq in prerequisites:
            prereqSet = prereqMap.get(prereq[0], set())
            prereqSet.add(prereq[1])
            prereqMap[prereq[0]] = prereqSet

        def dfs(course):
            nonlocal prereqMap, visited, parents
            visited.add(course)
            parents.add(course)
            prereqSet = prereqMap.get(course, set())
            for coursePrereq in prereqSet:
                if coursePrereq in parents:
                    return False
                if coursePrereq not in visited:
                    if not dfs(coursePrereq):
                        return False
            parents.remove(course)
            return True
            

        for prereq in prereqMap:
            visited = set()
            parents = set()
            if not dfs(prereq):
                return False
        return True
           