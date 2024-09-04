package datastructures.tree.ch10binarytrees;

import java.util.*;

public class Four_RootToLeafPathSum {
    public static void main(String[] args) {

       Node root=Node.createBinaryTree();


        List<Integer> list=pathSumRootToLeaf(root);
        list.forEach(System.out::println);
    }
    static List<Integer> pathSumRootToLeaf(Node root) {
        return pathSumRootToLeaf(root, new ArrayList<Integer>(), 0);
    }

    static List<Integer> pathSumRootToLeaf(Node root, List<Integer> list, int sum) {
        //if root is null or we reached beyond leaf
        if (root == null)
            return list;

        //add this key to sum so far
        sum += root.key;


        //if we reached leaf, we should add this sum to master leaf, one path completed here
        if (root.left == null && root.right == null)
            list.add(sum);

        //explore left and right

        pathSumRootToLeaf(root.left, list, sum);

        pathSumRootToLeaf(root.right, list, sum);


        return list;

    }
}
