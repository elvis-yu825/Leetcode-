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
    public int pathSum(TreeNode root, int sum) {
        List<Integer> currentPath = new LinkedList<>();
        return countPaths(root, sum, currentPath);
    }
    
    private static int countPaths(TreeNode currentNode, int sum, List<Integer> currentPath) {
        if (currentNode == null) return 0;
        //add current node to the path
        currentPath.add(currentNode.val);
        int pathCount = 0;
        int pathSum=0;
        //find sum of all sub-paths in the current path list
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            //if the sum of any sub-path is equal to "sum", we increment the pathcount
            if (pathSum == sum) {
                pathCount++;
            }
        }
        pathCount += countPaths(currentNode.left, sum, currentPath);
        pathCount += countPaths(currentNode.right, sum, currentPath);
        currentPath.remove(currentPath.size()-1);
        return pathCount;
    }
}
