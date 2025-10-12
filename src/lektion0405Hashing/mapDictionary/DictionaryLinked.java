package lektion0405Hashing.mapDictionary;

public class DictionaryLinked<K, V> implements Dictionary<K, V> {

	private Node start;
	private int size;

	/**
	 * HashingMap constructor comment.
	 */

	public DictionaryLinked() {
		// Sentinel (tomt listehoved - der ikke indeholder data)
		start = new Node();
		size = 0;
	}

	@Override
	public V get(K key) {
		Node currentNode = start;
		while (currentNode != null) {
			if (currentNode.key.equals(key)) {
				return currentNode.value;
			}
			currentNode = currentNode.next;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		if (key == null || value == null) {
			return null;
		}

		Node currentNode = start.next;
		Node previousNode = start;
		while (currentNode != null) {
			if (currentNode.key.equals(key)) {
				V previousValue = currentNode.value;
				currentNode.value = value;
				return previousValue;
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
		}

		Node newNode = new Node();
		newNode.key = key;
		newNode.value = value;
		previousNode.next = newNode;
		size++;
		return newNode.value;
	}

	@Override
	public V remove(K key) {
		Node currentNode = start.next;
		Node previousNode = start;
		while (currentNode != null) {
			if (currentNode.key.equals(key)) {
				size--;
				previousNode.next = currentNode.next;
				return currentNode.value;
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	private class Node {
		Node next;
		K key;
		V value;
	}

}