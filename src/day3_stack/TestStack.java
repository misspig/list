package day3_stack;

import java.util.Stack;
//java������ջ
public class TestStack {

	public static void main(String[]args) {
		Stack<String>stack = new Stack();
		
		//��ջ
//		stack.add("jack");
//		stack.add("tom");
//		stack.add("smith");
		//�ϸ����˵Ӧ��ʹ��push
		stack.push("jack");
		stack.push("tom");
		stack.add("smith");
		
		System.out.println(stack.search("smith"));

		//��ջ
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
}
