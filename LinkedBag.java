* Natalie Pham 
 * This has two instance variables
 * It has an inner class Node
 */



package LinkedBag;

public class LinkedBag <T> implements BagInterface<T>{
	private Node firstNode; //reference to the first node of chain
	private int numberOfEntries;
	
	
	//default constructor
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	}
	
	
	//implement the unimplemented methods
	private Node getReferenceTo(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while(!found && (currentNode != null)) {
			if(anEntry.equals(currentNode.data)) {
				found = true;
			}
			else {
				currentNode = currentNode.next;
			}
		}
		return currentNode;
	}
	
	//private class node
	private class Node{
		private T data;
		private Node next;
		
		private Node(T data) {
			this(data, null);
		}
		
		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		private T getData() {
			return data;
		}
		
		private void setData(T data) {
			this.data = data;
		}
		
		private Node getNextNode() {
			return next;
		}
		
		private void setNextNode(Node next) {
			this.next = next;
		}
	}
	//getCurrentSize function
	public int getCurrentSize() {
		return numberOfEntries;
	}
	
	//empty function
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	//add function
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		
		firstNode = newNode;
		numberOfEntries++;
		
		return true;
	}
	
	//remove function
	public boolean remove(T anEntry) {
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);
		
		if(nodeN != null) {
			nodeN.data = firstNode.data;
			
			firstNode = firstNode.next;
			numberOfEntries--;
			result = true;
		}
		return result;
	}
	
	//chackes the numberofEntries
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		
		int index = 0;
		Node currentNode = firstNode;
		while((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		}
		return result;
	}
	

	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int loopCounter = 0;
		Node currentNode = firstNode;
		
		while((loopCounter < numberOfEntries) && (currentNode != null)) {
			if(anEntry.equals(currentNode.data)) {
				frequency++;
			}
			loopCounter++;
			currentNode = currentNode.next;
		}
		return frequency;
	}
	
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null)) {
			if(anEntry.equals(currentNode.data)) {
				found = true;
			}
			else {
				currentNode = currentNode.next;
			}
		}
		return found;
	}
	
	public void clear() {
		while(!isEmpty()) {
			remove();
		}
	}
	
	public T remove() {
		T result = null;
		if(firstNode != null) {
			result = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
		}
		return result;
	}
	
}
