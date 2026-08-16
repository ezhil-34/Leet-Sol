class Solution {
    public int findNumberOfLIS(int[] nums) {

        if(nums.length == 1) return 1;
        int n = nums.length;
        int[] length = new int[n];
        int[] cnt = new int[n];

        int max = 0;

        Arrays.fill(length,1);
        Arrays.fill(cnt,1);

        for(int i =1;i<n;i++){
            for(int j =0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(length[j]+1>length[i]){
                        length[i] = 1+length[j];
                        cnt[i] = cnt[j];
                    }

                    else if(length[j]+1 == length[i]){
                        cnt[i]+=cnt[j];
                    }
                }
            }
            max = Math.max(max,length[i]);

        }

        int total = 0;
        for(int i =0;i<n;i++){
            if(length[i] == max){
                total+=cnt[i];
            }
        }

        return total;
    }
}