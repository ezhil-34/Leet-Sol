class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+1];

        for(int c : citations){
            if(c>=n) count[n]++;
            else count[c]++;
        }

        int paper = 0;
        for(int i =n;i>=0;i--){
            paper+=count[i];
            if(paper>=i) return i;
        }
        return 0;
    }
}