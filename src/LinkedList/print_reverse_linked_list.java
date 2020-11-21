package LinkedList;

import java.util.Scanner;

public class print_reverse_linked_list {
	
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
	

	public static void printReverse(Node<Integer> head) {
		//Your code goes here
		Node<Integer> temp = head;
		Node<Integer> tail = head;
		
        if(head == null){
            return;
        }
		while(temp.next !=null){
			temp=temp.next;
		}
		tail= temp;
        
		
		while(head != tail){
			temp=head;
			while(temp.next !=tail){
				temp=temp.next;
			}
			System.out.print(tail.data+" ");
			tail=temp;
		}
		System.out.print(head.data +" ");
	}
	
	public static void printReverseByRecursion(Node<Integer> head){
		if(head == null){
			return;
		}
		
		printReverseByRecursion(head.next);
		System.out.print(head.data +" ");
		return;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> head = takeInput();
		printReverseByRecursion(head);
//		printReverse(head);
	}

}
