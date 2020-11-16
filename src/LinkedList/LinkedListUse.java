package LinkedList;

public class LinkedListUse {
	
	public static void printNodes(Node<Integer> head){
		Node<Integer> temp = head;
		
		while(head != null) {
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
		head=temp;
		while(head != null) {
			System.out.print(head.data +" ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Node<Integer> node1= new Node<Integer>(10);
		Node<Integer> node2= new Node<Integer>(20);
		Node<Integer> node3= new Node<Integer>(30);
		
		node1.next = node2;
		node2.next = node3;
		
		Node<Integer> head = node1;
		
		
		printNodes(head);
		//Node<Integer> 
		
		
	}

}
