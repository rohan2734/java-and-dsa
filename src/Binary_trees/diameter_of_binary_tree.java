import java.util.*;

public class diameter_of_binary_tree {
    
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


    public static int diameter(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }

        int option1 = height(root.left) + height(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);
        return Math.max(option1,Math.max(option2, option3));

    }

    public static int height(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int lh= height(root.left);
        int rh = height(root.right);
        return 1+ Math.max(lh, rh);

        //T(n) = 2T(n/2) + k
        //this will result in O(n)
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLeveLWise();
        System.out.println(diameter(root));
    }
}
