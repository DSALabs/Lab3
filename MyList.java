package lab3;


public interface MyList<T>{
	//Inserts an element into a specified position in the list. This
	//method throws an exception if position value is less than 1 or greater than the list size.
	public boolean add(int index, T o);
	
	//adds element to the end of the list
	public boolean add(T o);
	
	//removes all elements from the list
	public boolean clear();
	
	//Returns true if if the list contains a specified element
	public boolean contains(T o);
	
	//Returns the element located in the specified position of this list. This method throws an exception if position value is less than 1 or greater than the list size. 
	public T get(int index);
	
	public int indexOf(T o);
	
	public boolean isEmpty();
	
	public void remove(int index);
	
	public void remove(T o);
	
	public boolean set(int index, T element);
	
	public int size();
	
	public MyList<T> subList(int fromIndex, int toIndex);
	
	public T[] toArray();
	
	public boolean swap(int postion1, int position2);
	
	public boolean shift(int positions);
}
