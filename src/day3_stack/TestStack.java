package day3_stack;

import java.util.Stack;
//java内置有栈
public class TestStack {

	public static void main(String[]args) {
		Stack<String>stack = new Stack();
		
		//入栈
//		stack.add("jack");
//		stack.add("tom");
//		stack.add("smith");
		//严格的来说应该使用push
		stack.push("jack");
		stack.push("tom");
		stack.add("smith");
		
		System.out.println(stack.search("smith"));

		//出栈
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
}
