import java.util.*;

public class preorder_traversal_binaryTree {
    
    public static void preorderTraversal(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);

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
        BinaryTreeNode<Integer> root = takeInputLeveLWise();;
        preorderTraversal(root);

    }
}
