package LinkedList_2;

import java.util.Scanner;

public class reverseK_nodes {

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
	public static Node<Integer> lecturers_kReverse(Node<Integer> head, int k) {
        if(k == 0||k == 1){
            return head;
        }
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> fwd = null;
        
        int cnt = 0;
        
        while(cnt<k&&curr!=null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
            cnt++;
        }
        
        if(fwd!=null){
            head.next = kReverse(fwd,k);
        }
        
        return prev;
	}

	public static Node<Integer> reverseLL(Node<Integer> head,int k){
		Node<Integer> p=head;
		Node<Integer> q=null;
		Node<Integer> r= null;
		int i=0;
		while(i< k && p!=null){
			q=p;
			p=p.next;
			q.next=r;
			r=q;
			i++;
		}
		return q;
	}
	
	public static Node<Integer> reverseK(Node<Integer> head,int k){
		Node<Integer> temp=head,prevStart=temp,prevEnd=null,tempPrevEnd=null,smallHead=null;
		int i=0;
		
		if(k==0 || head == null || head.next== null){
			return head;
		}
		while(temp!=null){
			prevStart = temp;
			tempPrevEnd=prevEnd;
			i=0;
			while(i<k && temp.next != null){
				prevEnd=temp;
				temp=temp.next;
				i++;
			}
			if(temp == null){
				return head;
			}
			smallHead = reverseLL(prevStart,k);
			
			if(prevStart == head){
				head=smallHead;
				prevStart.next = temp;
			}else if(prevEnd == null){
				tempPrevEnd.next = smallHead;
				prevStart.next= null;
			}else{
				tempPrevEnd.next=smallHead;
				prevStart.next=temp;
			}
			
			
		}
		return head;
	}
	
//	public static Node<Integer> recursionReverseK(Node<Integer> head,int k){
//		
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		head  = reverseK(head,k);
		printNodes(head);
		
	}

}
