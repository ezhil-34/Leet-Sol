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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

       Stack<TreeNode> st = new Stack<>();
        st.push(root);
       while(!st.isEmpty()){
        TreeNode curr = st.pop();

        TreeNode temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;

        if(curr.left!=null) st.push(curr.left);
        if(curr.right!=null) st.push(curr.right);
        
       }

        return root;
    }
}