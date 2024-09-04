package datastructures.tree.ch10binarytrees;

import java.util.Stack;

public class Seven_InorderWithoutRecursion {
    public static void main(String[] args) {
        Node root=Node.createBinaryTree();
        inorder(root);
    }
    static void inorder(Node root){

        inorder(root,new Stack<Node>() );
    }
    static void inorder(Node root,  Stack<Node> stack){
        if(root !=null) {
            //datastructures.stack.push(root.right);
            stack.push(root);
            //datastructures.stack.push(root.left);
        }
        while(!stack.isEmpty()){
            Node n=stack.pop();
            System.out.println(n);
            stack.push(root.right);
            //datastructures.stack.push(root);
            stack.push(root.left);



        }
    }
}
