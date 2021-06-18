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
  
  //There is also substraction method do checkout
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
      return  helper(root, targetSum, 0);
    }
    
    private boolean helper(TreeNode node, int target, int cur){
        if(node==null)
            return false;
        cur=cur+node.val;
        if(node.left==null && node.right==null) 
            return cur==target;
        return (helper(node.left,target, cur ) || helper(node.right,target, cur ) );
        
    }
}
