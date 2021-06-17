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
    //DFS O(n)
    public boolean isBalanced(TreeNode root) {
        
        return height(root)!=-1;
    }
    
    private int height(TreeNode node){
        if(node==null)
            return 0;
        
        int leftHeight=height(node.left);
        int rightHeight=height(node.right);
        
        if(leftHeight==-1 || rightHeight==-1 || Math.abs(leftHeight-rightHeight)>1)
            return -1;
        
        return Math.max(leftHeight,rightHeight)+1;
    }
    
    
    //Top Down O(n^2)
    public boolean isBalanced_TopDown(TreeNode root) {
        if(root==null)
            return true;
        int left=heightOfTree(root.left);
        int right=heightOfTree(root.right);
        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    int heightOfTree(TreeNode node){
        if(node==null)
            return 0;
        return 1+Math.max(heightOfTree(node.left), heightOfTree(node.right));
        
    }
}
