package LinkedList;

import java.util.Scanner;

public class append_n_to_first {
	
	public static int  getLength(Node<Integer> head){
		 int len = 0;
	        while(head !=null){
	            len+=1;
	            head= head.next;
	        }
	        return len;
	}

	public static Node<Integer> appendLastNtoFirst(Node<Integer> head,int pos){
		Node<Integer> temp = head;
		Node<Integer> tempHead = head;
		Node<Integer> tempTail = head;
		
		int i=0;
		int len = getLength(head);
		// System.out.println(len);
        if(pos == 0 || pos > len){
            return head;
        }
		while(i< len - pos-1){
			temp = temp.next;
			i++;
		}
		
		tempHead = temp.next;
		tempTail = temp;
		temp =temp.next;
		tempTail.next=null;
		
		
		while(temp.next != null){
			temp=temp.next;
		}
		temp.next=head;
		
		
		return tempHead;
		
	}
	public static Node<Integer> lecturers_appendLastNtoFirst(Node<Integer> head, int n){
		if(n==0 || head == null){
			return head;
		}
		
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		Node<Integer> initialHead = head;
		
		for(int i=0;i<n;i++){
			fast=fast.next;
		}
		while(fast.next !=null){
			slow=slow.next;
			fast=fast.next;
		}
		
		Node<Integer> temp = slow.next;
		slow.next = null;
		fast.next= initialHead;
		head=temp;
		
		return head;
		
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
//				Node<Integer> temp = head;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
//		printNodes(head);
		Scanner s = new Scanner(System.in);
		int pos = s.nextInt();
		head = appendLastNtoFirst(head,pos);
		printNodes(head);
	}

}
