package day3_doublelist;

public class doublelist {
	public static void main(String[]args) {
		
		Node node0 = new Node(0,"liwang");
		Node node3 = new Node(3,"liyuchun");
		Node node5 = new Node(5,"xuwei");
		
		List list = new List();
		
		//�����β��
		list.add(node0);
		list.add(node3);
		list.add(node5);
		
		Node node1 = new Node(1,"liwang");
		Node node4 = new Node(4,"liyuchun");
		Node node6 = new Node(6,"xuwei");
		//����no����
		list.Add(node1);
		list.Add(node4);
		list.Add(node6);
		
		Node node2 = new Node(2,"zhangyuezhen");
		//ɾ��
		list.delete(node1);
		list.delete(node2);
		
		list.exposition();
	}

}

class List {
	Node head = new Node(0, "");
	
	//ɾ��
	public void delete(Node node) {
		Node temp = head;
		while(true) {
			if(node == temp) {
				if(temp.next != null) {
				temp.pre.next = temp.next;
				temp.next.pre = temp.pre;
				break;
				}
				else {
					temp = null;
				}
			}
			if(temp == null) {
				System.out.println("û������ڵ㣬�޷�ɾ��");
				return;
			}
			temp = temp.next;
		}
	}
	//���
	public void add(Node node) {
		Node temp = head;
		
		while(true) {
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = node;
		node.pre = temp;
	}
	
	//�������
	public void Add(Node node) {
		Node temp = head;
		while(true) {
			if(node.no < temp.no) {//˫������������ĸ�˳����ֵ��˼��һ�µ�
				node.next = temp;
				temp.pre.next = node;
				node.pre = temp.pre;
				temp.pre = node;
				break;
			}
			if(temp.next == null) {
				temp.next = node;
				node.pre = temp;
				break;
			}
			temp = temp.next;
		}
	}
	//չʾ
	public void exposition() {
		Node temp = head.next;
		
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
}

class Node {
	int no;
	String name;
	Node next;
	Node pre;

	public Node(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public String toString() {
		return no+" "+name;
	}
}