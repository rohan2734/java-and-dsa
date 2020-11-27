package LinkedList_2;

import java.util.Scanner;

public class swap_two_nodes {

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
	
	public static Node<Integer> lecturers_swapNodes(Node<Integer> head,int i,int j){
		if(i == j){
			return head;
		}
		
		Node<Integer> currentNode = head,prev = null;
		Node<Integer> firstNode = null,secondNode = null,firstNodePrev = null,secondNodePrev = null;
		
		int pos = 0;
		while(currentNode !=null){
			if(pos == i){
				firstNodePrev = prev;
				firstNode = currentNode;
			}else if(pos == j){
				secondNodePrev = prev;
				secondNode = currentNode;
			}
			
			prev = currentNode;
			currentNode= currentNode.next;
			pos += 1;
		}
		
		if(firstNodePrev != null){
			firstNodePrev.next = secondNode;
		}else{
			head = secondNode;
		}
		
		if(secondNodePrev != null){
			secondNodePrev.next = firstNode;
		}else{
			head = firstNode;
		}
		
		Node<Integer> currentFirstNode = secondNode.next;
		secondNode.next = firstNode.next;
		firstNode.next = currentFirstNode;
		
		return head;
	}
	public static Node<Integer> swapNodes(Node<Integer> head,int m,int n){
		Node<Integer> temp = head;
		Node<Integer> prevN= head;
		Node<Integer> prevM=head;
		Node<Integer> NodeAtM=head;
		Node<Integer> NodeAtN = head;
		Node<Integer> NodeAfterN=head;
		Node<Integer> NodeAfterM = head;
		
		int i=0;
		while(i<m-1 && temp!=null){
			temp=temp.next;
			i++;
		}
		prevM=temp;
		NodeAtM=temp.next;
		NodeAfterM=temp.next.next;
		
		prevN=temp;
		i=0;
		temp=head;
		while(i<n-1 && temp!=null){
			temp=temp.next;
			i++;
		}
		prevN=temp;
		NodeAtN=temp.next;
		if(temp.next!=null){
			NodeAfterN=temp.next.next;
		}else{
			NodeAfterN=null;
		}
		
		//swap
		if(m != n-1){
			prevM.next=NodeAtN;
			NodeAtN.next=NodeAfterM;
			
			prevN.next=NodeAtM;
			NodeAtM.next=NodeAfterN;
		}else{
			prevM.next = NodeAtN;
			NodeAtN.next=NodeAtM;
			NodeAtM.next=NodeAfterN;
		}
		
		
		
		
		return head;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n =  s.nextInt();
		head = swapNodes(head,m,n);
		printNodes(head);
	}

}
