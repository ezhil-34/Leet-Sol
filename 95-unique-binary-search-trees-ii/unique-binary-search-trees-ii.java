/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return build(1,n);
    }

    public List<TreeNode> build(int st,int ed){
        List<TreeNode> res = new ArrayList<>();

        if(st>ed){
            res.add(null);
            return res;
        }

        for(int root = st;root<=ed;root++){

            List<TreeNode> leftnode =  build(st,root-1);
            List<TreeNode> rightnode =  build(root+1,ed);

            for(TreeNode left:leftnode){
                for(TreeNode right:rightnode){
                    TreeNode node = new TreeNode(root);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}