package day3_stack;

import java.util.Objects;
import java.util.Stack;

public class day2plus {
	public static void main(String[]args) {
		Node node0=new Node(0,"liwang","handsome","pingpang");
		Node node01=new Node(1,"liwang","handsome","pingpang");
		Node node02=new Node(2,"liwang","handsome","pingpang");
		Node node03=new Node(3,"liwang","handsome","pingpang");
		Node node04=new Node(4,"liwang","handsome","pingpang");
		Node node05=new Node(5,"liwang","handsome","pingpang");
		Node node06=new Node(6,"liwang","handsome","pingpang");
		
		Lianbiao lianbiao=new Lianbiao();
		lianbiao.add(node0);
		lianbiao.add(node02);
		lianbiao.add(node05);
		lianbiao.add(node06);
		
		lianbiao.exposition();
		
//		System.out.println("长度为"+lianbiao.length());
//		
//		//找到倒数第k个
//		int k=1;
//		System.out.printf("倒数第%d个是",k);
//		System.out.println(lianbiao.getNode(k));
//		
//		//链表的反转：
//		lianbiao.reverse();
//		
//		//从尾到头打印链表
//		lianbiao.reverseexposition();
//		lianbiao.exposition();
		
		System.out.println(node0.compareTo(node01));
		System.out.println("合并两连的英雄");
		Lianbiao lian2=new Lianbiao();
		
		
		lian2.add(node01);
		lian2.add(node03);
		lian2.add(node04);;
		
		Lianbiao lian3=new Lianbiao();
		lian3=merge(lianbiao,lian2);
		lian3.exposition();
	}
//合并后仍然有序
public static Lianbiao merge(Lianbiao l1,Lianbiao l2) {
	Lianbiao l3=new Lianbiao();
    Node n1 = l1.head.next;
    Node n2 = l2.head.next;
    Node n3 = l3.head;
    while(n1!=null&&n2!=null) {
    	if(n1.compareTo(n2)==1) {
    		n3.next = n2;
    		n3 = n3.next;
    		n2=n2.next;
    	}else if(n1.compareTo(n2)==-1) {
    		n3.next = n1;
    		n3 = n3.next;
    		n1 = n1.next;
    	}else {
    		n3.next = n1;
    		n3 = n3.next;
    		n3.next = n2;
    		n3 = n3.next;
    		n1 = n1.next;
    		n2 = n2.next;
    	}
    }
    while(n1 != null) {
    	n3.next = n1;
		n3 = n3.next;
		n1 = n1.next;
    }
    while(n2 != null) {
    	n3.next = n2;
		n3 = n3.next;
		n2=n2.next;
    }
	return l3;
}
}
class Lianbiao{
	Node head=new Node(0,"","","");
	
	public void add(Node node) {
		Node temp=head;
		while(true) {
			if(temp.next==null) {
				break;
			}
			temp=temp.next;
		}
		temp.next=node;
	}
	
	//从尾到头打印链表（不能破坏链表的结构）
	public void reverseexposition() {
		Stack<Node>stack=new Stack<>();
	    Node temp=head.next;
	    while(temp != null) {
	    	stack.push(temp);
	    	temp=temp.next;
	    }
	    while(stack.size() != 0) {
	    	System.out.println(stack.pop());
	    }
	}
	public void exposition() {
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
	   Node temp=head.next;
	   while(true) {
		   System.out.println(temp);
		   if(temp.next==null) {
			   break;
		   }
		   temp=temp.next;
	   }
	}
	
	//链表的反转,因为单链表是单向的，不弄通过到达链表的结尾一次往前放置，而是从前往后放置。
	public void reverse() {
		Node reverseNode =new Node(0,"","","");
	    if(head.next==null) {
	    	System.out.println("链表为空");
	    	return;
	    }
	    Node temp=head.next;
	    while(true) {
	    	
	    	if(temp==null) {
	    		break;
	    	}
	    	Node Temp=temp;//Temp去连到新的链表重，
	    	temp=temp.next;//temp继续往后移动
	    	Temp.next=reverseNode.next;//原先链表的结构发生了改变
	    	reverseNode.next=Temp;
	    }
	    head.next=reverseNode.next;
	}
	//倒数第k个
	public Node getNode(int k) {
		int length=length();
		if(k>length) {
			System.out.println("太大了，超过了");
			return null;
		}
		Node temp=head;
		int n=length-k+1;
		while(n!=0) {
			temp=temp.next;
			n--;
		}
		return temp;
	}
	public int length() {
		int length=0;
		if(head.next==null) {
			System.out.println("链表为空");
			return 0;
		}
	   Node temp=head.next;
	   while(true) {
		   length++;
		   if(temp.next==null) {
			   break;
		   }
		   temp=temp.next;
	   }
	   return length;
	}
}
class Node implements Comparable{
	int no;
	String name;
	String nickname;
	String hobby;
	Node next;//注意理解这个next,他也是一个节点，这里需要注意赋值问题，并不是一个东西去指向它，他就是赋值。
	public Node(int no, String name, String nickname, String hobby) {
		super();
		this.no = no;
		this.name = name;
		this.nickname = nickname;
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + ", nickname=" + nickname + ", hobby=" + hobby + "]";
	}

	@Override
	public int compareTo(Object o) {
		Node n=(Node)o;
		if(this.no>n.no) {
			return 1;
		}else if(n.no == this.no) {
			return 0;
		}else {
		    return -1;
		}
	}
}
