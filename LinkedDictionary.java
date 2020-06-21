/* Natalie Pham 
 * LinkedDictionary Class 
 * This class implements the ADT dictionary by using 
 * a chain of nodes. This dictionary is unsorted and 
 * has distinction search keys.
 */

import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedDictionary<K,V> implements DictionaryInterface<K,V> {
	private Node firstNode;
	private int numberOfEntries;
	
	public LinkedDictionary() {
		initializeDataFields();
	}
	
	private class KeyIterator implements Iterator<K>{
		private Node nextNode;
		
		private KeyIterator() {
			nextNode = firstNode;
		}
		public boolean hasNext() {
			return nextNode != null;
		}
		
		public K next() {
			K result;
			if(hasNext()) {
				result = nextNode.getKey();
				nextNode = nextNode.getNextNode();
			}
			else {
				throw new NoSuchElementException();
			}
			return result;
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	private class ValueIterator implements Iterator<V>{
		private Node nextNode;
		
		private ValueIterator() {
			nextNode = firstNode;
		}
		
		public boolean hasNext() {
			return nextNode != null;
		}
		public V next() {
			V result;
			if(hasNext()) {
				result = nextNode.getValue();
				nextNode = nextNode.getNextNode();
			}
			else {
				throw new NoSuchElementException();
			}
			return result;
		}
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
	}
	
	private class Node{
		private K key;
		private V value;
		private Node next;
		
		private Node(K searchKey, V dataValue) {
			key = searchKey;
			value = dataValue;
			next = null;
		}
		
		private Node(K searchKey, V dataValue, Node nextNode) {
			key = searchKey;
			value = dataValue;
			next = nextNode;
		}
		
		private K getKey() {
			return key;
		}
		private V getValue() {
			return value;
		}
		private void setValue(V newValue) {
			value = newValue;
		}
		private Node getNextNode() {
			return next;
		}
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}
	
    public V add(K key, V value) {
		V result = null;
		Node currentNode = firstNode;
        
		while ((currentNode != null) && !key.equals(currentNode.getKey())) {
			currentNode = currentNode.getNextNode();
		}
		if (currentNode == null) {
			Node newNode = new Node(key, value);
            newNode.setNextNode(firstNode);
            firstNode = newNode;
            numberOfEntries++;
		} 
		else {
            result = currentNode.getValue();
            currentNode.setValue(value);
		}
		return result;
	}
    
	public V remove(K key) {
		V result = null;
		if (!isEmpty()) {
			Node currentNode = firstNode;
			Node nodeBefore = null;
			
			while ((currentNode != null) && !key.equals(currentNode.getKey())) {
				nodeBefore = currentNode;
				currentNode = currentNode.getNextNode();
			}
			if (currentNode != null) {
				Node nodeAfter = currentNode.getNextNode();
                if (nodeBefore == null) {
                    firstNode = nodeAfter;
                } 
                else { 
                    nodeBefore.setNextNode(nodeAfter);
                }			
				result = currentNode.getValue();
				numberOfEntries--;
			}
		}
		return result;
	}
	
	public V getValue(K key) {
        V result = null;
        Node currentNode = firstNode;
        while ((currentNode != null) && !key.equals(currentNode.getKey())) {
            currentNode = currentNode.getNextNode();
        }
        if (currentNode != null) {
            result = currentNode.getValue();
        }
        return result;
	}
	public boolean contains(K key) {
        return getValue(key) != null;
	}
	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}
	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	public int getSize() {
		return numberOfEntries;
	}
	public final void clear() {
        initializeDataFields();
	} 
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	}
}
