class Solution {
    int[] parent = new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(int i = 0;i<26;i++){
            parent[i] = i;
        }
        for(int i = 0;i<s1.length();i++){
            union(s1.charAt(i) - 'a',s2.charAt(i)-'a');
        }
        StringBuilder sb = new StringBuilder();
        for(char ne: baseStr.toCharArray()){
            char small = (char)(find(ne - 'a')+'a');
            sb.append(small);
        }
        return sb.toString();
    }
    
    public int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x,int y){
        int px = find(x);
        int py = find(y);
        if(px == py) return ; 
        else if(px<py){
            parent[py] = px;
        }
        else parent[px] = py;


    }
    
}