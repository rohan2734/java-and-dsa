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
//	
//	public static boolean lectuers_check_palindrome(Node<Integer> head){
//		Node<Integer> temp =head;
//		
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		boolean output = checkPalindrome(head);
		System.out.print(output);
	}

}
