import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class print_nodes_at_distance_k {
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

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

    public static int nodesAtDistanceKHelperL(BinaryTreeNode<Integer> root,int node, int k){
        if(root == null){
            return -1;
        }
        if(root.data == node){
            nodesAtDepth(root, k);
        }

        int leftDepth  = nodesAtDistanceKHelperL(root.left, node, k);
        if(leftDepth != -1){
            if(leftDepth + 1 == k){
                System.out.println(root.data);
            }else{
                nodesAtDistanceKHelperL(root.right, node, k - leftDepth -2);
            }

            return leftDepth+1;
        }

        int rightDepth = nodesAtDistanceKHelperL(root.right, node, k);
        if(rightDepth != -1){
            if(rightDepth + 1 == k){
                System.out.println(root.data);
            }else{
                nodesAtDistanceKHelperL(root.left, node, k-rightDepth-2);
            }

            return rightDepth+1;
        }

        return -1;
    }

    public static void nodesAtDepth(BinaryTreeNode<Integer> root,int k){
        if(root == null){
            return;
        }
        if(root.data == k){
            System.out.println(root.data);
        }
        nodesAtDepth(root.left, k);
        nodesAtDepth(root.right, k);
    }
    
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root,int node,int k){
        if(root == null){
            return;
        }

        nodesAtDistanceKHelperL(root, node, k);
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		String[] target_k = br.readLine().trim().split(" ");

		int target = Integer.parseInt(target_k[0].trim());
		int k = Integer.parseInt(target_k[1].trim());

		nodesAtDistanceK(root, target, k);
	}
    

    
}
