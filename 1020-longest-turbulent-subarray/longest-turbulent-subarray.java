class Solution {
    public int maxTurbulenceSize(int[] arr) {
       int up = 1, down =1,max=1;

       for(int i =1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                up =down+1;
                down = 1;
            }
            else if(arr[i]<arr[i-1]){
                down=up+1;
                up = 1;
            }
            else{
                up = down = 1;
            }

            max = Math.max(max,Math.max(up,down));
       }

       return max;
    }
}