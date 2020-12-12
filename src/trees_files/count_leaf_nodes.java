package trees_files;

import java.util.Scanner;
import java.util.*;

public class count_leaf_nodes {
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
	
	public static int numNodes( TreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		int count  = 1;
		for(int i=0;i<root.children.size();i++){
			count += numNodes(root.children.get(i));
		}
		return count;
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
			
		}
		return root;
    }

    public static int countOfLeafNodes(TreeNode <Integer> root){
        if(root == null){
            return 0;
        }
        int count=0;
        if(root.children.size() == 0){
            return 1;
        }
        for(int i=0;i<root.children.size();i++){
            count += countOfLeafNodes(root.children.get(i));
        }

        return count;
    }
    
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TreeNode<Integer> root = takeInputLevelWise();

        int output = countOfLeafNodes(root);
        System.out.println(output);


    }
}
