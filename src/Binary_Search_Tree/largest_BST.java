import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class largest_BST {
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

    public static class Pair<T>{
        int max;
        int min;
        boolean isBST;
        int height;
    } 

    public static Pair<Integer> largestBSTSubtreeHelper(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair<Integer> outputPair = new Pair<>();
            
            outputPair.max = Integer.MIN_VALUE; //left
            outputPair.min  = Integer.MAX_VALUE; //right
            outputPair.isBST = true;
            outputPair.height=0;
            return outputPair;
        }
        Pair<Integer> outputPair = new Pair<>();
           
        Pair<Integer> leftOutputPair = largestBSTSubtreeHelper(root.left);
        Pair<Integer> rightOutputPair = largestBSTSubtreeHelper(root.right);

        int leftMax = leftOutputPair.max;
        int rightMin = rightOutputPair.min;

        outputPair.isBST = leftOutputPair.isBST && rightOutputPair.isBST;    
        //left <= root
        //root < right

    
        if(leftMax > root.data || rightMin <= root.data){ 
            outputPair.isBST = false;
        }

        
        leftMax = Math.max(Math.max(leftOutputPair.max,rightOutputPair.max), root.data);
        rightMin = Math.min(Math.min(rightOutputPair.min,leftOutputPair.min), root.data);

        outputPair.min=rightMin;
        outputPair.max=leftMax;


        if(outputPair.isBST){
            outputPair.height = Math.max(leftOutputPair.height, rightOutputPair.height)+1;
        }else{
            outputPair.height = Math.max(leftOutputPair.height, rightOutputPair.height);
        }

        return outputPair;
    }
    
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		if(root == null){
            return 1;
        }

        return Math.max(largestBSTSubtreeHelper(root.left).height,largestBSTSubtreeHelper(root.right).height);
	}

	
	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		System.out.println(largestBSTSubtree(root));
	}
    
}
