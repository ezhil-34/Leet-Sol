class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] cars = new int[n][2];

        for(int i =0;i<n;i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars,(a,b) -> b[0] - a[0]);

        int fleet = 0 ;
        double lasttime = 0;

        for(int i =0;i<n;i++){
            double time = (double) (target - cars[i][0]) / cars[i][1];

            if(time>lasttime){
                fleet++;
                lasttime = time;
            }
        }
        return fleet;
    }
}