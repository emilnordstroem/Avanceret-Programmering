package lektion0203BinaerTraer.dictionaryBST;

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
			return null;
		}
        return locateAndRemove(null, root, key);
	}

	private V locateAndRemove (Node parentNode, Node currentNode, K targetKey) {
		if (currentNode == null) {
			return null;
		}
		V foundValue;
		int compareKeyResult = currentNode.key.compareTo(targetKey);
		if (compareKeyResult < 0) {
			return locateAndRemove(currentNode, currentNode.left, targetKey);
		} else if (compareKeyResult > 0) {
			return locateAndRemove(currentNode, currentNode.right, targetKey);
		} else {
			foundValue = currentNode.value;
			if (isLeaf(currentNode)) {
				replaceChildNode(parentNode, currentNode, null);
			} else if (hasOnlyLeftChild(currentNode)) {
				replaceChildNode(parentNode, currentNode, currentNode.left);
			} else if (hasOnlyRightChild(currentNode)) {
				replaceChildNode(parentNode, currentNode, currentNode.right);
			} else {
				Node successorNode = findMinimum(currentNode.right);
				currentNode.key = successorNode.key;
				currentNode.value = successorNode.value;
				// I ignore the return of locateAndRemove - otherwise the foundValue isn't consistent
				locateAndRemove(currentNode, currentNode.right, successorNode.key);
			}
			return foundValue;
		}
	}

	public boolean isLeaf (Node node) {
		return node.left == null
				&& node.right == null;
	}

	private void replaceChildNode(Node parent, Node oldChild, Node newChild) {
		if (parent == null) {
			root = newChild;
		} else if (parent.left == oldChild) {
			parent.left = newChild;
		} else {
			parent.right = newChild;
		}
	}

	private Node findMinimum(Node node) {
		if (node.left == null) {
			return node;
		}
		return findMinimum(node.left);
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
