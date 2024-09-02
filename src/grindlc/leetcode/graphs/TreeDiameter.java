package grindlc.leetcode.graphs;

import datastructuresandalgorithms.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TreeDiameter {
}

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
class Solution1 {
    //https://www.youtube.com/watch?v=bkxqA8Rfv04
    Map<TreeNode,Integer> map;
    int maxDiameterOfANodeSoFar;
    public int diameterOfBinaryTree(TreeNode root) {

        maxDiameterOfANodeSoFar =0;
        map = new HashMap();
        calculateDiameter(root);
        return maxDiameterOfANodeSoFar;

    }
    private void calculateDiameter(TreeNode root){
        if(root==null)
            return;
        maxDiameterOfANodeSoFar =Math.max(maxDiameterOfANodeSoFar, 2+ calculateHeight(root.left)+ calculateHeight(root.right));
        calculateDiameter(root.left);
        calculateDiameter(root.right);

    }
    private int calculateHeight(TreeNode node){

        if(node == null)
            return -1;

        if(map.containsKey(node))
            return map.get(node);
        map.put(node, 1+Math.max(
                        calculateHeight(node.left),
                        calculateHeight(node.right)
                )
        );
        return map.get(node);
    }
}
