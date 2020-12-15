import java.util.*;

public class is_node_present {


    public static boolean isNodePresent(BinaryTreeNode<Integer> root,int x){
        if(root == null){
           
            return false;
        }
        if(root.data == x){
           
            return true;
        }
        boolean leftOutput = isNodePresent(root.left, x);
        boolean rightOutput = isNodePresent(root.right, x);

        return leftOutput || rightOutput;
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
        Scanner s = new Scanner (System.in);
        System.out.println("Enter the value of x");
        int x = s.nextInt();
        
        boolean output = isNodePresent(root,x);
        System.out.println(output);
    }
}
