import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class check_if_a_BinaryTree {
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

    public static class Pair<T>{
        // boolean leftOutput;
        // boolean rightOutput;
        boolean result;
        T Node;
    }
    public static Pair<BinaryTreeNode<Integer>> isBSTPair(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair<BinaryTreeNode<Integer>> outputPair = new Pair<>();
            outputPair.Node = null;
            // outputPair.leftOutput = true;
            // outputPair.rightOutput = true;
            outputPair.result = true;
            return outputPair;
        }
        Pair<BinaryTreeNode<Integer>> outputPair = new Pair<>();
        Pair<BinaryTreeNode<Integer>> leftOutputPair = isBSTPair(root.left);
        Pair<BinaryTreeNode<Integer>> rightOutputPair = isBSTPair(root.right);

        outputPair.result = leftOutputPair.result && rightOutputPair.result;
        outputPair.Node = root;

        if(leftOutputPair.Node != null){
            if(root.data < leftOutputPair.Node.data ){
                outputPair.result=false;
            }
           
        }
        if( rightOutputPair.Node!=null) {
            if(root.data > rightOutputPair.Node.data){
                outputPair.result = false;
            }
        }
        
       

        

        return outputPair;
        
    }
    
    public static boolean isBST(BinaryTreeNode<Integer> root) {

		
        if(root == null){
            return true;
        }
        Pair<BinaryTreeNode<Integer>> outputPair  = isBSTPair(root);
        
        return outputPair.result;
       
      


    }
    
    public static int getMin(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data, Math.min(getMin(root.left),getMin(root.right)));
    }

    public static int getMax(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(getMax(root.left),getMax(root.right)));
    }

    public static boolean isBSTL(BinaryTreeNode<Integer> root){
        if(root == null){
            return true;
        }

        int leftMax = getMax(root.left);
        int rightMin = getMin(root.right);

        if(leftMax > root.data){
            return false;
        }
        if(root.data > rightMin){
            return false;
        }

        boolean leftOutput = isBSTL(root.left);
        boolean rightOutput = isBSTL(root.right);

        return leftOutput && rightOutput;
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();

        boolean ans = isBST(root);
        
        System.out.println(ans);

	}
}
