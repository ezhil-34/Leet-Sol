class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();
        for(int r  = 0;r<numRows;r++){
            List<Integer> curr = new ArrayList<>();
            for(int c =0;c<=r;c++){
                if(c==0 || c==r){
                    curr.add(1);
                }
                else{
                    int sum = tri.get(r-1).get(c-1) + tri.get(r-1).get(c);
                    curr.add(sum);
                }
            }
            tri.add(curr);

        }
        return tri ;
    }
}