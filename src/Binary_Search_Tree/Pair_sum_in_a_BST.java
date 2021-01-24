import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


public class Pair_sum_in_a_BST {
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

    public static Stack<BinaryTreeNode<Integer>> stackLeft = new Stack<>();
    public static Stack<BinaryTreeNode<Integer>> stackRight = new Stack<>();

    public static BinaryTreeNode<Integer> popStackRight(){
        BinaryTreeNode<Integer> topRoot = stackRight.pop();
        return topRoot;
    }

    public static int largestValueInLeftSubTree(BinaryTreeNode<Integer> root,int node){
        if(root == null){
            return node;
        }
        stackRight.push(root);
        node = largestValueInLeftSubTree(root.right, node);

        return node;
    }

    public static void printNodesSumToSHelper(int sum){
        BinaryTreeNode<Integer> stackRightTop =stackRight.pop();
        BinaryTreeNode<Integer> stackLeftTop = stackLeft.pop();
        while()
        if(stackLeftTop.data + stackRightTop.data == sum){
            System.out.println(stackLeftTop + " " + stackRightTop);
            stackRight.pop(); stackLeft.pop();

        }else if(stackLeftTop.data + stackRightTop.data < sum){

        }else{//stackLeftTop + stackRightTop > sum
            popStackRight();
            //add numbers just less than this number 
            //find maximum value in left subtree of this number
            //maximum value will be the right most value of the right subtree 
            if(stackRightTop.left != null){
                largestValueInLeftSubTree(stackRightTop.left,0);
            }
        }
    }

    public static void addLeftMost(BinaryTreeNode<Integer> root,int s){
        if(root == null){
            return;
        }

        stackLeft.push(root.data);
        addLeftMost(root.left, s);
    }

    public static void addRightMost(BinaryTreeNode<Integer> root,int s){
        if(root == null){
            return;
        }

       stackRight.push(root.data);
       addRightMost(root.right, s);
    }
    
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        // Write your code here
        if(root == null){
            return;
        }
        addRightMost(root, s);
        addLeftMost(root,s);

        printNodesSumToSHelper( s);

    }
    
	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		int s = Integer.parseInt(br.readLine());
		printNodesSumToS(root,s);
	}
}
