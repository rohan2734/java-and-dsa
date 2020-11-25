package LinkedList_2;

import java.util.Scanner;


public class even_after_odd {

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
	public static void printNodes(Node<Integer> head){
		Node<Integer> temp = head;
		
		while(head != null) {
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
		head=temp;
	}
	
	public static int getLength(Node<Integer> head){
		int len=0;
		while(head !=null){
			len++;
		}
		return len;
	}
	
	public static Node<Integer> evenAfterOdd(Node<Integer> head){
		Node<Integer> oddHead = null;
		Node<Integer> oddTail = null;
		Node<Integer> evenHead = null;
		Node<Integer> evenTail = null;
		if(head == null || head.next == null){
			return head;
		}
		
		while(head !=null){
			if(head.data%2 !=0){
				if(oddHead == null){
					oddHead = head;
					oddTail = head;
				}else{
					oddTail.next=head;
					oddTail=head;
				}	
			}else{
				
				if(evenHead == null){
					evenHead = head;
					evenTail = head;
				}else{
					evenTail.next=head;
					evenTail=head;
				}
			}
			head=head.next;
			
		}
		
		if(oddHead == null){
			return evenHead;
		}else {
			oddTail.next=evenHead;
			
		}
		
		if(evenHead!=null){
			evenTail.next=null;
			
		}
		return oddHead;
		
		 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		head = evenAfterOdd(head);
		printNodes(head);
	}

}
