import java.util.*;

public class check__BST_1 {
    
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

    public static int minimum (BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MAX_VALUE;
        }

        return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
    }

    public static int maximum (BinaryTreeNode<Integer> root){
        if(root  == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
        
    }

    public static boolean isBST(BinaryTreeNode<Integer> root){
        if(root == null){
            return true;
        }
        int leftMax = maximum(root.left);
        int rightMin  = minimum(root.right);

        //assuming, leftMax  <  root,
        // root >= rightMin
        if(root.data <= leftMax){
            return false;
        }
        if(root.data > rightMin){
            return false;
        }

        boolean isLeftBST= isBST(root.left);
        boolean isRightBST = isBST(root.right);
        if(isLeftBST && isRightBST){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();


    }
}
