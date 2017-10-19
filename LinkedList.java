package lab3;
import java.util.*;
public class LinkedList<T> implements MyList <T>{
	Node <T> tail;
	int count;
	
	
	public LinkedList(){
		tail = null;
		count = 0;
	}
	
class Node<T> {
   T data;
   Node<T> next;
   Node<T> tail = null;
   public Node(T data) {
	   this.data = data;
	   next = null;
   }
}	
	@Override
	public boolean add(int index, T o) {
		// TODO Auto-generated method stub
		if(index < 0 || index > count) {
			throw new IndexOutOfBoundsException(index + " < 0 or > " + count);
		}
		//find previous
		Node<T> prev = tail;
		for (int i=0; i < index; i++) {
			prev = prev.next;
		}
		//Insert after prev
		Node<T> itemNode = new Node<T>(o);
		if(count == 0) {
			throw new NoSuchElementException();
		}
		return true;
	}

	@Override
	public boolean add(T o) {
		// TODO Auto-generated method stub
		Node<T> itemNode = new Node<T>(o);
		if(count == 0) {
			itemNode.next = itemNode;
		} else {
			itemNode.next = tail.next;
			tail.next = itemNode;
		}
		tail = itemNode;
		count++;
		return true;
	}

	@Override
	public boolean clear() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(T o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		if(index < 0|| index > count) {
			throw new IndexOutOfBoundsException(index + " < 0 or >= " + count);
		}
		Node<T> curr = tail.next;
		for(int i = 0; i < index; i ++) {
			curr = curr.next;
		}
		return curr.data;
	}

	@Override
	public int indexOf(T item) {
		// TODO Auto-generated method stub
		if(count == 0) {
			return -1;
		}
		Node<T> curr = tail.next;
		for(int i = 0; i < count; i++) {
			if(item.equals(curr.data)) {
				return i;
			}
			curr = curr.next;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		if(index < 0 || index >= count) {
			throw new IndexOutOfBoundsException(index + " < 0 ore >+ " + count);
		}
		T ret = null;
		if(index ==0) {
			ret = tail.next.data;
			if(count == 1) {
				tail = null;
			} else {
				tail.next = tail.next.next;
			}
			count--;
		} else {
			Node<T> prev = tail.next;
			for(int i = 0; i < index - 1; i++) {
				prev = prev.next;
			}
			Node<T> curr = prev.next;
			ret = curr.data;
			prev.next = curr.next;
			curr.next = null;
			count--;
			if(curr == tail) {
				tail = prev;
			}
		}
	}

	@Override
	public void remove(T o) {
		// TODO Auto-generated method stub
		int i = indexOf(o);
		if(i == -1) {
			throw new NoSuchElementException();
		}
		remove(i);
	}

	@Override
	public boolean set(int index, T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MyList<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean swap(int postion1, int position2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shift(int positions) {
		// TODO Auto-generated method stub
		return false;
	}

}
