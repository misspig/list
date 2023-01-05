package day3_doublelist;

public class doublelist {
	public static void main(String[]args) {
		
		Node node0 = new Node(0,"liwang");
		Node node3 = new Node(3,"liyuchun");
		Node node5 = new Node(5,"xuwei");
		
		List list = new List();
		
		//添加在尾部
		list.add(node0);
		list.add(node3);
		list.add(node5);
		
		Node node1 = new Node(1,"liwang");
		Node node4 = new Node(4,"liyuchun");
		Node node6 = new Node(6,"xuwei");
		//按照no插入
		list.Add(node1);
		list.Add(node4);
		list.Add(node6);
		
		Node node2 = new Node(2,"zhangyuezhen");
		//删除
		list.delete(node1);
		list.delete(node2);
		
		list.exposition();
	}

}

class List {
	Node head = new Node(0, "");
	
	//删除
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
				System.out.println("没有这个节点，无法删除");
				return;
			}
			temp = temp.next;
		}
	}
	//添加
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
	
	//按序添加
	public void Add(Node node) {
		Node temp = head;
		while(true) {
			if(node.no < temp.no) {//双向链表下面的四个顺序是值得思考一下的
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
	//展示
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