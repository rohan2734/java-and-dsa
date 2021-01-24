import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Pair_sum_in_a_BSTL {
    
    public static class QueueEmptyException extends Exception {
    }
    
    public static class QueueUsingLL<T> {
    
        public static class Node<T> {
            T data;
            Node<T> next;
    
            Node(T data) {
                this.data = data;
            }
        }
    
        private Node<T> head;
        private Node<T> tail;
        private int size = 0;
    
        public int size() {
            return size;
        }
    
        public boolean isEmpty() {
            if (size == 0) {
                return true;
            }
            return false;
        }
    
        public T front() throws QueueEmptyException {
            if (size == 0) {
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }
    
            return head.data;
        }
    
        public void enqueue(T element) {
            Node<T> newNode = new Node<T>(element);
    
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
    
            size++;
        }
    
        public T dequeue() throws QueueEmptyException {
            if (head == null) {
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }
            if (head == tail) {
                tail = null;
            }
            T temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
    }
    
    public static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    


    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s)
    {
	ArrayList<Integer> arr=new ArrayList<>();
       ArrayList<Integer> arr1 =helper(root,s,arr);
        printhelper(s,arr1);
	}
    private static ArrayList<Integer> helper(BinaryTreeNode<Integer> root,int s,ArrayList<Integer> arr)
    {
        if(root==null)
        {
            return arr;
        }
        helper(root.left,s,arr);
        arr.add(root.data);
        helper(root.right,s,arr);
        return arr;
    }
    private static void printhelper(int s,ArrayList<Integer> arr)
    {
        int i=0;
        int j=arr.size()-1;
        while(i<j)
        {
            
           int p=arr.get(i);
        	int q=arr.get(j);
            if(p+q==s)
            {
                System.out.println(p+" "+q);
                i++;
                j--;
            }
            if(p+q>s)
            {
                
                j--;
            }
            if(p+q<s)
            {   
                i++;
            }
            
        }
    }
}
