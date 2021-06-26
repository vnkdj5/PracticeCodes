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
  //Bottom level should be printed first
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> list=new LinkedList<List<Integer>>();
        //LinkedList used as we need to add elements at start
    
        if(root==null)
            return list;
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> levelNodes=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                levelNodes.add(node.val);
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
                
            }
            list.add(0, levelNodes);
        }
        
        return list;
        
    }
}
