import java.util.ArrayList;
import java.util.Scanner;

public class max_sum_node {

    public static class QueueEmptyException extends Exception {

        /**
         *
         */
        private static final long serialVersionUID = 2333978362388438908L;
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
    
    public static  class TreeNode<T> {
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
//		System.out.println("Enter root Data");
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
//				System.out.println("Enter number of children of "+currentNode.data);
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
//					System.out.println("Enter "+ i + "th child of " + currentNode.data);
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

    public static class PairRootAndSum {
        private TreeNode<Integer> root=null;
        private int sum=0;

        PairRootAndSum(TreeNode<Integer> root,int sum){
            this.root = root;
            this.sum =sum;
        }
        public TreeNode<Integer> getRoot() {
            return root;
        }
        public int getSum() {
            return sum;
        }
        public void setRoot(TreeNode<Integer> root) {
            this.root = root;
        }
        public void setSum(int sum) {
            this.sum = sum;
        }

    }
    
    public static max_sum_node.PairRootAndSum PairRootAndSumFunction(TreeNode<Integer> root){
        if(root == null){
            PairRootAndSum outputRoot = new PairRootAndSum(null,0);
            // outputRoot.root = null;
            // outputRoot.sum = Integer.MIN_VALUE;
            return outputRoot;
        }
        PairRootAndSum outputRoot = new PairRootAndSum(root,root.data);
        
        int rootSum= outputRoot.getSum();


        for(int i=0;i<outputRoot.getRoot().children.size();i++){
             // PairRootAndSum child = PairRootAndSumFunction(outputRoot.getRoot().children.get(i));
             TreeNode<Integer> child = outputRoot.getRoot().children.get(i);
             // rootSum += child.root.data;
            rootSum += child.data;  
        }
        // System.out.println(outputRoot.getRoot().data+" "+rootSum);
        outputRoot.setSum(rootSum);

        for(int i=0;i<root.children.size();i++){
            PairRootAndSum child = PairRootAndSumFunction(root.children.get(i));
            if(child.getSum() > outputRoot.getSum()){
                // outputRoot.setRoot(child.getRoot());
                // outputRoot.setSum(child.getSum());
                outputRoot=child;
            }
        }

        return outputRoot;



    }
    
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        PairRootAndSum outputRootPair = PairRootAndSumFunction(root);
        TreeNode<Integer> outputRoot = outputRootPair.getRoot();
        return outputRoot;

    }

    static class MaxNodePair<T>{
        TreeNode<T> node;
        int sum;
    }

    public static TreeNode<Integer> maxSumNode2(TreeNode<Integer> root){
        return maxSumNodeHelper(root).node;
    }

    public static MaxNodePair<Integer> maxSumNodeHelper(TreeNode<Integer> root){
        if(root == null){
            MaxNodePair<Integer> pair = new MaxNodePair<>();
            pair.node = null;
            pair.sum = Integer.MIN_VALUE;
            return pair;
        }

        int sum =root.data;
        for(TreeNode<Integer> child : root.children){
            sum+=child.data;
        }
        MaxNodePair<Integer> ans  = new MaxNodePair<>();
        ans.node = root;
        ans.sum =sum;
        for(TreeNode<Integer> child : root.children){
            MaxNodePair<Integer> childAns = maxSumNodeHelper(child);
            if(childAns.sum > ans.sum){
                ans = childAns;
            }
        }
        return ans;
    }
     
    public static void main(String[] args) {
        TreeNode<Integer> root =  takeInputLevelWise();
		TreeNode<Integer> ans = maxSumNode(root);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		} 
    }
}
