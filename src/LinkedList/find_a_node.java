package LinkedList;

import java.util.Scanner;

public class find_a_node {
	public static int findNode(Node<Integer> head,int n){
		Node<Integer> temp = head;
		
		int i=0;
		while(temp!=null){
			if(temp.data == n){
				
				return i;
			}
			i++;
			temp=temp.next;
		}
		return -1;
		
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
		int n=10;
		int outputIndex = findNode(head,n);
		
		System.out.println(outputIndex);
		
		
		
		
	}

}
