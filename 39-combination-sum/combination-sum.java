class Solution {
    List<List<Integer>> ans =  new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(0,target,candidates,new ArrayList<>());
        return ans;
    }

    public void backtrack(int id,int target,int[] cand,List<Integer> curr){

        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(target<0 || id == cand.length){
            return;
        }
        curr.add(cand[id]);

        backtrack(id,target-cand[id],cand,curr);
        curr.remove(curr.size()-1);
        backtrack(id+1,target,cand,curr);
    }
}