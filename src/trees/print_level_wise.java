package trees;
import java.util.ArrayList;
import java.util.Scanner;

public class print_level_wise {
	
	

	public static class QueueEmptyException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		 
	}

	public static class QueueUsingLL<T> {

		class Node<T> {
			T data;
			Node<T> next;
			Node(T data){
				this.data = data;
			}
		}
		
		private Node<T> head;
		private Node<T> tail;
		private int size = 0;

		public int size(){
			return size;
		}

		public boolean isEmpty(){
			if(size == 0){
				return true;
			}
			return false;
		}

		public T front() throws QueueEmptyException{
			if(size == 0){
				QueueEmptyException e = new QueueEmptyException();
				throw e;
			}

			return head.data;
		}


		public void enqueue(T element){
			Node<T> newNode = new Node<T>(element);

			if(head == null){
				head = newNode;
				tail = newNode;
			}
			else{
				tail.next = newNode;
				tail = newNode;
			}

			size++;
		}

		public T dequeue() throws QueueEmptyException{
			if(head == null){
				QueueEmptyException e = new QueueEmptyException();
				throw e;
			}
			if(head == tail){
				tail = null;
			}
			T temp = head.data;
			head = head.next;
			size--;
			return temp;
		}
	}

	   public static class TreeNode<T> {
			T data;
			ArrayList<TreeNode<T>> children;

			TreeNode(T data){
				this.data = data;
				children = new ArrayList<TreeNode<T>>();
			}
		}
	   
	   static Scanner s = new Scanner(System.in);

		public static TreeNode<Integer> takeInputLevelWise(){
			QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
			int rootData = s.nextInt();
			TreeNode<Integer> root = new TreeNode<Integer>(rootData);
			pendingNodes.enqueue(root);
			while(!pendingNodes.isEmpty()){
				TreeNode<Integer> currentNode;
				try {
					currentNode = pendingNodes.dequeue();
					int numChild = s.nextInt();
					for(int i = 0 ; i < numChild; i++){
						int currentChild = s.nextInt();
						TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
						pendingNodes.enqueue(childNode);
						currentNode.children.add(childNode);
					}
				} catch (QueueEmptyException e) {
				}
			}
			return root;
		}
	
	public static void printLevelWise(TreeNode<Integer> root){
		
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();
		pendingNodes.enqueue(root);
		System.out.println(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode = pendingNodes.dequeue();
			String s = "";
			for(int i=0;i<currentNode.children.size();i++){
				s  = s + currentNode.children.get(i) +" "; 
				pendingNodes.enqueue(currentNode.children.get(i));
			}
			System.out.println(s);
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root =  takeInputLevelWise();
		printLevelWise(root); 
	}

}
