package problemsfrombooks.epi.ch10binarytrees;

public class Nine_KthItemInInorderTraversal {
    public static void main(String[] args) {
        Node f = new Node(2,4);
        Node g = new Node(6,2);
        Node e = new Node(4,0);
        Node root = new Node(0, 8);
        Node c = new Node(1,2);
        Node d = new Node(3,0);
        Node h = new Node(7,0);
        Node i = new Node(8,0);
        Node x = new Node(5,0);
        f.left = x;
        root.left = c;
        root.right = f;
        c.left = d;
        c.right = e;
        f.right = g;
        g.left = h;
        g.right = i;

        for(int counter=1;counter<10;counter++)
            System.out.println(counter+" -> "+kthNode(root, counter));
    }
    static Node kthNode(Node root, int k){
        if(root==null || k<1) return null;

        if(root.left!=null){
            if(root.left.numOfDescendents== (k-1))
                return root;
            if(root.left.numOfDescendents<k)
              return  kthNode(root.right, k-root.left.numOfDescendents-1);
            else
              return  kthNode(root.left, k-1);
        }
        if(k==1) return root;
       else
           return kthNode(root.right, k-1);

    }
}
