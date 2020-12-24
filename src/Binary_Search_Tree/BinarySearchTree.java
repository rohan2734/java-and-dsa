public class BinarySearchTree {

    private BinaryTreeNode<Integer> root;

    private int smallest=Integer.MAX_VALUE;
    private BinaryTreeNode<Integer> smallestNode = new BinaryTreeNode<Integer>(smallest);

    private int largest=Integer.MIN_VALUE;
    private BinaryTreeNode<Integer> largestNode = new BinaryTreeNode<Integer>(largest);
    


    private BinaryTreeNode<Integer> insertDataHelper(int data,BinaryTreeNode<Integer> root){
        if(root == null ){
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
            return newNode;
        }
        if(data < root.data){
            root.left = insertDataHelper(data, root.left);
        }
        if(data> root.data){
            root.right = insertDataHelper(data, root.right);
        }

        return root;
    }
    public void insertData(int data){
        root= insertDataHelper(data,root);
    }

    private BinaryTreeNode<Integer> getSmallest(BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }

        if(smallestNode.data  > root.data){
            smallestNode = root;
        }
        root.left=getSmallest(root.left);
        root.right = getSmallest(root.right);

        return root;
    }

    private BinaryTreeNode<Integer> deleteSmallest(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> inputNode){
        if(root == null){
            return null;
        }
        if(root.right == inputNode){
            root.right = null;
            return root;
        }else if(root.left == inputNode){
            root.left = null;
            return root;
        } 
        root.left = deleteSmallest(root.left, inputNode);
        root.right = deleteSmallest(root.right, inputNode);

        return root;
    }

    private BinaryTreeNode<Integer> getLargest(BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }
        if(largestNode.data < root.data){
            largestNode = root;
        }
        root.left = getLargest(root.left);
        root.right = getLargest(root.right);

        return root;
    }
    public BinaryTreeNode<Integer> deleteDataHelper(int data,BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }

        if(root.data == data){
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left != null && root.right!= null){
               BinaryTreeNode<Integer> temp = getSmallest(root);
               temp.right = root.right;
               deleteSmallest(root, smallestNode);
               root.left=deleteDataHelper(data, root.left);
               return root;
            }
            if(root.left != null){
                return root.left;
            }
            if(root.right!=null){
                return root.right;
            }
           
            // root = null;
            // BinaryTreeNode<Integer> temp = new BinaryTreeNode<Integer>(data)
            // return root;
        }
        if(data > root.data){
            root.right= deleteDataHelper(data, root.right);
        }
        if(data < root.data){
            root.left= deleteDataHelper(data, root.left);
        }

        return null;

    }
    public void deleteData(int data){
        root = deleteDataHelper(data,root);
    }

    private boolean hasDataHelper( int data, BinaryTreeNode<Integer> root){
        if(root == null){
            return false;
        }

        if(root.data == data){
            return true;
        }else if(data > root.data){
            
            return  hasDataHelper(data,root.right);
        }else{
            return hasDataHelper(data,root.left);
        }
    }


    public boolean hasData(int data){
        return hasDataHelper(data, root);
    }

    public void printTreeHelper(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        System.out.print(root.data +":L:" + root.left.data+",R:" + root.right.data);
        printTreeHelper(root.left);
        printTreeHelper(root.right);
    }

    public void printTree(){
        printTreeHelper(root);
    }
}
