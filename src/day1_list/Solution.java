package day1_list;

import java.util.Scanner;

//目前这个数据使用一次就不能用，没有达到复用的效果
public class Solution{
	public static void main(String[]args) {
		ArrayQueue queue=new ArrayQueue(3);
	    Scanner scanner=new Scanner(System.in);
	    queue.addQueue(1);
	    queue.addQueue(2);
	    queue.addQueue(3);
	    
	   //展示
	    queue.showQueue();
	    
	    queue.addQueue(4);
	}
}
//使用数组模拟队列：
class ArrayQueue{
	private int maxSize;//数组的最大容量
	private int front;//队列头
	private int rear;//队列尾
	private int[]arr;
	
	public ArrayQueue(int arrMaxSize) {
		this.maxSize=arrMaxSize;
		arr=new  int[maxSize];
		front =-1;//指向队列头部，分析出front是指向队列头的前一个位置
		rear=-1;
	}
	
	//判断队列是否满：
	public boolean isFull() {
		return rear==maxSize-1;
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return front==rear;
	}
	
	//添加数据到队列：
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("队列满，不能加入数据");
			return;
		}
		rear++;
		arr[rear]=n;
	}
	
	//获取队列的数据
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空，不能取数据");
		}
		front++;
		return arr[front];
	}
	
	//显示队列的所有数据
	public void showQueue() {
	   if(isEmpty()) {
		   System.out.println("队列空的，没有数据");
	   }
	   for(int i=0;i<arr.length;i++) {
		   System.out.println(i+" "+arr[i]);
	   }
	}
	//显示队列的头数据，不出取出数据
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空");
		}
		return arr[front+1];
	}
}









