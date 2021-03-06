package LinkedList_2;

import java.util.Scanner;

public class insert_element_recursively {

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
	
	public static Node<Integer> insertElementRecursively(Node<Integer> head,int pos,int element){
		
		if(pos == 0 ){
			Node<Integer> newNode =new  Node<Integer>(element);
			newNode.next = head;
			return newNode;
		}
		if(head == null){
			return head;
		}
		Node<Integer> smallHead = insertElementRecursively(head.next,pos-1,element);
		head.next = smallHead;
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		int pos=0;
		int element=20;
		head =insertElementRecursively(head,pos,element);
		printNodes(head);
	}

}
