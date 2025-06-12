class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int n : nums) {

            if (n == 1) {
                count++;
            }

            if (count > max) {
                max = count;
            }
            if (n == 0) {
                count = 0;
            }

        }

        return max;
    }
}