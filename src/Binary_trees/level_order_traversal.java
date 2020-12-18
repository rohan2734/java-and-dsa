package BinaryTrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class level_order_traversal {
    public static class QueueEmptyException extends Exception {

    }
    
    public static class QueueUsingLL<T> {
    
        public static class Node<T> {
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
    
    
    public static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    
        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static class Pair<T, U> {
        T minimum;
        U maximum;
    
        public Pair(T minimum, U maximum) {
            this.minimum = minimum;
            this.maximum = maximum;
        }
    
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");

		if (nodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(nodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}

			int leftChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}

			int rightChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}

		return root;
	}

    public static void printLevelWise(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();

        pendingNodes.enqueue(root);
        pendingNodes.enqueue(null);

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode;
            try{
                frontNode = pendingNodes.dequeue();
            }catch(QueueEmptyException e){
                return;
            }

            if(frontNode == null){
                if(!pendingNodes.isEmpty()){
                    System.out.println();
                    pendingNodes.enqueue(null);
                }else{
                    break;
                }
            }
            if(frontNode != null){
                System.out.print(frontNode.data +" ");
                if(frontNode.left != null){
                    pendingNodes.enqueue(frontNode.left);
                }
                if(frontNode.right != null){
                    pendingNodes.enqueue(frontNode.right);
                }
            }
            
        
        }

    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		
		printLevelWise(root);

	}
}
