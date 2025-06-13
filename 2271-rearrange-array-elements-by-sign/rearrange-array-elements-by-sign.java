class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int[] arr = new int[nums.length];

        for(int num : nums){
            if(num<0){

                neg.add(num);
            }
            else{
                pos.add(num);
            }
        }
        int i =0,p=0,n=0;
        while(i<nums.length){
            if(i%2==0){
                arr[i++] = pos.get(p++);
            }
            else{
                arr[i++] = neg.get(n++);
            }
        }


        
        return arr;
    }
}