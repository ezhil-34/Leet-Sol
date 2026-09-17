class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minlen = new int[n];
        Arrays.fill(minlen,Integer.MAX_VALUE);

        int left = 0,current = 0;
        int mintotal = Integer.MAX_VALUE;
        int currentmin = Integer.MAX_VALUE;

        for(int right = 0;right<n;right++){
            current+=arr[right];

            while(current> target){
                current-=arr[left];
                left++;
            }

            if(current == target){
                int len = right-left+1;

                if(left>0 && minlen[left-1] !=Integer.MAX_VALUE){
                    mintotal = Math.min(mintotal,len+minlen[left-1]);
                }

                currentmin = Math.min(currentmin,len);
            }

            minlen[right] = currentmin;
        }

        return mintotal == Integer.MAX_VALUE?-1:mintotal;
    }
}