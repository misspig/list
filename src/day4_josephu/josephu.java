package day4_josephu;

public class josephu {

	public static void main(String[]args) {
		
		CircleList list = new CircleList();
		
		list.showBoy();

	    list.addBoy(5);
		
		//list.showBoy();
		
		list.find(3);
	}
}

//创建环形单向链表
class CircleList{
	//创建一个first节点，当前还没有编号
	private Boy first = null;
	
	//寻找小孩，每次数到num就出列
	public void find(int num) {
		Boy temp = first;
		int n=num;
		while(true) {
			n--;
			if(n == 1) {//他这个和单链表的删除很像，其实唯一的不同就是我是循环的，所以我也是得先找到前一个结点
				             //又因为第一个也要报数，所以线进行n--找到1也就是前一个
				System.out.println(temp.getNext().getNo());
				temp.setNext(temp.getNext().getNext());
				n = num;
			}
			if(temp.getNext() == temp) {
				System.out.println(temp.getNo());
				return;
			}
			temp = temp.getNext();
		}
	}
	//添加小孩节点
	public void addBoy(int nums) {
		//我知道长度就可以直接填长度，我是按照顺序添加的，并不是一个一个添加的
		//对nums作一个数据校验
		if(nums<1) {
			System.out.println("数据不正确");
			return; 
		}
		Boy curBoy = null;//辅助指针
		for(int i = 1 ;i<=nums;i++) {
			 //根据编号，创建小孩节点
			Boy boy = new Boy(i);
			//如果是第一个小孩
			if(i == 1) {
				first = boy;
				first.setNext(first);
				curBoy = first;
			}else {
				curBoy.setNext(boy);
				curBoy = curBoy.getNext();
				curBoy.setNext(first);
			}
			
		}
	}
	//遍历链表
	public void showBoy() {
		if(first == null) {
			System.out.println("链表为空");
			return;
		}
		Boy temp = first;
		while(true) {
			System.out.println(temp.getNo());
			if(temp.getNext() == first) {
				break;
			}
			temp = temp.getNext();
		}
	}
}
class Boy{
	private int no;//编号
	private Boy next;//指向下一个节点，默认为null
	public Boy(int no) {
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNext() {
		return next;
	}
	public void setNext(Boy next) {
		this.next = next;
	}
	
}