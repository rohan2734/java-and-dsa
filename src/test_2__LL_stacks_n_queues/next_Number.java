package test_2__LL_stacks_n_queues;

import java.util.Scanner;

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
	}
}

public class next_Number {

	
	static Scanner s = new Scanner(System.in);

	public static LinkedListNode<Integer> takeInput() {
		LinkedListNode<Integer> head = null, tail = null;
		int data = s.nextInt();
		while(data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static void print(LinkedListNode<Integer> head){
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
	public static LinkedListNode<Integer> reverseLL(LinkedListNode<Integer> head){
		LinkedListNode<Integer> p=head;
		LinkedListNode<Integer> q=null;
		LinkedListNode<Integer> r= null;
		
		while(p!=null){
			q=p;
			p=p.next;
			q.next=r;
			r=q;
		}
		return q;
	}
	
	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
		   LinkedListNode<Integer> temp = head;
		   LinkedListNode<Integer> tempHead = head;
		   if(head == null){
			   return null;
		   }
		  
		   temp = reverseLL(head);
		   tempHead=temp;
		   if(temp.data + 1!=10){
			   temp.data+=1;
			   
			   temp = reverseLL(tempHead);
			   return temp;
			   
		   }
		   
		   
		   		
		   		while(temp!=null){
			   		 if(temp.data + 1 == 10){
						   temp.data = 0;
	//					   temp=temp.next;
						   
						   if(temp.next == null){
							   LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(1);
							   temp.next = newNode;
							   newNode.next = null;
							   
						   }else if(temp.next != null && temp.next.data!=9){
							   temp=temp.next;
							   temp.data+=1;
						   }
	//					   temp=temp.next;
						   
						   
					   }else if(temp == tempHead){
						   temp.data+=1;
					   }
					   temp=temp.next;
		   		}
		  
			  
			   
		   
		   
		   temp = reverseLL(tempHead);
		   return temp;
	}
		
	public static void main(String[] args) {
		
		LinkedListNode<Integer> head = takeInput();
		head = nextLargeNumber(head);
		print(head);
		
	}

}
