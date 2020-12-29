public class temp {
    // class Value{
// 	int min;
// 	int max;
// 	boolean present;
// 	int h;
// }
// public class Solution{
// 	//Approach 1  
// 	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
// 		//Base Case
// 		if(root == null)
// 			return 0;
// 		if(isBST(root))
// 			return height(root);
// 		else
// 			return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right)); //Rec case
		
// 	}
// 	public static boolean isBST(BinaryTreeNode<Integer> root){
// 			return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
// 	}
// 	public static boolean isBST(BinaryTreeNode<Integer> root, int min,int max){  //Time Complexity : O(n)
// 		if(root == null)
// 			return true;
// 		if(root.data < min || root.data > max)
// 			return false;
// 		else
// 			return isBST(root.left,min,root.data -1) && isBST(root.right,root.data +1,max);
// 	}
// 	public static int height(BinaryTreeNode<Integer> root){
// 		if(root == null)
// 			return 0;
// 		return 1 + Math.max(height(root.left),height(root.right));
// 	}

// 	//Approach 2
// 	public static int largestBSTSubtree_2(BinaryTreeNode<Integer> root) {
// 		return largestBSTSubtree_help(root).h;
// 	}
// 	public static Value largestBSTSubtree_help(BinaryTreeNode<Integer>root){
// 		Value v = new Value();
// 		if(root == null){
// 			v.h = 0;
// 			v.present = true;
// 			v.min = Integer.MAX_VALUE;
// 			v.max = Integer.MIN_VALUE; 
// 			return v;
// 		}
// 		//Rec Case
// 		Value vLeft = largestBSTSubtree_help(root.left);
// 		Value vRight = largestBSTSubtree_help(root.right);
// 		//Small Calculation
// 		v.h = Math.max(vLeft.h,vRight.h);
// 		v.min = Math.min(root.data,Math.min(vLeft.min,vRight.min));
// 	    v.max = Math.max(root.data,Math.max(vLeft.max,vRight.max));
// 		if(vLeft.present && vRight.present){
// 			v.present = true;
// 			if(root.data > vLeft.max  && root.data < vRight.min){
// 				v.h ++;
// 				v.present = true;
// 			}else
// 				v.present = false;		
// 		    return v;
// 		}
// 		v.present = false;
// 		return v;

// 	}
// }
}
