package LinkedList_2;

import java.util.Scanner;


public class reverse_LL_by_recursion {
    
	public static Node<Integer> takeInput(){
		Node<Integer> head = null,tail = null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		
		while(data != -1){
			Node<Integer> newNode = new Node<Integer>(data);
			if(head == null){
				head = newNode;
				tail = newNode;
			}else{
				Node<Integer> temp = head;
				tail.next = newNode;
				tail = newNode;
			}
			data=s.nextInt();
		}
		return head;
	}
	
	public static Node<Integer> reverseLinkedListByRecursion(Node<Integer> head){
		 if(head == null||head.next == null){
	            return head;
	        }
	        Node<Integer> newHead = reverseLinkedListByRecursion(head.next);
	        
	        head.next.next=head;
	        head.next = null;
	        return newHead;
	}
	public static void printNodes(Node<Integer> head){
		Node<Integer> temp = head;
		
		while(head != null) {
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
		head=temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		head = reverseLinkedListByRecursion(head);
		printNodes(head);
		
		
	}

}
