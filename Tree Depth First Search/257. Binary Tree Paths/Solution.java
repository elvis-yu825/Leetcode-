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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        if (root == null) return result;
        
        String currentPath = Integer.toString(root.val);
        if (root.left == null && root.right == null) result.add(currentPath);
        if (root.left != null) dfs(root.left, currentPath, result);
        if (root.right != null) dfs(root.right, currentPath, result);
        return result;    
    }
    
    private static void dfs(TreeNode currentNode, String currentPath, List<String> result) {
        currentPath += "->" + currentNode.val;
        
        if (currentNode.left == null && currentNode.right == null) {
            result.add(currentPath);
            return;
        }
        if (currentNode.left != null) dfs(currentNode.left, currentPath, result);
        if (currentNode.right != null) dfs(currentNode.right, currentPath, result);
        
    }
}
