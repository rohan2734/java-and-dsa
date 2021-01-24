import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zig_Zag_tree {
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
    
    public static void printZigZag(BinaryTreeNode<Integer> root){

        Stack<BinaryTreeNode<Integer>> stack1 = new Stack<>();
        Stack<BinaryTreeNode<Integer>> stack2 = new Stack<>();

        stack1.add(root);
        while(!(stack1.isEmpty() && stack2.isEmpty())){
            while(!stack1.isEmpty()){
                BinaryTreeNode<Integer> frontNode = stack1.pop();
                System.out.print(frontNode.data +" ");
                if(frontNode.left != null){
                    stack2.add(frontNode.left);
                }
                if(frontNode.right != null){
                    stack2.add(frontNode.right);
                }
                
                // stack2.add(frontNode.right);
            }
            System.out.println();
            while(!stack2.isEmpty()){
                BinaryTreeNode<Integer> frontNode = stack2.pop();
                System.out.print(frontNode.data +" ");
                if(frontNode.right!=null){
                    stack1.add(frontNode.right);
                }
                if(frontNode.left!=null){
                    stack1.add(frontNode.left);
                }
                
                // stack1.add(frontNode.left);
            }
            System.out.println();
        }
    }
    
    public static void printZigZagLec(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        Stack<BinaryTreeNode<Integer>>  stack = new Stack<>();
        pendingNodes.enqueue(root);
        int level=1;

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode ;
            try{
                frontNode = pendingNodes.dequeue();
            }catch(QueueEmptyException e){
                return;
            }
            System.out.print(frontNode.data +" ");

            if(level%2!=0){
                if(frontNode.left!=null){
                    stack.add(frontNode.left);
                }
                if(frontNode.right!=null){
                    stack.add(frontNode.right);
                }
            }else{
                if(frontNode.right!=null){
                    stack.add(frontNode.right);
                }
                if(frontNode.left != null){
                    stack.add(frontNode.left);
                }
            }

            if(pendingNodes.isEmpty()){
                while(!stack.isEmpty()){
                    pendingNodes.enqueue(stack.pop());
                }
                System.out.println();
                level++;
            }
        }
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();

        // printZigZag(root);
        printZigZagLec(root);
        

	}
}
