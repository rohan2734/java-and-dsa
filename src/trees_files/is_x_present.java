import java.util.ArrayList;
import java.util.Scanner;

public class is_x_present {
    public static class QueueEmptyException extends Exception {

        /**
         *
         */
        private static final long serialVersionUID = -5351865188990355660L;
        
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
    
      public static class TreeNode<T> {
            T data;
            ArrayList<TreeNode<T>> children;
    
            TreeNode(T data){
                this.data = data;
                children = new ArrayList<TreeNode<T>>();
            }
        }
        static Scanner s = new Scanner(System.in);

        public static TreeNode<Integer> takeInputLevelWise(){
            QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of nodes that are entered themselves but their children aren't added yet
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

        public static boolean checkIfContainsX(TreeNode<Integer> root,int x){

            // Write your code here	
            if(root == null){
                return false;
            }	

            if(root.data == x){
                return true;
            }
            boolean result = false;
            for(int i=0;i<root.children.size();i++){
                boolean smallResult = checkIfContainsX(root.children.get(i),x);
                if(smallResult == true){
                    result = true;
                    break;
                }
            }
            return result;
                
        }
    
    
        public static void main(String[] args) {
    
    
            int x = s.nextInt();
            TreeNode<Integer> root =  takeInputLevelWise();
            System.out.println(checkIfContainsX(root, x));
    
        }
    
}
