package day1_list;

//ʹ�ô�headͷ�ĵ�������ʵ��ˮ�Ӣ�����а����
//1:��ɶ�Ӣ���������ɾ�Ĳ�
//���Ӣ�ۿ��Բ��뵽ָ��λ�á�
public class List {
	public static void main(String[]args) {
		
		HeroNode hero1=new HeroNode(1,"�ν�","��ʱ��");
		HeroNode hero2=new HeroNode(2,"¬����","������");
		HeroNode hero3=new HeroNode(3,"����","�Ƕ���");
		HeroNode hero4=new HeroNode(4,"�ֳ�","����ͷ");
		SingleLinkedList slist=new SingleLinkedList();
		
		//���
		slist.add(hero3);
		slist.add(hero2);
		slist.add(hero1);
		slist.add(hero4);
		//�޸�
		HeroNode hero33=new HeroNode(3,"û��","�Ƕ���der~");
		slist.update(hero33);

		//ɾ��
		slist.delete(hero4);
		slist.delete(hero4);
		slist.list();
	}
}
//����SingleLinkedList �������ǵ�Ӣ��
class SingleLinkedList{
	//�ȳ�ʼ��һ��ͷ���
	private HeroNode head=new HeroNode(0,"","");
	
	//��ӽڵ㵽��������
	public void add(HeroNode heroNode) {
		//��Ϊhead�ڵ㲻�ܶ������������Ҫһ�������ӵ�
		HeroNode temp=head;
		while(true) {
			if(temp.no==heroNode.no) {
				System.out.println("�Ѿ������������");
				break;
			}
			if(temp.next==null) {
				temp.next=heroNode;
				break;
			}//�����ж���һ����null�ͻ�����ѭ������������Ķ��ǲ������next��null
			if(temp.next.no>heroNode.no) {
				heroNode.next=temp.next;
				temp.next=heroNode;
				break;
			}
			temp=temp.next;
		}
	}
	//��ʾ����
	public void list() {
		if(head.next==null) {
			System.out.println("����Ϊ��");
		    return;
		}
		HeroNode temp=head.next;
		while(true) {
			if(temp==null) { 
				break;
			}
			System.out.println(temp);
			temp=temp.next;
		}
	}
	//�޸�
	public void update(HeroNode newHeroNode) {
		//�ж��Ƿ��
		if(head.next==null) {
			System.out.println("����Ϊ��");
			return;
		}
		
	    //�ҵ���Ҫ�޸ĵĽڵ�
		HeroNode temp=head.next;
		boolean flag=false;
		while(true) {
			if(temp==null) {
				break;//����������
			}
			if(temp.no==newHeroNode.no) {
				temp.name=newHeroNode.name;
				temp.nickname=newHeroNode.nickname;
			}
			temp=temp.next;
		}
	}
	
	//ɾ��
	public void delete(HeroNode heroNode) {
		if(head.next==null) {
			System.out.println("������");
		}
		
		HeroNode temp=head;
		while(true) {
			//�������ҵ�Ҫɾ���Ľڵ㣬������û�а취ɾ����
//			if(temp.no==heroNode.no) {
//				if(temp.next==null) {
//					temp=null;
//				}else {
//					
//				}
//			}
//			if(temp.next==null) {
//				System.out.println("û���ҵ�");
//			}
			//Ӧ����Ҫ�ҵ�����ǰһ���ڵ�
			if(temp.next==heroNode) {
				temp.next=temp.next.next;//�����ǲ������һ�������м䣬���ǿ��Ե�
				break;
			}
			if(temp.next==null) {
				System.out.println("û���ҵ�Ҫ�ݺ���Ӣ��");
				break;
			}
			//���������if�ǲ��еģ����������
			temp=temp.next;
		}
	}
}
//����HeroNode��ÿһ���������һ���ڵ�
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;
	
	public HeroNode(int hNo,String hName,String hNickname) {
		this.no=hNo;
		this.name=hName;
		this.nickname=hNickname;
	}
	
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname +  "]";
	}
}
