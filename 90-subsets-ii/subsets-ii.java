class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        back(0,nums,new ArrayList<>(),res);
        return res;
    }
    public void back(int st,int[] nums,List<Integer> curr,List<List<Integer>> res){
            res.add(new ArrayList<>(curr));
            for(int i =st;i<nums.length;i++){
                if(i>st && nums[i] == nums[i-1]) continue;
                curr.add(nums[i]);
                back(i+1,nums,curr,res);
                curr.remove(curr.size()-1);
            }

    }
}