import java.util.ArrayList;
import java.util.Scanner;

public class check_if_identical {

    public static class QueueEmptyException extends Exception {

        /**
         *
         */
        private static final long serialVersionUID = -3320583414922257086L;
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
    
    public static   class TreeNode<T> {
            T data;
            ArrayList<TreeNode<T>> children;
    
            TreeNode(T data){
                this.data = data;
                children = new ArrayList<TreeNode<T>>();
            }
        }
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

		// Write your code here
        if(root1 ==  null && root2 == null ){
            return true;
        }else if(root1 == null && root2!=null){
            return false;
        }else if(root1 != null && root2 == null){
            return false;
        }
        
       
        if(root1.children.size() != root2.children.size()){
            return false;
        }
        for(int i=0;i<root1.children.size() ;i++){
            boolean smallResult = checkIdentical(root1.children.get(i),root2.children.get(i));
            if(smallResult == false){
                return false;
            }
            
        }
        
        return true;
    }
    
    static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.enqueue(childNode);
					currentNode.children.add(childNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
	}
    public static void main(String[] args) {
        TreeNode<Integer> root1 =  takeInputLevelWise();
		TreeNode<Integer> root2 = takeInputLevelWise();
		System.out.println(checkIdentical(root1, root2));
    }
}
