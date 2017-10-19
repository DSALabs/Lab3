import java.util.NoSuchElementException;
import java.io.PrintWriter;
public class StackKeeper {
	static final char[] operators = {'+', '-', '*', '/'};
	Stack<Float> evalStack;
	
	public StackKeeper(){
		evalStack = new Stack<Float>();
		
	}
	public void init() {
		evalStack.clear();
	}
	public int size() {
		return evalStack.size();
	}
	public void update(String token) {
		if(isOperator(token)) {
		evaluate(token.charAt(0));
		}
		else {
			evalStack.push(Float.valueOf(token));
			
		}
	}
	public float getTop() {
		Float top = evalStack.first();
		if(top == null) {
			throw new NoSuchElementException();
		}
		return top;
	}
	public boolean isOperator(String instr) {
		if(instr.length()<1) {
			return false;
		}
		char c = instr.charAt(0);
		for (int i = 0; i<operators.length; i++)
		{
			if(c == operators[i]) {
				return true;
			}
		}
		return false;
	}
	public void evaluate(char op) {
		Float topval = evalStack.pop();
		Float nextval = evalStack.pop();
		float tempval = 0;
		switch(op) {
		case '+': tempval = nextval + topval; break; 
		case '-': tempval = nextval - topval; break; 
		case '*': tempval = nextval * topval; break; 
		case '/': tempval = nextval / topval; break; 
		}
		evalStack.push(tempval);
		
	}
	public void printStack(PrintWriter pw) {
		pw.println("      ------->");
		pw.print("    Stack :  ");
		
		Stack<Float> tempStack = new Stack<Float>();
		Float obj = evalStack.first();
		while(obj!=null) {
			tempStack.push(enum.nextElement());
			
		}
	}
	
	
	
	
	
	
	
	
	
	
}
