class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, candidates, 0, new ArrayList<>(), target);
        return res;
    }

    void backtrack(List<List<Integer>> res, int[] cands, int start, List<Integer> currList, int remain) {
        if (remain == 0) {
            res.add(new ArrayList<> (currList));
            return;
        }
        for (int i = start; i < cands.length; i++) {
            //remove duplicates in the same level
            if (i > start && cands[i] == cands[i-1]) {
                continue;
            }
            if (cands[i] > remain) break;

            currList.add(cands[i]);
            backtrack(res, cands, i+1, currList, remain-cands[i]);
            currList.remove(currList.size()-1);
        }
    }
}