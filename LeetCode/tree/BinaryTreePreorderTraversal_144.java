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
    
    //Iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null)
            return res;
        TreeNode tmp=root;
        stack.push(tmp);
        while(!stack.isEmpty()){
            
            tmp=stack.pop();
            res.add(tmp.val);
            
            if(tmp.right!=null)
                stack.add(tmp.right);
            
            if(tmp.left!=null)
                stack.add(tmp.left);
            
        }
        return res;
    }
    
    //Recursive
    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        preOrder(root, list);
        return list;
    }
    
    void preOrder(TreeNode root, List<Integer> list){
        if(root==null)
            return;
    
        list.add(root.val);

        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
