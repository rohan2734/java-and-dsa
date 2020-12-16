import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class construct_tree_from_pre_and_inorder {
    
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

    private static Pair takeInput() throws NumberFormatException, IOException {
    	int n = Integer.parseInt(br.readLine().trim());

    	int pre[] = new int[n];
    	int in[] = new int[n];

    	String[] preOrder = br.readLine().trim().split(" ");
    	String[] inOrder = br.readLine().trim().split(" ");


    	for (int i = 0; i < n; i++) {
    		pre[i] = Integer.parseInt(preOrder[i].trim());
    		in[i] = Integer.parseInt(inOrder[i].trim());
    	}

    	return new Pair(pre, in);

    }

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
        pendingNodes.add(null);

		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

        
	        if (frontNode == null) {
	            System.out.println();

	            if (!pendingNodes.isEmpty()) {
	                pendingNodes.add(null);
	            }

	        } else {
	        	System.out.print(frontNode.data + " ");

	            if (frontNode.left != null) {
	                pendingNodes.add(frontNode.left);
	            } 

	            if (frontNode.right != null) {
	                pendingNodes.add(frontNode.right);
	            } 
	        }

		}
		
	}
    
    public static class Pair {
        int[] preOrder;
        int[] inOrder;
    
        public Pair(int[] preOrder, int[] inOrder) {
            this.preOrder = preOrder;
            this.inOrder = inOrder;
        }
    
    }

    
    public static BinaryTreeNode<Integer> buildTreeL(int preOrder[],int inOrder[],int inStart,int inEnd,int preStart,int preEnd){
        if(inStart > inEnd){
            return null;
        }
        int rootData = preOrder[preStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

        int rootIndex = -1;
        for(int i=inStart;i<= inEnd; i++){
            if(inOrder[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        if(rootIndex == -1){
            return null;
        }

        int leftInS = inStart;
        int leftInE = rootIndex-1;
        int leftPreS = preStart+1;
        //leftPreE - letPreS = leftInE- leftInS
        int leftPreE = leftPreS + leftInE - leftInE;

        int rightInS = rootIndex+1;
        int rightInE = inEnd;
        int rightPreS = leftPreE+1;
        int rightPreE = preEnd;

        root.left = buildTreeL(inOrder, preOrder, leftInS, leftInE, leftPreS, leftPreE);
        root.right = buildTreeL(inOrder, preOrder, rightInS, rightInE, rightPreS, rightPreE);
        
        return root;
    }

    public static BinaryTreeNode<Integer> buildTreeL(int preOrder[],int inOrder[]){
        return buildTreeL(inOrder, preOrder,0,inOrder.length-1,0,preOrder.length-1);
    }

    public static int findNode(int[] inOrder,int nodeData,int inS,int inE){
        
        for(int i=inS;i<= inE;i++){
            if(inOrder[i] == nodeData){
                return i;
            }
        }
        return 0;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder,int inStart,int inEnd, int preStart, int preEnd){
        

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preOrder[preStart]);
       

        int index = findNode(inOrder, root.data,inStart,inEnd);

        int length = index - inStart;
        if(length == 0){
            return root;
        }
        root.left  = buildTree(preOrder, inOrder,inStart,index-1,preStart+1,preStart+length);
        root.right = buildTree(preOrder, inOrder,index+1,inEnd,length+1,preEnd);

        return root;

    }

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        //Your code goes here

        BinaryTreeNode<Integer> root = buildTree(preOrder,inOrder,0,inOrder.length-1,0,preOrder.length-1 );
        return root;
	}
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        Pair input = takeInput();

    	int[] preOrder = input.preOrder;
    	int[] inOrder = input.inOrder;

    	BinaryTreeNode<Integer> root = buildTreeL(preOrder, inOrder);

    	printLevelWise(root);
    }
}
