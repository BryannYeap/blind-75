class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashMap<Integer,Set<List<Integer>>> memo = new HashMap<>();
        // T(c, t) = SUM[T(c, t - c[i])] for each i
        return new ArrayList<>(helper(candidates, target, memo));
    }

    private Set<List<Integer>> helper(
        int[] candidates, int target, HashMap<Integer,Set<List<Integer>>> memo
        ) {
            if (target == 0) {
                Set<List<Integer>> res = new HashSet<>();
                res.add(new ArrayList<>());
                return memo.getOrDefault(0, res);
            }

            if (memo.get(target) != null) return memo.get(target);

            Set<List<Integer>> res = new HashSet<>();
            memo.put(target, res);
            for (int candidate : candidates) {
                if (target - candidate >= 0) {
                    Set<List<Integer>> subproblems = helper(
                        candidates, target - candidate, memo
                    );
                    for (List<Integer> ls : subproblems) { 
                        List<Integer> clone = new ArrayList<>(ls);
                        clone.add(candidate);
                        clone.sort((x,y) -> x - y);
                        res.add(clone);
                    }
                }
            }

            return res;
    }
}

//================================================================================================================================

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList();
        backtrack(candidates, target, 0, 0, result, new ArrayList());
        return result;
    }
    public void backtrack(int[] candidates, int target, int index, int currentSum, List<List<Integer>> result, List<Integer> list){
        if(index > candidates.length - 1) return;
        if(currentSum > target) return;
        if(currentSum == target){
            result.add(new ArrayList(list));
            return;
        }
        //take current
        list.add(candidates[index]);
        backtrack(candidates, target, index, currentSum + candidates[index], result, list);
        //not take
        list.remove(list.size() - 1);
        backtrack(candidates, target, index+1, currentSum, result, list);
    }
}