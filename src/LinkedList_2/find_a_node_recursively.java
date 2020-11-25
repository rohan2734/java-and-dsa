package LinkedList_2;

import java.util.Scanner;

public class find_a_node_recursively {

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
	public static int findNodeRec(Node<Integer> head,int n, int index){
		if(head == null){
			return -1;
		}
		if(head.data.equals(n)){
			return index;
		}
		
		return findNodeRec(head.next,n,index+1);

	}
	
	public static int lecturers_findNodeRec(Node<Integer> head,int n){
		if(head == null){
			return -1;
		}
		if(head.data.equals(n)){
			return 0;
		}
		
		int smallAns = findNodeRec(head.next,n);
		
		if(smallAns == -1){
			return -1;
		}
		
		return smallAns + 1;
	}
	public static int findNodeRec(Node<Integer> head, int n){
		int index=0;
		return findNodeRec( head,  n,index);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		int n=20;
		int index= findNodeRec(head,n);
		System.out.print(index);
		
	}

}
