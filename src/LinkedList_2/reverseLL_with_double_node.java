package LinkedList_2;

import java.util.Scanner;

public class reverseLL_with_double_node {

	public static DoubleNode reverseLLBetter(Node<Integer> head){
		if(head == null || head.next == null){
			DoubleNode ans= new DoubleNode();
			ans.head  = head;
			ans.tail=head;
			return ans;
		}
		
		 DoubleNode smallAns = reverseLLBetter(head.next);
		 smallAns.tail.next = head;
//		 smallAns.tail=head;
		 head.next = null;
		 
		DoubleNode ans = new DoubleNode();
		ans.head = smallAns.head;
		ans.tail=head;
		
		return ans; 
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		DoubleNode ans = reverseLLBetter(head);
		printNodes(ans.head);
	}

}
//we can also shift the DoubleNode class here, without public keyword
//since we can have only one public class ,where the class and file names are same
