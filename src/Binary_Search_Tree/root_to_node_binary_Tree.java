import java.util.ArrayList;
import java.util.Scanner;

public class root_to_node_binary_Tree {


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

 
    public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root,int data){
        if(root == null){
            return null;
        }

        if(root.data == data){
            ArrayList output = new ArrayList<>();
            output.add(root.data);
            return output;
        }

        ArrayList<Integer> leftOutput = getRootToNodePath(root.left, data);
        if(leftOutput != null){
            leftOutput.add(root.data);
            return leftOutput;
        }
        ArrayList<Integer> rightOutput = getRootToNodePath(root.right, data);
        if(rightOutput != null){
            rightOutput.add(root.data);
            return rightOutput;
        }

        return null;


    
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLeveLWise();
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        getRootToNodePath(root, data);

    }
}
