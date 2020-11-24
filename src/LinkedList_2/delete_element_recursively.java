package LinkedList_2;

import java.util.Scanner;

public class delete_element_recursively {

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
	
	public static Node<Integer> deleteElementRecursively(Node<Integer> head ,int pos){
		if(head == null){
			return head;
		}
        if(pos == 0){
//			Node<Integer> temp=head;
		   head=head.next;
//		   temp.next=null;
		   return head;
		}
		
		
		LinkedListNode<Integer>smallHead = deleteNodeRec(head.next,pos-1);
        // if(head!=null){
        //     head.next = smallHead;
        // }
        head.next = smallHead;
		
		return head;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		int pos=1;
		head =deleteElementRecursively(head,pos);
		printNodes(head);
	}

}
