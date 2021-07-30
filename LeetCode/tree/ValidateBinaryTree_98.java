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
    public boolean isValidBSTInterative(TreeNode root) {
        if(root==null)
            return true;
       
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        TreeNode prev=null;
        while(node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            
            if(prev!=null && prev.val>=node.val) return false;
            prev=node;
            node=node.right;
        }
        
        return true;
        
    }
    
    
    public boolean isValidBST(TreeNode root) {
        
        return isValidBSTCheck(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
        
    }
    
    private boolean isValidBSTCheck(TreeNode node, long min, long max){
         if(node==null)
            return true;
        //validation case of BST
        if(min >=node.val || max<=node.val)
            return false;
        return  isValidBSTCheck(node.left, min, node.val) &&  isValidBSTCheck(node.right, node.val , max);
    }
}
