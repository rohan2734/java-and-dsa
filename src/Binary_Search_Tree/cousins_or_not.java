import java.util.Scanner;

public class cousins_or_not {
    public static class QueueEmptyException extends Exception {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;
    }
    
    public static class Node<T> {
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
        }
    }
    
    public static class QueueUsingLL<T> {
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
        }
    }

    static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
    }

    public static class Pair {
        boolean isFound;
        int height;
    }

    public static Pair isCousinHelper(BinaryTreeNode<Integer> root,int height,int p){
        if(root == null){
            Pair outputPair = new Pair();
            outputPair.isFound=false;
            outputPair.height=height-1;

            return outputPair;
        }

        if(root.data == p ){
            Pair outputPair = new Pair();
            outputPair.isFound=true;
            outputPair.height=height;
            
            return outputPair;
        }

        Pair leftPair = isCousinHelper(root.left, height+1, p);
        Pair rightPair = isCousinHelper(root.right, height+1, p);

        Pair oPair = new Pair();
        oPair.isFound = leftPair.isFound || rightPair.isFound;
        if(leftPair.isFound == true){
            oPair.height=leftPair.height;
        }else if(rightPair.isFound == true){
            oPair.height=rightPair.height;
        }else{
            oPair.height=height;
        }

        return oPair;


        
        
    }

    public static boolean isSibling(BinaryTreeNode<Integer> root, int p ,int q){
        if(root == null){
            return false;
        }

        if(root.left!= null && root.right != null){
            if(root.left.data == p && root.right.data == q){
                return true;
            }else if(root.left.data == q && root.right.data == p){
                return true;
            }else{
                return isSibling(root.left, p, q) || isSibling(root.right, p, q);
            }
        }

        if(root.right!=null){
            return isSibling(root.right, p, q);
        }else{
            return isSibling(root.left, p, q);
        }


    }
    public static int depth(BinaryTreeNode<Integer> root,int node){
        if(root == null){
            return -1;
        }
        if(root.data == node){
            return 0;
        }

        int left = depth(root.left, node);
        if(left != -1 ){
            return left+1;
        }

        int right = depth(root.right, node);
        if(right != -1){
            return right + 1;
        }

        return -1;
    }
    
    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        // Write your code here
        // return isCousinHelper(root,0,p).height == isCousinHelper(root, 0, q).height;
        if(root == null){
            return false;
        }

        return depth(root,p) == depth(root,q) && !(isSibling(root,p,q));
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		int p = s.nextInt();
		int q = s.nextInt();
		System.out.println(isCousin(root, p, q));
	}
    
}
