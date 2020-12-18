package BinaryTrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class check_isBalanced {    
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

    public static boolean checkBalanced(BinaryTreeNode<Integer> root) {

        if(root == null || root.right == null && root.left == null){
            return true;
        }
        if(root.left == null && root.right !=null || root.left != null && root.right == null){
            return false;
        }

        boolean isLeftBalanced = checkBalanced(root.left);
        boolean isRightBalanced = checkBalanced(root.right);

        return isLeftBalanced && isRightBalanced;
		
    }

    public static class Pair<T>{
        public boolean outputBool;
        public T height;

    }

    public static Pair<Integer> checkBalancedLHelper(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair outputPair = new Pair<>();
            outputPair.outputBool = true;
            outputPair.height =0;
            return outputPair;
        }

        Pair outPair = new Pair<>();

        Pair<Integer> leftSubTree = checkBalancedLHelper(root.left);
        Pair<Integer> rightSubTree = checkBalancedLHelper(root.right);
         
         int leftSubTreeHeight =0;
          int rightSubTreeHeight=0;
         if(leftSubTree!=null){
              leftSubTreeHeight = leftSubTree.height;
         }
         if(rightSubTree!=null){
             rightSubTreeHeight =rightSubTree.height;
         }
        
         
//         if(leftSubTreeHeight == rightSubTreeHeight){
//             if(leftSubTree == null&& rightSubTree ==null){
//                 outPair.outputBool = true;
//                 outPair.height = 1;
//                 return outPair;
//             }
            
//             outPair.outputBool = true;
//             outPair.height = Math.max(leftSubTreeHeight,rightSubTreeHeight) + 1;
//             return outPair;
//         }else{
//             int height = leftSubTreeHeight + 1;
//             outPair.outputBool = false;
//             outPair.height = height;
//              return outPair;
//         }
         if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) <= 1){
              outPair.outputBool = leftSubTree.outputBool && rightSubTree.outputBool;
                outPair.height = Math.max(leftSubTreeHeight,rightSubTreeHeight) + 1;
                return outPair;
         }
         // else if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1){
         else{
            int height = leftSubTreeHeight + 1;
            outPair.outputBool = false;
            outPair.height = height;
             return outPair;
        }

    }

    public static boolean checkBalancedL(BinaryTreeNode<Integer> root){
        return checkBalancedLHelper(root).outputBool;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();

        // System.out.println(checkBalanced(root));
        System.out.println(checkBalancedL(root));
	}
}
