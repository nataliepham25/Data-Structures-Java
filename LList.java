import javax.xml.soap.Node;

/*
 * Name: Natalie Pham
 * LinkedList Class
 */


package LinkedList;


public class LList<T> implements ListInterface<T> {
	private Node firstNode;
	private int numberOfEntries;
	
	public LList() {
		initializeDataFields();
	}
	
	public void clear() { 
		initializeDataFields();
	}
	
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	}
	
	private Node getNodeAt(int givenPosition) {
		assert (firstNode != null) && (1 <= givenPosition) && 
			(givenPosition <= numberOfEntries);
		Node currentNode = firstNode;
		for (int counter = 1; counter < givenPosition; counter++) 
			currentNode = currentNode.getNextNode();
		assert currentNode != null;
		return currentNode;
	}
	
	private class Node  {
		private T data;
		private Node next;
		
		private Node(T dataPortion) {
			this(dataPortion, null);
		}
		
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
		
		private T getData() {
			return data;
		}
		
		private void setData(T newData) {
			data = newData;
		}
		
		private Node getNextNode() {
			return next;
		}
		
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}

	public void add(T newEntry) {
		Node newNode = new Node(newEntry);
		if (isEmpty())
			firstNode = newNode;
		else {
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.setNextNode(newNode);
		}
		numberOfEntries++;
	}

	public void add(int newPosition, T newEntry) {
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			Node newNode = new Node(newEntry);
			if (newPosition == 1) 
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else {
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
		} 
		else 
			throw new IndexOutOfBoundsException (
					"Illegal position given to add operation.");	
	}

	public T remove(int givenPosition) {
		T result = null;
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			if (givenPosition == 1) {
				result = firstNode.getData();
				firstNode = firstNode.getNextNode();
			} 
			else 
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				result = nodeToRemove.getData();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
			}
			numberOfEntries--;
			return result;
		} 
		else 
			throw new IndexOutOfBoundsException(
					"Illegal position given to remove operation.");
	}

	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		} 
		else 
			throw new IndexOutOfBoundsException(
					"Illegal position given to remove operation.");
	}

	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return getNodeAt(givenPosition).getData();
		} 
		else
			throw new IndexOutOfBoundsException(
					"Illegal position given to remove operation.");
	}

	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData())) 
				found = true;
			else 
				currentNode = currentNode.getNextNode();
		}
		return found;
	}

	public int getLength() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		boolean result;
		if (numberOfEntries == 0) 
		{
			assert firstNode == null;
			result = true;
		} 
		else {
			assert firstNode != null;
			result = false;
		}
		return result;
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object [numberOfEntries];
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		return result;
	}

}
