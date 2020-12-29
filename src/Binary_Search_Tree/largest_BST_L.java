public class largest_BST_L {


/*	Binary Tree Node class
 * 
 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
    }
*/
	public static class isBSTReturn
    {
        int max;
        int min;
        int ht;
        boolean isBST;
        public isBSTReturn(int max, int min,int ht, boolean isBST)
        {
            this.max=max;
            this.min=min;
            this.ht=ht;
            this.isBST=isBST;
            
        }
    }
    static int ht=0;
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) 
    {
		// Write your code here
        
        isBSTReturn ans=isBST(root);
        return ans.ht;
		
	}
    public static isBSTReturn isBST(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            isBSTReturn ans=new isBSTReturn(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
            return  ans;
        }
       isBSTReturn leftAns= isBST(root.left);
        isBSTReturn rightAns=isBST(root.right);
        int min=Math.min(root.data,Math.min(leftAns.min,rightAns.min));
        int max=Math.max(root.data,Math.max(leftAns.max,rightAns.max));
        boolean isBST=true;
        if(!(leftAns.isBST&&leftAns.max<root.data))
        {
            leftAns.isBST=false;
        }
          if(!(rightAns.isBST&&rightAns.min>root.data))
        {
            rightAns.isBST=false;
        }
        
        if(!leftAns.isBST||!rightAns.isBST||root.data<leftAns.max||root.data>rightAns.min){
            if(leftAns.ht>rightAns.ht){
                leftAns.isBST=false;
                return leftAns;
            }else{
                rightAns.isBST=false;
                return rightAns;
            }
        }
        
        // if(!leftAns.isBST)
        // {
        //     isBST=false;
        // }
        // if(!rightAns.isBST)
        // {
        //     isBST=false;
        // }
        // if(isBST)
        // {
           ht=Math.max(leftAns.ht,rightAns.ht)+1;            
        // }
         isBSTReturn ans=new isBSTReturn(max,min,ht,isBST);
           return ans;
        
        
    }
    
    
}

