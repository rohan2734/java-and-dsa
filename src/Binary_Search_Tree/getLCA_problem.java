import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class getLCA_problem {
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

    public static class Pair{
        int minLCA;
        boolean foundA;
        boolean foundB;
    } 

    public static BinaryTreeNode<Integer> getLCAHelperL(BinaryTreeNode<Integer> root,int a,int b){
        if(root == null){
            return null;
        }

        if(root.data == a|| root.data == b){
            return root;
        }

        BinaryTreeNode<Integer> leftLCA = getLCAHelperL(root.left,a,b);
        BinaryTreeNode<Integer> rightLCA  = getLCAHelperL(root.right,a,b);

        if((leftLCA!=null) && (rightLCA!=null)){
            return root;
        }

        if(leftLCA!= null){
            return leftLCA;
        }

        return rightLCA;
    }

    public static int getLCA_L(BinaryTreeNode<Integer> root,int a ,int b){
        BinaryTreeNode<Integer> node = getLCAHelperL(root, a, b);
        if(node!=null){
            return node.data;
        }else{
            return -1;
        }
    }

    public static Pair getLCAHelper(BinaryTreeNode<Integer> root , int a,int b){
        if(root == null){
            Pair outputPair = new Pair();
            outputPair.minLCA=-1;
            outputPair.foundA=false;
            outputPair.foundB=false;

            return outputPair;
        }

        Pair outputPair = new Pair();

        Pair leftOutput = getLCAHelper(root.left, a, b);
        Pair rightOutput = getLCAHelper(root.right,a,b);

        if(leftOutput.minLCA == -1 && rightOutput.minLCA == -1){
            if(root.data == a){
                outputPair.foundA = true;
            }else{
                outputPair.foundA = leftOutput.foundA || rightOutput.foundA;
            }
            if(root.data == b){
                outputPair.foundB = true;
            }else{
                outputPair.foundB = leftOutput.foundB || rightOutput.foundB;
            }
            // outputPair.foundA = leftOutput.foundA || rightOutput.foundA;
            // outputPair.foundB = leftOutput.foundB || rightOutput.foundB;

            if(outputPair.foundA && outputPair.foundB ){
                outputPair.minLCA = root.data;
            }else{
                outputPair.minLCA=-1;
            }

            return outputPair;
        }else if(leftOutput.minLCA != -1 && rightOutput.minLCA != -1){
            outputPair.minLCA = Math.min(leftOutput.minLCA, rightOutput.minLCA);
            outputPair.foundA = outputPair.foundB = true;

            return outputPair;
        }else if(leftOutput.minLCA != -1){
            outputPair.minLCA = leftOutput.minLCA;
            outputPair.foundA = outputPair.foundB = true;

            return outputPair;
        }else if(rightOutput.minLCA != -1){
           

            outputPair.minLCA = rightOutput.minLCA;
            outputPair.foundA = outputPair.foundB = true;

            return outputPair;
        }
        return outputPair;
    }
    
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if(root == null){
            return -1;
        }

        return getLCAHelper(root, a, b).minLCA;

		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
        String[] strNums = br.readLine().trim().split(" ");
        int a = Integer.parseInt(strNums[0]);
        int b = Integer.parseInt(strNums[1]);

		int h = getLCA(root, a, b);

		System.out.println(h);
	}
       
}
