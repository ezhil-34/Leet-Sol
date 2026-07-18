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

    class Node{
        int row;
        int col;
        int val;

        Node(int c,int r,int v){
            row = r;
            col = c;
            val = v;
        }
    }
    List<Node> list = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);

        List<List<Integer>> ans = new ArrayList<>();

        int prev = Integer.MIN_VALUE;
        Collections.sort(list, (a,b) ->{

            if(a.col!=b.col){
                return a.col -b.col;
            }
            if(a.row!=b.row){
                return a.row - b.row;
            }

            return a.val - b.val;
        }
        );
        for(Node node:list){
            if(node.col!=prev){
                ans.add(new ArrayList<>());
                prev = node.col;
            }

            ans.get(ans.size()-1).add(node.val);          

        }

        return ans;

    }

    public void dfs(TreeNode root,int col,int row){
        if(root == null) return;

        list.add(new Node(col,row,root.val));

        dfs(root.left,col-1,row+1);

        dfs(root.right,col+1,row+1);
    }
}