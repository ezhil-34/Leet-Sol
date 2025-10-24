class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int totalgas = 0;
        int start = 0, tank = 0;

        for(int i =0;i<n;i++){

            int diff = gas[i] - cost[i];
            totalgas+=diff;
            tank+=diff;

            if(tank<0){
                start = i+1;
                tank = 0;
            }
        }
        return totalgas>=0 ? (start%n) : -1;
    }
}