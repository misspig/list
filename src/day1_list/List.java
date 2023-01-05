package day1_list;

//使用带head头的单向链表实现水浒英雄排行榜管理
//1:完成对英雄人物的增删改查
//添加英雄可以插入到指定位置。
public class List {
	public static void main(String[]args) {
		
		HeroNode hero1=new HeroNode(1,"宋江","及时雨");
		HeroNode hero2=new HeroNode(2,"卢俊义","玉麒麟");
		HeroNode hero3=new HeroNode(3,"吴用","智多星");
		HeroNode hero4=new HeroNode(4,"林冲","豹子头");
		SingleLinkedList slist=new SingleLinkedList();
		
		//添加
		slist.add(hero3);
		slist.add(hero2);
		slist.add(hero1);
		slist.add(hero4);
		//修改
		HeroNode hero33=new HeroNode(3,"没用","智多星der~");
		slist.update(hero33);

		//删除
		slist.delete(hero4);
		slist.delete(hero4);
		slist.list();
	}
}
//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList{
	//先初始化一个头结点
	private HeroNode head=new HeroNode(0,"","");
	
	//添加节点到单向链表
	public void add(HeroNode heroNode) {
		//因为head节点不能动，因此我们需要一个辅助接点
		HeroNode temp=head;
		while(true) {
			if(temp.no==heroNode.no) {
				System.out.println("已经有这个排名了");
				break;
			}
			if(temp.next==null) {
				temp.next=heroNode;
				break;
			}//上面判断下一个是null就会跳出循环，所以下面的都是不会出现next是null
			if(temp.next.no>heroNode.no) {
				heroNode.next=temp.next;
				temp.next=heroNode;
				break;
			}
			temp=temp.next;
		}
	}
	//显示链表
	public void list() {
		if(head.next==null) {
			System.out.println("链表为空");
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
	//修改
	public void update(HeroNode newHeroNode) {
		//判断是否空
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
		
	    //找到需要修改的节点
		HeroNode temp=head.next;
		boolean flag=false;
		while(true) {
			if(temp==null) {
				break;//链表遍历完毕
			}
			if(temp.no==newHeroNode.no) {
				temp.name=newHeroNode.name;
				temp.nickname=newHeroNode.nickname;
			}
			temp=temp.next;
		}
	}
	
	//删除
	public void delete(HeroNode heroNode) {
		if(head.next==null) {
			System.out.println("空链表");
		}
		
		HeroNode temp=head;
		while(true) {
			//下面是找到要删除的节点，这样就没有办法删除了
//			if(temp.no==heroNode.no) {
//				if(temp.next==null) {
//					temp=null;
//				}else {
//					
//				}
//			}
//			if(temp.next==null) {
//				System.out.println("没有找到");
//			}
			//应该是要找到他的前一个节点
			if(temp.next==heroNode) {
				temp.next=temp.next.next;//不管是不是最后一个还是中间，都是可以的
				break;
			}
			if(temp.next==null) {
				System.out.println("没有找到要陷害的英雄");
				break;
			}
			//上面的两个if是并列的，如果我是再
			temp=temp.next;
		}
	}
}
//定义HeroNode，每一个对象就是一个节点
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
