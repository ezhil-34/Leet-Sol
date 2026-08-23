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
 import java.util.*;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> dq = new LinkedList<>();

        dq.addLast(root);
        boolean rev = false;

        while(!dq.isEmpty()){
            int n = dq.size();
            List<Integer> ls = new ArrayList<>();
            while(n-- > 0){
                

                if(rev){
                    TreeNode curr = dq.removeLast();

                    ls.add(curr.val);
                    if(curr.right!=null) dq.addFirst(curr.right);
                    if(curr.left!=null) dq.addFirst(curr.left);
                }

                else{
                    TreeNode curr = dq.removeFirst();
                    ls.add(curr.val);

                    if(curr.left!=null) dq.addLast(curr.left);
                    if(curr.right!=null) dq.addLast(curr.right);
                }
            }
            rev = !rev;

            res.add(ls);
        }

        return res;
    }
}