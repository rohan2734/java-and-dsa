public class check__BST_2 {

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

    public static class Pair<T,V>{
        public T first; //2nd pair, first one is min 
        public V second; //2nd pair , second is max
    } 
    public static  Pair<Boolean,Pair<Integer,Integer>> isBST2(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair<Boolean,Pair<Integer,Integer>> output = new Pair<>();
            output.first = true;
            output.second = new Pair<Integer,Integer>();
            output.second.first = Integer.MAX_VALUE; //for min
            output.second.second = Integer.MIN_VALUE; //for max
            return output;
        }

        Pair<Boolean,Pair<Integer,Integer>> leftOutput = isBST2(root.left);
        Pair<Boolean,Pair<Integer,Integer>> rightOutput = isBST2(root.right);
        int min = Math.min(root.data,Math.min(leftOutput.second.first,rightOutput.second.first));

        int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));

        boolean isBST = (root.data > leftOutput.second.second) 
        && (root.data <= rightOutput.second.first)
        && leftOutput.first && rightOutput.first ;
        //leftOutput.first && rightOutput.first;
        
        Pair<Boolean,Pair<Integer,Integer>> output = new Pair<>();
        output.first = isBST;
        output.second = new Pair<Integer,Integer>();
        output.second.first = min;
        output.second.second = max;
        return output;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();

    }
}
