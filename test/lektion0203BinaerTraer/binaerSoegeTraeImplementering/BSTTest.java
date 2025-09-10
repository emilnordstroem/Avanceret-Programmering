package lektion0203BinaerTraer.binaerSoegeTraeImplementering;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    private BST<Integer> binarySearchTree;

    @BeforeEach
    void setup(){
        binarySearchTree = new BST<>();
        int[] numbersToInsert = {45, 22, 11, 30, 15, 25, 77, 90, 88};
        for(int index = 0; index < numbersToInsert.length; index++){
            binarySearchTree.insert(numbersToInsert[index]);
        }
    }

    @Test
    void inorder() {
        binarySearchTree.inorder();
    }

    @Test
    void postorder() {
        binarySearchTree.postorder();
    }

    @Test
    void preorder() {
        binarySearchTree.preorder();
    }

    @Test
    void isLeaf() {
        assertFalse(binarySearchTree.isLeaf(binarySearchTree.getRoot()));
    }

    @Test
    void isInternal() {
        assertTrue(binarySearchTree.isInternal(binarySearchTree.getRoot()));
    }

    @Test
    void height() {
        int expectedResult = 3;
        int actualResult = binarySearchTree.height(binarySearchTree.getRoot());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void totalSumOfElements() {
        int expectedResult = 403;
        int actualResult = binarySearchTree.totalSumOfElements(binarySearchTree.root);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void findMax() {
        int expectedResult = 90;
        int actualResult = binarySearchTree.findMax(binarySearchTree.getRoot());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void findMin() {
        int expectedResult = 11;
        int actualResult = binarySearchTree.findMin(binarySearchTree.getRoot());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void removeMin() {
        int expectedResult = 11;
        int actualResult = binarySearchTree.removeMin();
        assertEquals(expectedResult, actualResult);

        expectedResult = 15;
        actualResult = binarySearchTree.removeMin();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void removeMax() {
        int expectedResult = 90;
        int actualResult = binarySearchTree.removeMin();
        assertEquals(expectedResult, actualResult);

        expectedResult = 88;
        actualResult = binarySearchTree.removeMin();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void greateThan() {
    }

    @Test
    void numberOfLeaves() {
    }

    @Test
    void heightNodeCount() {
    }
    
}