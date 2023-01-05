package day1_list;

import java.util.Scanner;

//Ŀǰ�������ʹ��һ�ξͲ����ã�û�дﵽ���õ�Ч��
public class Solution{
	public static void main(String[]args) {
		ArrayQueue queue=new ArrayQueue(3);
	    Scanner scanner=new Scanner(System.in);
	    queue.addQueue(1);
	    queue.addQueue(2);
	    queue.addQueue(3);
	    
	   //չʾ
	    queue.showQueue();
	    
	    queue.addQueue(4);
	}
}
//ʹ������ģ����У�
class ArrayQueue{
	private int maxSize;//������������
	private int front;//����ͷ
	private int rear;//����β
	private int[]arr;
	
	public ArrayQueue(int arrMaxSize) {
		this.maxSize=arrMaxSize;
		arr=new  int[maxSize];
		front =-1;//ָ�����ͷ����������front��ָ�����ͷ��ǰһ��λ��
		rear=-1;
	}
	
	//�ж϶����Ƿ�����
	public boolean isFull() {
		return rear==maxSize-1;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return front==rear;
	}
	
	//������ݵ����У�
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("�����������ܼ�������");
			return;
		}
		rear++;
		arr[rear]=n;
	}
	
	//��ȡ���е�����
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("���пգ�����ȡ����");
		}
		front++;
		return arr[front];
	}
	
	//��ʾ���е���������
	public void showQueue() {
	   if(isEmpty()) {
		   System.out.println("���пյģ�û������");
	   }
	   for(int i=0;i<arr.length;i++) {
		   System.out.println(i+" "+arr[i]);
	   }
	}
	//��ʾ���е�ͷ���ݣ�����ȡ������
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("���п�");
		}
		return arr[front+1];
	}
}









