package LinkedList;

import java.util.Scanner;

public class delete_an_element {

	/**
	 * @param args
	 */
	
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
	
	public static Node<Integer> deleteElement(Node<Integer> head,int pos){
		Node<Integer> temp = head;
		int i=0;
		while(i<pos-1 && temp!=null){
			temp = temp.next;
			i++;
		}
		if(pos == 0){
			head = temp.next;
		}
        if(temp != null){
            temp.next = temp.next.next;
        }
		
		
		return head;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		
		//10 20 30 40 50
		//0   1  2  3  4
		head=deleteElement(head,0);
		printNodes(head);
	}

}
