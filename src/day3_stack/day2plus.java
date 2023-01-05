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
		
//		System.out.println("����Ϊ"+lianbiao.length());
//		
//		//�ҵ�������k��
//		int k=1;
//		System.out.printf("������%d����",k);
//		System.out.println(lianbiao.getNode(k));
//		
//		//����ķ�ת��
//		lianbiao.reverse();
//		
//		//��β��ͷ��ӡ����
//		lianbiao.reverseexposition();
//		lianbiao.exposition();
		
		System.out.println(node0.compareTo(node01));
		System.out.println("�ϲ�������Ӣ��");
		Lianbiao lian2=new Lianbiao();
		
		
		lian2.add(node01);
		lian2.add(node03);
		lian2.add(node04);;
		
		Lianbiao lian3=new Lianbiao();
		lian3=merge(lianbiao,lian2);
		lian3.exposition();
	}
//�ϲ�����Ȼ����
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
	
	//��β��ͷ��ӡ���������ƻ�����Ľṹ��
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
			System.out.println("����Ϊ��");
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
	
	//����ķ�ת,��Ϊ�������ǵ���ģ���Ūͨ����������Ľ�βһ����ǰ���ã����Ǵ�ǰ������á�
	public void reverse() {
		Node reverseNode =new Node(0,"","","");
	    if(head.next==null) {
	    	System.out.println("����Ϊ��");
	    	return;
	    }
	    Node temp=head.next;
	    while(true) {
	    	
	    	if(temp==null) {
	    		break;
	    	}
	    	Node Temp=temp;//Tempȥ�����µ������أ�
	    	temp=temp.next;//temp���������ƶ�
	    	Temp.next=reverseNode.next;//ԭ������Ľṹ�����˸ı�
	    	reverseNode.next=Temp;
	    }
	    head.next=reverseNode.next;
	}
	//������k��
	public Node getNode(int k) {
		int length=length();
		if(k>length) {
			System.out.println("̫���ˣ�������");
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
			System.out.println("����Ϊ��");
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
	Node next;//ע��������next,��Ҳ��һ���ڵ㣬������Ҫע�⸳ֵ���⣬������һ������ȥָ�����������Ǹ�ֵ��
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
