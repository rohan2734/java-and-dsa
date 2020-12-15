import java.util.Scanner;

public class BinaryTreeUse {

    public static void printTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String toBePrinted  = root.data + "";
        if(root.left != null){
            toBePrinted += "L:" + root.left.data;
        }
        if(root.right != null){
            toBePrinted += "R:" + root.right.data;
        }

        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
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

    public static void PrintLevelWise (BinaryTreeNode<Integer> root){
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();

        pendingNodes.enqueue(root);
        // System.out.print(root.data +":");

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode; 
            
            try{
                frontNode = pendingNodes.dequeue();
                System.out.print(frontNode.data +":");
            }catch(QueueEmptyException e){
                return;
            }
            if(frontNode.left !=null){
                pendingNodes.enqueue(frontNode.left);
                System.out.print("L:" + frontNode.left.data+",");
            }
            if(frontNode.left == null){
                System.out.print("L:" + "-1"+",");
            }
            if(frontNode.right!=null){
                pendingNodes.enqueue(frontNode.right);
                System.out.print("R:" + frontNode.right.data);
            }
            if(frontNode.right == null){
                System.out.print("R:" + "-1");
            }


            System.out.println();

        }

    }

    public static BinaryTreeNode<Integer> takeInput(Scanner s){
        int rootData;
        System.out.println("Enter root data");
        rootData = s.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeInput(s);
        root.right = takeInput(s);

        return root;
    }

    



    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // BinaryTreeNode<Integer> root = takeInput(s);
        BinaryTreeNode<Integer> root = takeInputLeveLWise();
        // printTree(root);
        PrintLevelWise(root);
        // s.close();
        // BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        // BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
        // root.left = node1;
        // BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
        // root.right = node2;
    }
}
