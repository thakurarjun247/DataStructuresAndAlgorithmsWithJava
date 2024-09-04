package datastructures.tree.ch10binarytrees;

import java.util.ArrayList;
import java.util.List;

public class Five_PrintRootToLeafPathWithGivenSum {
    public static void main(String[] args) {
Node root=Node.createBinaryTree();
        int targetSum=15;


        List<Integer> list=pathSumRootToLeaf(root, targetSum);
        if(!list.contains(targetSum))
            System.out.println("path with sum doesn't exist: "+targetSum);

    }
    static List<Integer> pathSumRootToLeaf(Node root, int targetSum) {
        return pathSumRootToLeaf(root, new ArrayList<Integer>(), 0, "", targetSum);
    }

    static List<Integer> pathSumRootToLeaf(Node root, List<Integer> list, int sumSoFar, String path, int targetSum) {
        //if root is null or we reached beyond leaf
        if (root == null)
            return list;

        //add this key to sumSoFar so far
        sumSoFar += root.key;


        //if we reached leaf, we should add this sumSoFar to master leaf, one path completed here
        if (root.left == null && root.right == null)
        {
            list.add(sumSoFar);
            if(sumSoFar==targetSum)
                System.out.println("path with sumSoFar "+sumSoFar+" is "+path+" -> "+root);
        }

        //explore left and right

        pathSumRootToLeaf(root.left, list, sumSoFar, path+" -> "+root, targetSum);

        pathSumRootToLeaf(root.right, list, sumSoFar, path+" -> "+root, targetSum);


        return list;

    }
}
