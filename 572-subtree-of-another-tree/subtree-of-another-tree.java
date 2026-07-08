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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;

        if(root == null || subRoot == null) return false;

        if(subRoot == null) return true;

        if(issametree(root,subRoot)) return true;

        return isSubtree(root.left,subRoot) || 
                isSubtree(root.right,subRoot);
    }

    public boolean issametree(TreeNode p,TreeNode q){
        if(p==null && q == null) return true;

        if(p==null || q == null) return false;

        if(p.val != q.val) return false;

        return issametree(p.left,q.left) && issametree(p.right,q.right);
    }
}