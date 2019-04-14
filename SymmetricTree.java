/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isSymmetricHelper(root.left, root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        
        if (node1 == null || node2 == null) {
            return false;
        }
        
        if (node1.val == node2.val) {
            return isSymmetricHelper(node1.left, node2.right) && isSymmetricHelper(node1.right, node2.left);
        }
        
        return false;
    }
}