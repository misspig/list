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

//�������ε�������
class CircleList{
	//����һ��first�ڵ㣬��ǰ��û�б��
	private Boy first = null;
	
	//Ѱ��С����ÿ������num�ͳ���
	public void find(int num) {
		Boy temp = first;
		int n=num;
		while(true) {
			n--;
			if(n == 1) {//������͵������ɾ��������ʵΨһ�Ĳ�ͬ��������ѭ���ģ�������Ҳ�ǵ����ҵ�ǰһ�����
				             //����Ϊ��һ��ҲҪ�����������߽���n--�ҵ�1Ҳ����ǰһ��
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
	//���С���ڵ�
	public void addBoy(int nums) {
		//��֪�����ȾͿ���ֱ����ȣ����ǰ���˳����ӵģ�������һ��һ����ӵ�
		//��nums��һ������У��
		if(nums<1) {
			System.out.println("���ݲ���ȷ");
			return; 
		}
		Boy curBoy = null;//����ָ��
		for(int i = 1 ;i<=nums;i++) {
			 //���ݱ�ţ�����С���ڵ�
			Boy boy = new Boy(i);
			//����ǵ�һ��С��
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
	//��������
	public void showBoy() {
		if(first == null) {
			System.out.println("����Ϊ��");
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
	private int no;//���
	private Boy next;//ָ����һ���ڵ㣬Ĭ��Ϊnull
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