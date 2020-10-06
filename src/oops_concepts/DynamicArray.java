package oops_concepts;

public class DynamicArray {
	private int data[];
	private int nextIndex;
	
	public DynamicArray() {
		data=new int[5];
		nextIndex=0;
	}
	
	public int size() {
		return nextIndex;
	}
	
	public void add(int element) {
		//System.out.println(nextIndex +" inside class");
		if(nextIndex==data.length) {
			restructure();
		}
		data[nextIndex]=element;
		//System.out.println(nextIndex +":"+ data[nextIndex]);
		nextIndex++;
	}
	
	public void set(int index,int element) {
		if(index>nextIndex) {
			return;
		}
		if(index<nextIndex) {
			data[index]=element;
		}else {
			add(element);
		}
	}
	
	public int get(int index) {
		if(index>=nextIndex) {
			//TODO error out
			return -1;
		}
		System.out.println(index +"inside get" + data[3]);
		return data[index];
	}
	
	public boolean isEmpty() {
		if(nextIndex==0) {
			return true;
		}
		return false;
	}
	
	private void restructure() {
		int temp[]=data;
		data=new int[data.length*2];
		for(int i=0;i>temp.length;i++) {
			data[i]=temp[i];
		}
	}
	
	public int removeLast(){
		if(size()==0) {
			//TODO error out
			return -1;
		}
		int value=data[nextIndex-1];
		data[nextIndex-1]=0;
		nextIndex--;
		return value;
	}
}
