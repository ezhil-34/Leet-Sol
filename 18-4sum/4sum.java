class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
         List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return res;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Early termination: smallest possible sum too big?
            long min1 = (long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            if (min1 > target) break;
            // Early termination: largest possible sum too small?
            long max1 = (long)nums[i] + nums[n-1] + nums[n-2] + nums[n-3];
            if (max1 < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                long rem = (long)target - nums[i] - nums[j];
                int left = j + 1, right = n - 1;

                // Early pruning
                long min2 = (long)nums[left] + nums[left+1];
                if (min2 > rem) continue;
                long max2 = (long)nums[right] + nums[right-1];
                if (max2 < rem) continue;

                while (left < right) {
                    long sum2 = (long)nums[left] + nums[right];
                    if (sum2 == rem) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++; right--;
                        // Skip duplicates for left/right
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum2 < rem) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}