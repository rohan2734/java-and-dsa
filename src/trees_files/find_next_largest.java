import java.util.ArrayList;
import java.util.Scanner;

public class find_next_largest {
    public static class QueueEmptyException extends Exception {

        /**
         *
         */
        private static final long serialVersionUID = -3796360040419604813L;
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

        public static class nextLargest<T> {
            TreeNode<T> root;
            int nextN=-1;
        }
        public static nextLargest<Integer> nextLargestFunction(TreeNode<Integer> root,int n){
            if(root == null){
                nextLargest<Integer> output = new nextLargest<>();
                output.root = null;
                output.nextN = Integer.MIN_VALUE;
                return null;
            }

            // int nextNumber = Integer.MIN_VALUE;
            nextLargest<Integer> ans = new nextLargest<>();
            if(root.data > n){
                ans.nextN = root.data;
            }else{
                ans.nextN = Integer.MAX_VALUE;
            }
            // ans.nextN = root.data ? root.data > n : Integer.MAX_VALUE;
            ans.root = root;
            for(int i=0;i<root.children.size();i++){
                nextLargest<Integer> nextChild = nextLargestFunction(root.children.get(i), n);
                if(nextChild.root.data > n && nextChild.root.data <ans.nextN){
                    ans = nextChild;
                }
            }
            return ans;

        }
        public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		
            // Write your code here
            nextLargest<Integer> outputNextLargestObj = nextLargestFunction(root, n);
            return outputNextLargestObj.root;
    
        }
    public static void main(String[] args) {
            int n = s.nextInt();
        TreeNode<Integer> root =  takeInputLevelWise();

            TreeNode<Integer> ans = findNextLargerNode(root, n);
            if(ans == null){
                System.out.println(Integer.MIN_VALUE);
            }else{
                System.out.println(ans.data);
            }

        }
    }

