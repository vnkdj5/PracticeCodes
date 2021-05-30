import java.util.*;
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
    public List<Integer> postorderTraversal_Stacks(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        if(root==null)
            return list;
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode tmp=s1.pop();
            s2.push(tmp);
            if(tmp.left!=null)
                s1.push(tmp.left);
            if(tmp.right!=null)
                s1.push(tmp.right);
            
        }
        
        while(!s2.isEmpty())
            list.add(s2.pop().val);
        
        return list;
    }
    
     public List<Integer> postorderTraversal(TreeNode root) {
         List<Integer> res=new ArrayList<>();
         postOrder(root, res);
         
         return res;
         
     }
    
    private void postOrder(TreeNode node, List<Integer> res){
        if(node==null)
            return;
        postOrder(node.left, res);
        postOrder(node.right, res);
        res.add(node.val);
    }
    
}
