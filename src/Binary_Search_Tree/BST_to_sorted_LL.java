import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BST_to_sorted_LL {
    
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

    public static class Pair<T>{
        LinkedListNode<T> head;
        LinkedListNode<T> tail;
    }

    public static Pair<Integer> constructLinkedListPair(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair<Integer> output = new Pair<>();
            output.head = null;
            output.tail=null;
            return output;
        }

        Pair<Integer> leftList = constructLinkedListPair(root.left);
        Pair<Integer> rightList = constructLinkedListPair(root.right);

        Pair<Integer> newPair = new Pair<>();
        LinkedListNode<Integer> newNode = new LinkedListNode<>(root.data);

        if(leftList.tail!=null){
            leftList.tail.next=newNode;
        }
        newNode.next =rightList.head;
        if(leftList.head == null){
            // leftList.head = newNode;
            newPair.head = newNode;
        }else{
            newPair.head = leftList.head;
        }

        if(rightList.tail == null){
            newPair.tail = newNode;
        }else{
            newPair.tail=rightList.tail;
        }

        return newPair;

    }
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
       
        if(root == null){
            return null;
        }
        return constructLinkedListPair(root).head;


	}

	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		LinkedListNode<Integer> head = constructLinkedList(root);
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
