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
    
    public int minDepth(TreeNode root) {
        //BFS solution
        if(root==null)
            return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int height=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left==null && node.right==null)
                    return height+1;
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
                
                
            }
            height++;
        }
        return height;
        
        
    }
    public int minDepthDFS(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null)
            return 1+minDepth(root.right);
        if(root.right==null)
            return 1+minDepth(root.left);

        return 1+Math.min(minDepth(root.left), minDepth(root.right));
    }
}
