class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dp(nums, 0, 0, target);
    }

    private int dp(int[] nums, int i, int sum, int target) {
        String key = i + "," + sum;
        if (memo.containsKey(key)) return memo.get(key);

        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        int add = dp(nums, i + 1, sum + nums[i], target);
        int subtract = dp(nums, i + 1, sum - nums[i], target);
        memo.put(key, add + subtract);

        return memo.get(key);
    }
}
