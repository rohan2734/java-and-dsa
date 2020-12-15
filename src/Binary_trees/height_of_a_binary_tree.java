import java.util.*;


public class height_of_a_binary_tree {

    public static int height(BinaryTreeNode<Integer> root ){
        if(root == null){
            return 0;
        }
        int countA=0;
        int countB =0;

        countA = height(root.left);
        countB = height(root.right);

        int maxHeight = 1;
        if(countA > countB){
            maxHeight+= countA;
        }else{
            maxHeight += countB;
        }

        return maxHeight;

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
        int output = height(root);
        System.out.println(output);
    }
}
