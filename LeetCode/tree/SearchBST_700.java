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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node=root;
        while(node != null){
            
        if(node.val == val)
            return node;
        else if( node.val > val)
            node = node.left;
        else
            node = node.right;
        }
        return null;
        
    }
    
     public TreeNode searchBST_REC(TreeNode root, int val) {
        if(root==null)
            return null;
        if(root.val==val)
            return root;
        else if(root.val>val)
            return searchBST_REC(root.left, val);
        else
            return searchBST_REC(root.right, val);
    }
}
