import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class replace_sum_with_greater_nodes {
    public static class QueueEmptyException extends Exception {
    }
    
    public static class QueueUsingLL<T> {
    
        public static class Node<T> {
            T data;
            Node<T> next;
    
            Node(T data) {
                this.data = data;
            }
        }
    
        private Node<T> head;
        private Node<T> tail;
        private int size = 0;
    
        public int size() {
            return size;
        }
    
        public boolean isEmpty() {
            if (size == 0) {
                return true;
            }
            return false;
        }
    
        public T front() throws QueueEmptyException {
            if (size == 0) {
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }
    
            return head.data;
        }
    
        public void enqueue(T element) {
            Node<T> newNode = new Node<T>(element);
    
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
    
            size++;
        }
    
        public T dequeue() throws QueueEmptyException {
            if (head == null) {
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }
            if (head == tail) {
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

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static BinaryTreeNode<Integer> takeInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		if (rootData == -1) {
			return null;
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = Integer.parseInt(st.nextToken());
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = Integer.parseInt(st.nextToken());
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}

	public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root) throws QueueEmptyException {
		if (root == null)
			return;
		QueueUsingLL<BinaryTreeNode<Integer>> q = new QueueUsingLL<BinaryTreeNode<Integer>>();
		q.enqueue(root);
		q.enqueue(null);
		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> first = q.front();
			q.dequeue();
			if (first == null) {
				if (q.isEmpty()) {
					break;
				}
				System.out.println();
				q.enqueue(null);
				continue;
			}
			System.out.print(first.data + " ");
			if (first.left != null) {
				q.enqueue(first.left);
			}
			if (first.right != null) {
				q.enqueue(first.right);
			}
		}
    }

    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static int findGreater(int rootData){
        int output = rootData;
        int rootIndex = 0;
        for(int i=0;i< arrayList.size();i++){
            if(rootData == arrayList.get(i)){
                rootIndex=i;
                break;
            }
        }
        for(int i=rootIndex+1;i<arrayList.size();i++){
            output+= arrayList.get(i);
        }

        return output;
    }

    public static void addElementsToArray(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        addElementsToArray(root.left);

        arrayList.add(root.data);

        addElementsToArray(root.right);

    }

    public static void replaceWithLargerNodesSumHelper(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        root.data = findGreater(root.data);

        replaceWithLargerNodesSumHelper(root.left);
        replaceWithLargerNodesSumHelper(root.right);


    }
    
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root){
        if(root == null){
            return ;
        }
        addElementsToArray(root);

        Collections.sort(arrayList);

        replaceWithLargerNodesSumHelper(root);
    }

    public static int replaceWithLargerNodesSumHelperL(BinaryTreeNode<Integer> root ,int sumGreater){
        if(root == null){
           return sumGreater;
        }

        sumGreater = replaceWithLargerNodesSumHelperL(root.right, sumGreater);
        sumGreater+= root.data;
        root.data = sumGreater;
        sumGreater = replaceWithLargerNodesSumHelperL(root.left, sumGreater);

        return sumGreater;
    }

    public static void replaceWithLargerNodesSumL(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        int sum=0;
        replaceWithLargerNodesSumHelperL(root,sum);
    }


	public static void main(String[] args) throws IOException, QueueEmptyException {
		BinaryTreeNode<Integer> root = takeInput();
        // replaceWithLargerNodesSum(root);
        replaceWithLargerNodesSumL(root);
		printLevelWiseAtDiffLevel(root);
	}

}
