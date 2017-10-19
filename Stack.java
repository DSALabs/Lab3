import java.util.NoSuchElementException;
public class Stack<T> {

	LinkedList<T> list;
	int cursor;
	public Stack() {
		list = new LinkedList<T>();
		cursor = -1;
	}
	public void push(T item) {
		if (list.size() == 0) {
			list.add(item);}
		else{
				list.add(0, item);
			}
		}
	public T pop()
	{
		if(list.isEmpty()) {
			throw new NoSuchElementException();
		}
		T removed = list.get(0);
		list.remove(0);
		return removed;
	}
	public int size()
	{
		return list.size();
	}
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	public void clear() {
		list.clear();
	}
	public T first()
	{
		if (list.size() == 0) {
			return null;
		}
		cursor=0;
		return list.get(cursor);
	}
	public T next()
	{
		if(cursor < 0 || cursor ==(list.size()-1)) {
			return null;
		}
		cursor++;
		return list.get(cursor);
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
