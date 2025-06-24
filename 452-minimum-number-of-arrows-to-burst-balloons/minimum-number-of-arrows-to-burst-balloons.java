class Solution {
    public int findMinArrowShots(int[][] points) {
        
        if(points.length == 0) return 0;
        int arr = 1;
        Arrays.sort(points,(a,b) -> Integer.compare(a[1],b[1]));
        int end = points[0][1];
        for(int i =1;i<points.length;i++){
            if(points[i][0]>end){
                arr++;
                end = points[i][1];
            }
            
        }
        return arr;
    }
}