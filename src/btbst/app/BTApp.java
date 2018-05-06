package btbst.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import btbst.fun.BT;
import btbst.TreeNode;

public class BTApp {
	public static void main(String[] args) throws Exception {
		TreeNode root = null;
		TreeNode newRoot=null;
		TreeNode root1=null;
		TreeNode root2=null;
		Scanner scanner = new Scanner(System.in);
		BT binaryTree = new BT();
		for (int i = 0; i < 100; i++) {

			binaryTree.displayChoice();
			int choice = scanner.nextInt();
			switch (choice) {
			case -1:
				System.exit(0);
				break;
			case 0:
				System.out.println("enter the number of nodes to be inserted");
				int number = scanner.nextInt();
				for (int j = 0; j < number; j++) {
					
					System.out.println("enter data value");
					int data = scanner.nextInt();
					root = binaryTree.insert(root,data);
				}
				break;
			case 1:
				int size = binaryTree.inOrder(root);
				System.out.println("tree size is " + size);
				break;
			case 2:
				binaryTree.preOrder(root);
				break;
			case 3:
				binaryTree.postOrder(root);
				break;
			case 4:
				System.out.println("tree size is " + binaryTree.getSize(root));
				break;
			case 5:
				/*binaryTree.checkIfTwoTreesIdentical();
				break;*/
			case 6:
			/*	System.out.println("creating 2 trees to check if identical");
				System.out.println("enter the number of nodes to be inserted in tree1");
				int n1 = scanner.nextInt();
				for (int j = 0; j < n1; j++) {
					root1 = binaryTree.insert();
				}
				System.out.println(binaryTree.identical(root, root));
				
				System.out.println("enter the number of nodes to be inserted in tree2");
				int n2 = scanner.nextInt();
				for (int j = 0; j < n2; j++) {
					root2 = binaryTree.insert();
				}
				System.out.println(binaryTree.identical(root1, root2));
				break;*/
			case 7:
				newRoot=binaryTree.newInsert();
				break;
			case 8:
				System.out.println("new Inorder...");
				binaryTree.newInOrder(root);
				break;
			case 9:
				System.out.println("isbst ? "+binaryTree.isBST(root, null));
				//solution at page 228 ctci
				break;
			case 10:
				binaryTree.levelOrder(root);
				break;
			case 11:
				binaryTree.bottomView(root);
				
				break;
			case 12:
				System.out.println("is balanced? "+ binaryTree.isBalanced(root));
			case 13:
				int[] a={0,1,2,3,4,5,6,7,8,9};
				TreeNode treeNode=binaryTree.createTreeFromArray(a,0,a.length-1);
				binaryTree.inOrder(treeNode);
				break;
			case 14:
				List<LinkedList<TreeNode>> list=new ArrayList<LinkedList<TreeNode>>();
				/*list=*/binaryTree.levelWiseLLs(root,list,0 );
				//list.forEach(item-> System.out.println(item));
				break;
			case 15:
				System.out.println(binaryTree.lowestCommonAncestor(root, root.right, root.right.left));
				break;
				
			case 16:
				System.out.println(binaryTree.maxDiffBetweenANodeAndAncestor(root));
				break;
		
			case 17: 
				System.out.println("input the sum");
				System.out.println(printPathsWithASumAsGivenValue(root, scanner.nextInt()));

			default:
				System.out.println("invalid choise, retry");

			}
		}
		scanner.close();

	}

	private static char[] printPathsWithASumAsGivenValue(TreeNode root,
			int nextInt) {
		// TODO Auto-generated method stub
		return null;
	}

}