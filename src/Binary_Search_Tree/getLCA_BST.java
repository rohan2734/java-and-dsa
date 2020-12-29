import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class getLCA_BST {
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

    public static BinaryTreeNode<Integer> getLCAHelper(BinaryTreeNode<Integer> root,int a,int b){
        if(root == null){
            return null;
        }

        if(root.data == a|| root.data == b){
            return root;
        }
       
        if(a < root.data && b < root.data){
            return getLCAHelper(root.left, a, b);
        } 
      
        if(a > root.data && b> root.data){
            return getLCAHelper(root.right, a, b);
        }

        BinaryTreeNode<Integer> leftOutput=null;
        BinaryTreeNode<Integer> rightOutput=null;


        if((leftOutput!=null) && (rightOutput!=null)){
            return root;
        }

        if(leftOutput!= null){
            return leftOutput;
        }

        return rightOutput;

    }
    
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		return getLCAHelper(root,a,b).data;
	}
    

	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(getLCA(root, a, b));
	}
    
}
