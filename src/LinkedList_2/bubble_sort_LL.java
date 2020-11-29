package LinkedList_2;

import java.util.Scanner;


public class bubble_sort_LL {
	
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
	
	public static int getLength(Node<Integer> head){
		int len=0;
		while(head !=null){
			len++;
		}
		return len;
	}
	
	public static Node<Integer> lecturers_bubbleSort(Node<Integer> head) {
		//Your code goes here
		Node<Integer> temp=head,prev=null;
		int i=0;
		int j=0;
		
		int length=getLength(head);
		
		while(i<length && temp!=null){
			temp=head;
			prev=null;
			
			
			j=0;
			
			while(j<length-i-1 ){
				if(temp.data>temp.next.data){
					Node<Integer> nextT=temp.next;
					if(prev== null){
						temp.next=nextT.next;
						nextT.next=temp;
						prev = nextT;
                        head = prev;
                        j++;
					}else{
						temp.next = nextT.next;
						nextT.next = temp;
                        prev.next = nextT;
                        prev = nextT;
                        j++;
					}
				}else{
                    prev= temp;
				temp=temp.next;
                    j++;
                }
				
				
				
			}
			
			i++;
		}
		
		return head;
	}
	
	
	public static Node<Integer> bubbleSortLL_Iterative(Node<Integer> head){
		
		Node<Integer> temp=head,prev=null,current=null,nextT=null;
		int i=0;
		int j=0;
		
		int length=getLength(head);
		
		while(i<length-1 && temp!=null){
			temp=head;
			prev=head;
			current=temp;
			nextT=temp.next;
			j=0;
			
			while(j<length-i-1 ){
				if(current.data>nextT.data){
					if(current==head){
						head=nextT;
						current.next=nextT.next;
						nextT.next=current;
						head=current;
					}else{
						prev.next=nextT;
						current.next=nextT.next;
						nextT.next=current;
					}
				}
				prev=current;
				current=current.next;
				nextT=nextT.next;
				j++;
				
			}
			temp=temp.next;
			i++;
		}
		
		return head;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		head=bubbleSortLL_Iterative(head);
		printNodes(head);
		
	}

}
 