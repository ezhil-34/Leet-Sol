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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode parent = null;
        while(curr!=null && curr.val!=key){
            parent =  curr;
            if(key<curr.val) curr = curr.left;
            else curr = curr.right;
        }
        if(curr == null) return root;

        if(curr.left!=null && curr.right!=null){
             TreeNode succ = curr.right;
             TreeNode succp = curr;

             while(succ.left!=null){
                succp = succ;
                succ = succ.left;
             }

             curr.val = succ.val;
             curr = succ;
             parent = succp;
        }
        TreeNode child = (curr.left!=null)?curr.left:curr.right;
        if(parent == null) return child;

        if(parent.left == curr) {
            parent.left = child;
        }
        else parent.right = child;

        return root;
    }
}