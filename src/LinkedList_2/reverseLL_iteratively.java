package LinkedList_2;

import java.util.Scanner;

public class reverseLL_iteratively {
	
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

	public static Node<Integer> reverseLL(Node<Integer> head){
		Node<Integer> p=head;
		Node<Integer> q=null;
		Node<Integer> r= null;
		
		while(p!=null){
			q=p;
			p=p.next;
			q.next=r;
			r=q;
		}
		return q;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		head = reverseLL(head);
		printNodes(head);
	}

}
