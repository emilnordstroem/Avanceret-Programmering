package lektion0203BinaerTraer.binaerSoegeTraeImplementering;

import java.util.ArrayList;
import java.util.Comparator;

public class BST<E> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    protected Comparator<E> c;

    /**
     * Create a default BST with a natural order comparator
     */
    public BST() {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * Create a BST with a specified comparator
     */
    public BST(java.util.Comparator<E> c) {
        this.c = c;
    }

    /**
     * Create a binary tree from an array of objects
     */
    public BST(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    /** Returns true if the element is in the tree */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root

        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                found = true; // Element is found
        }

        return found;
    }

    @Override
    /** Insert element e into the binary tree
     * Return true if the element is inserted successfully */
    public boolean insert(E e) {
        boolean inserted = true;
        if (root == null)
            root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null && inserted)
                if (c.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (c.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    inserted = false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (c.compare(e, parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return inserted; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    /** Inorder traversal from the root */
    public void inorder() {
        inorder(root);
    }

    public void inorder(TreeNode<E> node){
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.element);
        inorder(node.right);
    }

    @Override
    /** Postorder traversal from the root */
    public void postorder() {
        postorder(root);
    }

    public void postorder(TreeNode<E> node){
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.element);
    }

    @Override
    /** Preorder traversal from the root */
    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode<E> node){
        if(node == null){
            return;
        }
        System.out.println(node.element);
        preorder(node.left);
        preorder(node.right);
    }

    /**
     * This inner class is static, because it does not access
     * any instance members defined in its outer class
     */
    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    @Override
    /** Get the number of nodes in the tree */
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    public TreeNode<E> getRoot() {
        return root;
    }


    @Override
    /** Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                found = true; // Element is in the tree pointed at by current
        }

        if (found) {
            // Case 1: current has no left child
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                } else {
                    if (c.compare(e, parent.element) < 0)
                        parent.left = current.right;
                    else
                        parent.right = current.right;
                }
            } else {
                // Case 2: The current node has a left child
                // Locate the rightmost node in the left subtree of
                // the current node and also its parent
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right; // Keep going to the right
                }

                // Replace the element in current by the element in rightMost
                current.element = rightMost.element;

                // Eliminate rightmost node
                if (parentOfRightMost.right == rightMost)
                    parentOfRightMost.right = rightMost.left;
                else
                    // Special case: parentOfRightMost == current
                    parentOfRightMost.left = rightMost.left;
            }
            size--; // Reduce the size of the tree
        }
        return found; // Element deleted successfully
    }

//
    //-------------------------------------------------------------------

    public boolean isLeaf(TreeNode<E> node){
        return node.left == null
                && node.right == null;
    }

    public boolean isInternal(TreeNode<E> node){
        return node.left != null || node.right != null;
    }

    public int height(TreeNode<E> root){
        if (root == null) {
            return -1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int totalSumOfElements(TreeNode<Integer> node){
       if (node == null) {
           return 0;
       }
       return node.element + totalSumOfElements(node.left) + totalSumOfElements(node.right);
    }

    public int findMax(TreeNode<Integer> node){
        if (node.right == null) {
            return node.element;
        }
        return findMax(node.right);
    }

    public int findMin(TreeNode<Integer> node){
        if (node.left == null) {
            return node.element;
        }
        return findMin(node.left);
    }

// Lektion 3
    //-------------------------------------------------------------------
    // Opgave 02

    public E removeMin(){
        if (root == null) {
            throw new IllegalArgumentException();
        }
        return removeMin(root, root.left);
    }
    public E removeMin(TreeNode<E> parentNode,
                       TreeNode<E> currentNode) {
        if (currentNode.left == null && currentNode.right == null) {
            parentNode.left = null;
            return currentNode.element;
        } else if (currentNode.left == null)  {
            E elementRemoved = currentNode.element;
            TreeNode<E> replaceCurrentWithThisNode = findLeftMostLargestNode(currentNode.right);
            replaceNodesLeft(parentNode, replaceCurrentWithThisNode);
            return elementRemoved;
        }
        return removeMin(currentNode, currentNode.left);
    }
    public TreeNode<E> findLeftMostLargestNode(TreeNode<E> currentNode) {
        if (currentNode.right == null) {
            return currentNode;
        }
        return findLeftMostLargestNode(currentNode.right);
    }
    public void replaceNodesLeft(TreeNode<E> parentNode,
                             TreeNode<E> replacedWithNode) {
        parentNode.left = replacedWithNode;
    }


    public E removeMax() {
        if (root == null) {
            throw new NullPointerException();
        }
        return removeMax(root, root.right);
    }
    public E removeMax(TreeNode<E> parentNode,
                       TreeNode<E> currentNode){
        if (currentNode.right == null && currentNode.left == null) {
            parentNode.right = null;
            return currentNode.element;
        } else if (currentNode.right == null) {
            E elementRemoved = currentNode.element;
            TreeNode<E> replaceCurrentWithThisNode = findRightMostLargestNode(currentNode.left);
            replaceNodesRight(parentNode, replaceCurrentWithThisNode);
            return elementRemoved;
        }
        return removeMax(currentNode, currentNode.right);
    }
    public TreeNode<E> findRightMostLargestNode(TreeNode<E> currentNode) {
        if (currentNode.left == null) {
            return currentNode;
        }
        return findLeftMostLargestNode(currentNode.left);
    }
    public void replaceNodesRight(TreeNode<E> parentNode,
                                  TreeNode<E> replacedWithNode){
        parentNode.right = replacedWithNode;
    }

    public ArrayList<E> greateThan (E element){
        TreeNode<E> elementNode = findNodeContainingElement(element, root);
        return greaterThan(new ArrayList<>(), elementNode);
    }

    public TreeNode<E> findNodeContainingElement(E target, TreeNode<E> currentNode){
        if (c.compare(target, currentNode.element) == 0) {
            return currentNode;
        } else if (c.compare(target, currentNode.element) < 0) {
            return findNodeContainingElement(target, currentNode.left);
        } else {
            return findNodeContainingElement(target, currentNode.right);
        }
    }

    public ArrayList<E> greaterThan (ArrayList<E> elementList,
                                     TreeNode<E> currentNode) {
        return null;
    }

    //-------------------------------------------------------------------
    // Opgave 04

    public int numberOfLeaves() {
        return 0;
    }

    public int heightNodeCount(int targetHeight){
        return 0;
    }

}