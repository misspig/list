package day2;

public class day2 {
	public static void main(String[]args) {
		Node node0=new Node(0,"liwang","handsome","pingpang");
		Node node01=new Node(1,"liwang","handsome","pingpang");
		Node node02=new Node(2,"liwang","handsome","pingpang");
		Node node03=new Node(3,"liwang","handsome","pingpang");
		
		Lianbiao lianbiao=new Lianbiao();
		lianbiao.add(node0);
		lianbiao.add(node01);
		lianbiao.add(node02);
		lianbiao.add(node03);
		
		lianbiao.exposition();
		
		System.out.println("����Ϊ"+lianbiao.length());
		
		//�ҵ�������k��
		int k=1;
		System.out.printf("������%d����",k);
		System.out.println(lianbiao.getNode(k));
		
		//����ķ�ת��
		lianbiao.reverse();
		
		lianbiao.exposition();
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
class Node{
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
	
	
}
