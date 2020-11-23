package LinkedList_2;

import java.util.Scanner;


public class merge_sort_by_recursion {

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
	
	 public static Node<Integer> midPoint(Node<Integer> head) {
	        //Your code goes here
		 Node<Integer> slow=head;
		 Node<Integer> fast=head;
	        if(head == null || head.next == null){
	            return head;
	        } 
	        while(fast.next != null && fast != null){
	            fast=fast.next.next;
	            if(fast==null){
	                return slow;
	            }
	            slow=slow.next;
	            
	        }
	        return slow;
	        

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
	 
	 public static Node<Integer> mergeSortInLinkedList(Node<Integer> head1,Node<Integer> head2){
			Node<Integer> head3= null;
			Node<Integer> tail3= null;
			
			
			while(head1!=null && head2!= null){
				if(head1.data < head2.data){
					if(tail3==null){
						head3=head1;
						tail3=head1;
					}else{
						tail3.next=head1;
						tail3=head1;
					}
					head1=head1.next;
				}else{
					if(tail3==null){
						head3=head2;
						tail3=head2;
						
					}else{
						tail3.next=head2;
						tail3=head2;
					}
					head2=head2.next;
				}
			}
			if(head1!=null){
				tail3.next = head1; 
			}else{
				tail3.next= head2;
			}
			
			return head3;
			
			
			
		}
	
	public static Node<Integer> merge_sort(Node<Integer> head){
		if(head == null || head.next == null){
			return head;
		}
		
		Node<Integer> head1=head;//first half
		Node<Integer> head2=midPoint(head); //second half
		Node<Integer> temp=head2.next;
		if(head2!=null){
			head2.next = null;
			head2=temp;
		}
		
		head1=merge_sort(head1);
		head2=merge_sort(head2);
		
		Node<Integer> head3= null;
		head3=mergeSortInLinkedList(head1,head2);
		
		return head3;
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		head= merge_sort(head);
		printNodes(head);
		
	}

}
