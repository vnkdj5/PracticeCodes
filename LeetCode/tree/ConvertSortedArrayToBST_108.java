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
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums,0, nums.length-1);
    }
    
    public TreeNode BST(int nums[], int low, int high){
     
        if(low<=high){
            int mid=(low+high)/2;
            TreeNode node=new TreeNode(nums[mid]);
            node.left=BST(nums, low, mid-1);
            node.right=BST(nums, mid+1, high);
            return node;
        }
        return null;
       
    }
    
    
    public TreeNode sortedArrayToBST_withStack(int[] nums) {
        if(nums==null || nums.length==0)
            return null;
        Stack<Object> stack=new Stack<>();
        int low=0, high=nums.length-1;
        
        TreeNode root=new TreeNode();
        stack.push(high);
        stack.push(low);
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=(TreeNode) stack.pop();
            low=(Integer)stack.pop();
            high=(Integer)stack.pop();
            int mid=(low+high)/2;
            node.val=nums[mid];
            if(low<=mid-1){
                node.left=new TreeNode();
                stack.push(mid-1);
                stack.push(low);
                stack.push(node.left);
            }
            
            if(mid+1<=high){
                node.right=new TreeNode();
                stack.push(high);
                stack.push(mid+1);
                stack.push(node.right);
            }
            
        }
        
        return root;
        
    }
}
