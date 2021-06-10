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
    public TreeNode balanceBST(TreeNode root) {
        //1. Store order traversal in arrayList
        List<TreeNode> nodes=new ArrayList<>();
        inOrder(root, nodes);
        //2. USe this sorted ArrayList for making blanced BST
        return convertBST(nodes, 0, nodes.size()-1);
    }
    
    public TreeNode convertBST(List<TreeNode> nodes, int low, int high){
        TreeNode node=null;
        if(low<=high){
            int mid=(low+high)/2;
            node=nodes.get(mid);
            node.left=convertBST(nodes, low, mid-1);
            node.right=convertBST(nodes, mid+1, high);
        }
        
        return node;
    }
    
    private void inOrder(TreeNode root, List<TreeNode> nodes){
        if(root==null)
            return;
        inOrder(root.left, nodes);
        nodes.add(root);
        inOrder(root.right, nodes);
    } 
}
