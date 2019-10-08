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
    int max= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxgain(root);
        return max;
    }
    
    public int maxgain(TreeNode node)
    {
        if (node == null) return 0;

        int left_gain = Math.max(maxgain(node.left), 0);
        int right_gain = Math.max(maxgain(node.right), 0);

        int sum = node.val + left_gain + right_gain;

        max = Math.max(max, sum);

  
        return node.val + Math.max(left_gain, right_gain);
    }
}