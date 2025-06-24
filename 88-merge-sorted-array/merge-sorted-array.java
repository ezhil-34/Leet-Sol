class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int[] num = new int[m+n];
         int j =0;
        for(int i =0;i<m;i++){
            nums1[j++] = nums1[i];
        }
       
        for(int i =0;i<n;i++ ){
            nums1[j++] = nums2[i];


        }

        Arrays.sort(nums1);
    }
}