class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int res =0;
        for(int j = 0;j<n;j++){
            int[] resu = new int[26];
            for(int i =j;i<n;i++){
                resu[s.charAt(i)-'a']++;
                int maxf = 0;
                int minf = Integer.MAX_VALUE;
                for(int f: resu){
                    if(f>0){
                        minf= Math.min(minf,f);
                        maxf = Math.max(maxf,f);

                    }
                }
                res+= (maxf-minf);
            }
        }
        return res;
    }
}