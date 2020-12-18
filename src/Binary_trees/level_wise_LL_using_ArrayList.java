package BinaryTrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class level_wise_LL_using_ArrayList {
    public static class QueueEmptyException extends Exception {
    }
    
    public static class QueueUsingLL<T> {
    
        public static class Node<T> {
            T data;
            Node<T> next;
    
            Node(T data) {
                this.data = data;
            }
        }
    
        private Node<T> head;
        private Node<T> tail;
        private int size = 0;
    
        public int size() {
            return size;
        }
    
        public boolean isEmpty() {
            if (size == 0) {
                return true;
            }
            return false;
        }
    
        public T front() throws QueueEmptyException {
            if (size == 0) {
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }
    
            return head.data;
        }
    
        public void enqueue(T element) {
            Node<T> newNode = new Node<T>(element);
    
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
    
            size++;
        }
    
        public T dequeue() throws QueueEmptyException {
            if (head == null) {
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }
            if (head == tail) {
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
        }
    }
    
    public static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }
    
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	static StringTokenizer st;

	public static BinaryTreeNode<Integer> takeInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		if (rootData == -1) {
			return null;
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = Integer.parseInt(st.nextToken());
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = Integer.parseInt(st.nextToken());
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}
	
	private static void print(LinkedListNode<Integer> temp)
	{
		while(temp != null){
			System.out.print(temp.data + " ") ;
			temp = temp.next;
		}
		System.out.println();
    }
    
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
        // Write your code here
        ArrayList<LinkedListNode<Integer>> outputArrayList = new ArrayList<>();

        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();

        pendingNodes.enqueue(root);
        pendingNodes.enqueue(null);
        // outputArrayList.add(LLNode2);
        // outputArrayList.add(null);

        LinkedList<Integer> smallLL = new LinkedList<>();

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode=null; 
            
            try{
                frontNode = pendingNodes.dequeue();
            }catch(QueueEmptyException e){
               
            }

            if(frontNode == null){
                if(!pendingNodes.isEmpty()){
                    outputArrayList.add(null);
                    pendingNodes.enqueue(null);
                }
            }
            if(frontNode != null){
                LinkedListNode<Integer> LLNode = new LinkedListNode<>(frontNode.data);
            //    outputArrayList.add(LLNode);
                smallLL.add(LLNode);
                if(frontNode.left != null){
                    pendingNodes.enqueue(frontNode.left);
                }
                if(frontNode.right != null){
                    pendingNodes.enqueue(frontNode.right);
                }
               
               
           }
            
           

        }

        return outputArrayList;
    }
	
	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		ArrayList<LinkedListNode<Integer>> output = constructLinkedListForEachLevel(root);
		if(output!=null)
		{
			for(LinkedListNode<Integer> head : output){
				print(head);
				
			}
		}
	}
	
}
