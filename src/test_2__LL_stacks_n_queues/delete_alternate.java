package test_2__LL_stacks_n_queues;

import java.util.Scanner;

public class delete_alternate {
	
	public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.setData(data);
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }

	static Scanner s = new Scanner(System.in);
	
	 public static void deleteAlternateNodes(Node<Integer> head) {
	        
	        Node<Integer> temp = head;
	        while(temp!=null){
	        	Node<Integer> nextTemp = temp.next;
	        	if(nextTemp!=null){
	        		temp.next = nextTemp.next;
	        	}
	        	temp=temp.next;
	        }
	 }
	 
	  public static Node<Integer> input() {
	        int data = s.nextInt();

	        Node<Integer> head = null;
	        Node<Integer> tail = null;
	        while (data!=-1) {
	            Node<Integer> newNode = new Node<Integer>(data);
	            if (head == null) {
	                head = newNode;
	                tail = newNode;
	            } else {
	                tail.next = newNode;
	                tail = newNode;
	            }
	            data = s.nextInt();
	        }
	        return head;
	    }

    public static void main(String[] args) {

        Node<Integer> list = input();
        deleteAlternateNodes(list);
        print(list);
    }

    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.next;
        }
    }

  

}
