package leetcode;
import java.util.*;
public class LC314_VerticalOrderTraversalBT {
    
     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
     
    class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
           // map=new HashMap<>();
            final Map<Integer, List<TreeNode>> map= f(root, new HashMap<Integer, List<TreeNode>>());
            List<List<Integer>> lists= new ArrayList<>();
            Set<Integer> keys=map.keySet();
           // keys.forEach(key-> lists.add(map.get(key)));
            return lists;

        }
        class Node{
            TreeNode treeNode;
            Integer hd;
            Node(TreeNode treeNode, Integer hd){
                this.treeNode=treeNode;
                this.hd=hd;
            }
        }
        Map<Integer, List<TreeNode>> f(TreeNode root, Map<Integer, List<TreeNode>> map){

            if(root ==null ) return map;
            Queue<Node> q=new LinkedList<>();
            q.add(new Node(root, 0));
            while(!q.isEmpty()){
                Node node =q.poll();
                if(map.containsKey(node.hd)){
                    map.get(node.hd).add(node.treeNode);
                }
                else{
                    List<TreeNode> list=new ArrayList<>();
                    list.add(node.treeNode);
                    map.put(node.hd, list);
                }
                if(node.treeNode.left!=null)
                    q.add(new Node(node.treeNode.left, node.hd-1));

                if(node.treeNode!=null)
                    q.add(new Node(node.treeNode.right,node.hd+1));
            }
       return null; }
    }
}
