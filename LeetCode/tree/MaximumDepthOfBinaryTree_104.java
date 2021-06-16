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
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    
    //Max Depth IerativeBFS
    public int maxDepth_BFS(TreeNode root){
        if(root==null)
            return 0;
        
        Queue<TreeNode> q=new LinkedList<>();
        
        q.offer(root);
        int depth=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){  //For level wise traversal, at ech iteration all nodes will fromsame level will be processed.
                TreeNode node=q.poll();
                if(node.left!=null){
                    q.offer(node.left); //Addning next level nodes
                }
                
                if(node.right!=null){
                    q.offer(node.right); //Addning next level nodes
                }
            }
            depth++;
        }
         
         return depth;
         
         
     }
    
    //Iterrative DFS
    public int maxDepthDFSIterative(TreeNode root){
        if(root==null)
            return 0;
        
        Stack<TreeNode> stack=new Stack<>();
        Stack<Integer> values=new Stack<>();
        
        stack.push(root);
        values.push(1);
        int max=0;
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            int curVal=values.pop(); //Cur max= parent max value
            
            max=Math.max(curVal, max); //update Depth
            if(node.left!=null){
                stack.push(node.left);
                values.push(1+curVal);
            }
            
            if(node.right!=null){
                stack.push(node.right);
                    values.push(1+curVal);
            }
        }
        return max;
    }
}
