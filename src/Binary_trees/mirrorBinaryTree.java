import java.util.*;


public class mirrorBinaryTree {
    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        pendingNodes.enqueue(null);

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode ;
            try{
                frontNode = pendingNodes.dequeue();
               
                if(frontNode == null && !pendingNodes.isEmpty()){
                    pendingNodes.enqueue(null);
                }
                
            }catch(QueueEmptyException e){
                return;
            }
            if(frontNode !=null){
                System.out.print(frontNode.data +" ");

                BinaryTreeNode<Integer> swap = frontNode.right;
                frontNode.right = frontNode.left;
                frontNode.left = swap;

                if(frontNode != null && frontNode.left != null || frontNode.right != null){

                    pendingNodes.enqueue(frontNode.left);
                    pendingNodes.enqueue(frontNode.right);
    
                }
            }
               
            
                
                
                if(frontNode == null){
                    System.out.println();
                }
               
        }
        
    }
    public static void mirrorBinaryTree2(BinaryTreeNode<Integer> root){
		//Your code goes here
        
         if(root == null){
            return;
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        // pendingNodes.enqueue(null);

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode ;
            try{
                frontNode = pendingNodes.dequeue();
               
                // if(frontNode == null && !pendingNodes.isEmpty()){
                //     pendingNodes.enqueue(null);
                // }
                
            }catch(QueueEmptyException e){
                return;
            }
            if(frontNode !=null){
                // System.out.print(frontNode.data +" ");

                BinaryTreeNode<Integer> swap = frontNode.right;
                frontNode.right = frontNode.left;
                frontNode.left = swap;

                if( frontNode.left != null || frontNode.right != null){

                    pendingNodes.enqueue(frontNode.left);
                    pendingNodes.enqueue(frontNode.right);
    
                }
            }
               
            
                
                
                // if(frontNode == null){
                //     System.out.println();
                // }
               
        }
	}

    public static BinaryTreeNode<Integer> takeInputLeveLWise(){
        Scanner s = new Scanner(System.in);
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();

        System.out.println("Enter root data");
        int rootData = s.nextInt();
        
        if(rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front;
            try{
                front = pendingNodes.dequeue(); 
            }catch(QueueEmptyException e){
                return null;
            }

            System.out.println("Enter left child of " + front.data);
            int leftChild = s.nextInt();
            if(leftChild != -1){
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
                pendingNodes.enqueue(child);
                front.left = child;
            }

            System.out.println("Enter right child of " + front.data);
            int rightChild = s.nextInt();
            if(rightChild != -1){
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);
                pendingNodes.enqueue(child);
                front.right = child;
            }    
        }

        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLeveLWise();
        // root = mirrorBinaryTree(root);
        // printBinaryTree(root);
        mirrorBinaryTree(root);
    }
}
