import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BST_from_sorted_array {
    public static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void preOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
    }
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int si,int ei){
		if(si > ei){
            return null;
        }
        int rootIndex = (si+ei)/2;
        int rootData = arr[rootIndex];
        
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        int leftStart =si;
        int leftEnd = rootIndex -1;
        int rightStart = rootIndex +1;
        int rightEnd = ei;
        root.left = SortedArrayToBST(arr, leftStart,leftEnd);
        root.right = SortedArrayToBST(arr, rightStart,rightEnd);

        return root;

    }

    public static BinaryTreeNode<Integer> SortedArrayToBST(int arr[],int len){
        if(len == 0){
            return null;
        }
        return SortedArrayToBST(arr, 0,len-1);
    }

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int arr[] = new int[len];
		if(len>0)
		{
			st = new StringTokenizer(br.readLine());
		}
		for(int i=0;i<len;i++)
		{
		    arr[i]=Integer.parseInt(st.nextToken());
		}
		BinaryTreeNode<Integer> ans = SortedArrayToBST(arr, len);
		preOrder(ans);
	}

   


}
