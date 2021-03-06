//Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack.
//If the stack is empty, min() should return -1.
//
//pop() - remove and return the top element, if the stack is empty, return -1
//
//push(int element) - push the element to top
//top() - return the top element without remove it, if the stack is empty, return -1
//min() - return the current min value in the stack.

package round3;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMin {
	Deque<Integer> stack;
	Deque<Integer> minStack;
	public StackWithMin() {
		stack = new ArrayDeque<Integer>();
		minStack = new ArrayDeque<Integer>();
	}
	public int pop() {
		if (stack.isEmpty()) {
			return -1;
		}
		Integer result = stack.poll();//same as poll first
		if (minStack.peek().equals(result)) {
			minStack.poll();
		}
		return result;
	}
	public void push (int element) {
		stack.offer(element);
		if(minStack.isEmpty()|| element<=minStack.peek()) {
			minStack.offer(element);
		}
	}
	public int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peek();
	}
	public int min() {
		if (minStack.isEmpty()) {
			return -1;
		}
		return minStack.peek();
		
	}

}
