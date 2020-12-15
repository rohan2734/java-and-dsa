package trees_files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class second_largest {
    
    public static class QueueEmptyException extends Exception {

        /**
         *
         */
        private static final long serialVersionUID = 1077169921419675904L;
    }
    
    public static class QueueUsingLL<T> {
    
        public static class Node<T> {
            T data;
            Node<T> next;
            Node(T data){
                this.data = data;
            }
        }
        
        private Node<T> head;
        private Node<T> tail;
        private int size = 0;
    
        public int size(){
            return size;
        }
    
        public boolean isEmpty(){
            if(size == 0){
                return true;
            }
            return false;
        }
    
        public T front() throws QueueEmptyException{
            if(size == 0){
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }
    
            return head.data;
        }
    
    
        public void enqueue(T element){
            Node<T> newNode = new Node<T>(element);
    
            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
    
            size++;
        }
    
        public T dequeue() throws QueueEmptyException{
            if(head == null){
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }
            if(head == tail){
                tail = null;
            }
            T temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
    }
    
    public static  class TreeNode<T> {
            T data;
            ArrayList<TreeNode<T>> children;
    
            TreeNode(T data){
                this.data = data;
                children = new ArrayList<TreeNode<T>>();
            }
        }
    
        static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.enqueue(childNode);
					currentNode.children.add(childNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
    }

    public static TreeNode<Integer> findSecondLargest3(TreeNode<Integer> root){

                  if(root.children.size() == 0){
                      return null;
                  }
                Queue<TreeNode<Integer>> queue = new LinkedList<>();
                TreeNode<Integer> fl=root,sl=null;
                int data = 0;
                queue.add(root);
                //queue.add(null);
        
                while(!queue.isEmpty())
                {
                    TreeNode<Integer> frontNode = queue.poll();
        //             if(frontNode == null){
        //                 if(queue.isEmpty()){
        //                     break;
        //                 }
                       
        //                 queue.add(null);
        //             }
        //             else{
                         for(int i=0;i<frontNode.children.size();i++){
                            queue.add(frontNode.children.get(i));
                        }
                    
                        if(frontNode.data >  data){
                            if(frontNode.data > fl.data){
                                sl = fl;
                                data = fl.data;
                                fl = frontNode;
                            }
                            else if (frontNode.data < fl.data){
                                sl = frontNode;
                                data = sl.data;
                            }
                        }
                        // if(fl.data<frontNode.data)
                        // {    
                        //     sl=fl;
                        //  fl=frontNode;
                        // }
                        // else if(sl.data<frontNode.data){
                        //     sl=frontNode;
                        // }
                        
                    
                    }
                    
                
                return sl;
            
        
            }

    public static class Pair<T>{
        T first;
        T second;
        Pair(T first,T second){
            this.first = first;
            this.second = second;
        }
    }

    public static TreeNode<Integer> findSecondLargest2 (TreeNode<Integer> root){
        return findSecondLargestHelper(root).second;
    }

    public static Pair<TreeNode<Integer>> findSecondLargestHelper(TreeNode<Integer> root){
        Pair<TreeNode<Integer>> output;
        if(root == null){
            output = new Pair<TreeNode<Integer>>(null,null);
            return output;
        }

        output = new Pair<TreeNode<Integer>>(root,null);

        for(TreeNode<Integer> child:root.children){
            Pair<TreeNode<Integer>> childPair = findSecondLargestHelper(child);

            if(childPair.first.data > output.first.data){
                if(childPair.second == null || childPair.second.data < output.first.data ){
                    output.second = output.first;
                    output.first = childPair.first;
                }else{
                    output.first = childPair.first;
                    output.second = childPair.second;
                }
            }else if(childPair.first.data.equals(output.first.data) && childPair.second != null ){
                output.second = childPair.second;
            }else if(output.first.data != childPair.first.data && (output.second == null || childPair.first.data > output.second.data)){
                output.second = childPair.first;
            }
            
        }
        return output;


    }




    
    public static class PairSecondLargest<T>{
        TreeNode<T> Node;
        TreeNode<T> max;
        TreeNode<T> nextMax;
        // int max;
        // int nextN;
    }

    public static PairSecondLargest<Integer> PairSecondLargestFunction(TreeNode<Integer> root){
        if(root == null){
            PairSecondLargest<Integer> output = new PairSecondLargest<>();
            output.Node = null;
            
        }

        PairSecondLargest<Integer> ans = new PairSecondLargest<>();
        ans.Node = root;
        ans.max = root;
        ans.nextMax= null;

        for(TreeNode<Integer> child: root.children){
            PairSecondLargest<Integer> smallAns = PairSecondLargestFunction(child);
           if(smallAns.max.data > ans.max.data){
                TreeNode<Integer> temp= ans.max;
                ans.max = smallAns.max;
              	 // ans = smallAns;
               ans.Node = smallAns.Node;
                if(ans.nextMax == null && smallAns.nextMax == null){
                    ans.nextMax = temp;
                }
                if(ans.nextMax == null && smallAns.nextMax !=null){
                    ans.nextMax = smallAns.nextMax;
                    continue;
                }else if(smallAns.nextMax == null && ans.nextMax!= null){
                    ans.nextMax = temp;
                }else if(ans.nextMax != null && smallAns.nextMax!=null){
                 	
                     ans.nextMax = temp;
                      
                }
               // else if(smallAns.nextMax.data > temp.data ){
               //      ans.nextMax = smallAns.nextMax;
               //  }
               // else if(temp.data > smallAns.nextMax.data){
               //      ans.nextMax = temp;
               //  }
                    //compare temp, smallNext.max,smallNex.next

            }else if(smallAns.max.data < ans.max.data){
                if(ans.nextMax == null && smallAns.nextMax == null){
                    ans.nextMax = smallAns.max;
                }else if(ans.nextMax == null){
                    ans.nextMax = smallAns.max;
                }else if(ans.nextMax.data < smallAns.max.data){
                    ans.nextMax = smallAns.max;
                }
            }
        }
        
        return ans;
    }
    
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        PairSecondLargest<Integer> output = PairSecondLargestFunction(root);
        return output.nextMax;


		// Write your code here

    }

    
    
    public static void main(String[] args) {
		TreeNode<Integer> root =  takeInputLevelWise();
		TreeNode<Integer> ans = findSecondLargest(root);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		} 
	}
}
