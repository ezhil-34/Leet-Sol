class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>(),res);
        return res;
    }

    public void backtrack(int[] candidates,int remain,int st,List<Integer> curr,List<List<Integer>> res){
        if(remain == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = st;i<candidates.length;i++){
            if(candidates[i]>remain) break;

            if(i>st && candidates[i] == candidates[i-1]){
                continue;
            }

            curr.add(candidates[i]);

            backtrack(candidates,remain - candidates[i],i+1,curr,res);

            curr.remove(curr.size() - 1);
        }
    }
}