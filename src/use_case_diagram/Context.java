package use_case_diagram;

import java.util.Stack;

public class Context {

	private Stack<Object> context = null;

	Stack<Object> getContext () {
		if (context == null) context = new Stack<Object>();
		return context;
	}

	void push (Object o) {
		getContext().push(o);
	}

	void pop () {
		getContext().pop();
	}

	Object top () {
		return getContext().peek();
	}

}
