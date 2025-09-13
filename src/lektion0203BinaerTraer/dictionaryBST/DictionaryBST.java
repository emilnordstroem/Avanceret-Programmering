package lektion0203BinaerTraer.dictionaryBST;

import com.sun.source.tree.IfTree;

import java.util.Currency;
import java.util.NoSuchElementException;

public class DictionaryBST<K extends Comparable<K>, V> implements Dictionary<K, V> {

	private Node root;

	public DictionaryBST() {
		root = null;
	}

	@Override
	public V get(K key) {
		Node foundNode = find(key);
		return foundNode != null ? foundNode.value : null;
	}

	private Node find(K key) {
		Node current = root;
		boolean found = false;
		while (!found && current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (found) {
			return current;
		} else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public V put(K key, V value) {
		if (root == null) {
			root = new Node(key, value);
			return value;
        }
		return put(null, root, key, value);
    }

	private V put(Node parentNode, Node currentNode, K key, V value){
		if (currentNode == null) {
			return putNewNode(parentNode, key, value);
		}

		V currentNodeValue = currentNode.value;
		int compareResult = currentNode.key.compareTo(key);

		if (compareResult == 0) {
			replaceNodeValues(currentNode, value);
		} else if (compareResult < 0) {
			return put(currentNode, currentNode.left, key, value);
		} else {
			return put(currentNode, currentNode.right, key, value);
		}

		return currentNodeValue;
	}

	private V putNewNode(Node node, K key, V value){
		int compareResult = node.key.compareTo(key);
		if (compareResult < 0) {
			node.left = new Node(key, value);
		} else {
			node.right = new Node(key, value);
		}
		return value;
	}

	private void replaceNodeValues (Node nodeToModify, V valueToPut) {
		nodeToModify.value = valueToPut;
	}

	@Override
	public V remove(K key) {
		if (root == null
				|| key == null) {
			throw new NullPointerException();
		}
		Node removedNode = locateAndRemove(null, root, key);
		if (removedNode == null) {
			throw new NoSuchElementException();
		}

		return null;
	}

	private Node locateAndRemove (Node parentNode, Node currentNode, K targetKey) {
		int compareKeyResult = currentNode.key.compareTo(targetKey);
		if (compareKeyResult == 0) {
			if (isLeaf(currentNode)) {
				compareKeyResult = parentNode.key.compareTo(targetKey);
				if (compareKeyResult < 0) {
					parentNode.left = null;
				} else {
					parentNode.right = null;
				}
			} else {
				if (hasOnlyLeftChild(currentNode)) {
					parentNode.left = currentNode.left;
				} else if (hasOnlyRightChild(currentNode)) {
					parentNode.right = currentNode.right;
				}

			}
			return currentNode;
		} else if (compareKeyResult < 0) {
			return locateAndRemove(currentNode, currentNode.left, targetKey);
		} else {
			return locateAndRemove(currentNode, currentNode.right, targetKey);
		}
	}

	public boolean isLeaf (Node node) {
		return node.left == null
				&& node.right == null;
	}

	public boolean hasOnlyLeftChild(Node node){
		return node.left != null
				&& node.right == null;
	}

	public boolean hasOnlyRightChild(Node node){
		return node.left == null
				&& node.right != null;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node currentNode) {
		if (currentNode == null) {
			return 0;
		}
		return 1 + size(currentNode.left) + size(currentNode.right);
	}

	//===================================================
	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

}
