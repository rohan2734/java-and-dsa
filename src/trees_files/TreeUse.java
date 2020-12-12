package trees_files;
import java.util.Scanner;

// import stacks_and_queues.QueueEmptyException;

public abstract class TreeUse {

	public static class QueueEmptyException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		 
	}
	
	public static TreeNode<Integer> takeInput(Scanner s){
		int n;
//		Scanner s = new Scanner(System.in);
		System.out.println("Enter next node data");
		n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		System.out.println("Enter number of children" + n);
		int childCount = s.nextInt();
		for(int i=0;i<childCount;i++){
			TreeNode<Integer> child = takeInput(s);
			root.children.add(child);
		}
		return root;
		
	}
	
	public static void print (TreeNode<Integer> root){
		String s = root.data + ":";
		for(int i=0;i<root.children.size();i++){
			s = s +root.children.get(i).data + ",";
		}
		System.out.println(s);
		for(int i=0;i<root.children.size();i++){
			print(root.children.get(i));
		}
//		4:2,1,3,
//		2:
//		1:5,6,
//		5:
//		6:
//		3:

	}
	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootNode = s.nextInt();
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>(); 
		TreeNode<Integer> root = new TreeNode<Integer>(rootNode);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()) {
			try{
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("enter num of children of " + frontNode.data);
				int numChildren = s.nextInt();
				
				for(int i=0;i<numChildren ; i++){
					System.out.println("Enter" + (i+1) + "th child of" + frontNode.data);
					int child = s.nextInt();
					TreeNode<Integer> childNode= new TreeNode<Integer>(child);
					
					frontNode.children.add(childNode);
					pendingNodes.enqueue(childNode);
				}
				
			}catch(QueueEmptyException e){
				//shouldnt enter
				return null;
			}
			return root;
		}
	}
	

	public static void main(String[] args) throws QueueEmptyException{
		Scanner s = new Scanner(System.in);
		// TODO Auto-generated method stub
//		TreeNode<Integer> root = takeInput(s);
		
		TreeNode<Integer> root = takeInputLevelWise();
		print(root);
		
//		TreeNode<Integer> root = new TreeNode<Integer>(4);
//		TreeNode<Integer> node1 = new TreeNode<Integer>(2);
//		TreeNode<Integer> node2 = new TreeNode<Integer>(3);
//		TreeNode<Integer> node3 = new TreeNode<Integer>(5);
//		TreeNode<Integer> node4 = new TreeNode<Integer>(6);
//		
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		
//		node2.children.add(node4);
		
	}
	

}
