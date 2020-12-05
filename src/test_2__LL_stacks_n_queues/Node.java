package test_2__LL_stacks_n_queues;

public class Node<T>{
	T data;
	Node<T> next; //reference is Node type
	//next is only going to refer the next which is also T type
	
	Node(T data){
		this.data = data;
		next = null;
	}
}
