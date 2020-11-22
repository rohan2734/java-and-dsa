package LinkedList;

import java.util.Scanner;

public class check_palindrome_linked_list {
	
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

	public static boolean checkPalindrome(Node<Integer> head){
		Node<Integer> temp =head;
		Node<Integer> tail =head;
		int i=0,j=0;
		boolean output=true;
		if(head == null ||head.next == null){
			return true;
		}
		while(temp.next !=null){
			temp = temp.next;
			j++;
		}
		tail=temp;
		temp=head;
		while(i<j){
			temp=head;
			if(!head.data.equals(tail.data)){
				return false;
			}else{
				j--;
				i++;
				while(temp.next != tail ){
					temp =temp.next;
				}
				tail=temp;
				head = head.next;
			}
		}
		return  output;
		//time complexity n^2
	}
	
	public static int  getLength(Node<Integer> head){
		 int len = 0;
	        while(head !=null){
	            len+=1;
	            head= head.next;
	        }
	        return len;
	}
	
	public static boolean lectuers_check_palindrome(Node<Integer> head1){
		Node<Integer> temp1 =head1;
		Node<Integer> temp2 =null;
		Node<Integer> head2=null;
		
		boolean output = true;
		int i=0;
		int len = getLength(temp1);//head
		if(head1 == null || head1.next == null){
			return true;
		}
		while(i<len/2){
			temp1=temp1.next;
			i++;
		}
		
		head2=temp1.next;
		temp1.next=null;
		
		head2=reverse(head2);
		
		temp1=head1;
		temp2=head2;
		
		while(temp1!=null && temp2!=null){
			if(!temp1.data.equals(temp2.data)){
				return false;
			}else{
				temp1=temp1.next;
				temp2=temp2.next;
			}
		}
		return output;
		
		
	}
	
	public static Node<Integer> reverse(Node<Integer> head){
		Node<Integer> p = head;
		Node<Integer> q = null;
		Node<Integer> r = null;
		
		while(p!=null){
			q=p;
			p=p.next;
			q.next=r;
			r=q;
		}
		
		return q;
		
		
	}
	
	public static Node<Integer> reverseLinkedListByRecursion(Node<Integer> head){
		if(head == null || head.next == null){
			return head;
		}
		Node<Integer> newNode = reverseLinkedListByRecursion(head.next);
		head.next.next = head;
		head.next = null;
		return newNode;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
//		boolean output = checkPalindrome(head);
		boolean output= lectuers_check_palindrome(head);
		System.out.print(output);
	}

}
