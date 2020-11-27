package LinkedList_2;

import java.util.Scanner;

public class retainM_deleteN {

	public static Node<Integer> retain_and_delete(Node<Integer> head,int m,int n){
		Node<Integer> temp=head;
		Node<Integer> tempM=head;
		Node<Integer> tempN=head;
        if(m == 0 || head == null){
				return null;
			}
        if(n==0){
            return head;
        }
		int i=0,j=0;
		while(temp!=null){
			i=0;
			// tempM=temp;
			while(i<m-1 && temp!=null){
				temp = temp.next;
				i++;
			}
			if(temp == null){
				return head;
			}
			
			
				// tempM=temp;
				tempN=temp.next;
			
	
			j=0;
			while(j<n && tempN!=null){
				tempN=tempN.next;
				j++;
			}
			// if(tempN==null){
			//    return head;
			// }
			temp.next = tempN;
			temp=tempN;
		}
		
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		Scanner s = new Scanner(System.in);
		int m=s.nextInt();
		int n = s.nextInt();
		head =retain_and_delete(head,m,n);
		printNodes(head);
	}

}
