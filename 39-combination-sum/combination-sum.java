class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        back(0,candidates,target,new ArrayList<>(),res);
        return res;
    }
    public void back(int st,int[] candidates,int target,List<Integer> curr,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(curr));
        }
        if(target<0) return;
        for(int i =st;i<candidates.length;i++){
            curr.add(candidates[i]);
            back(i,candidates,target - candidates[i],curr,res);
            curr.remove(curr.size()-1);
        }
    }
}