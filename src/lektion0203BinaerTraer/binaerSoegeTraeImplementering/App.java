package lektion0203BinaerTraer.binaerSoegeTraeImplementering;

public class App {
    public static void main(String[] args) {

    // Opgave 1
        // Delopgave 1
        BST<Integer> binarySearchTree = new BST<>();
        int[] numbersToInsert = {45, 22, 11, 30, 15, 25, 77, 90, 88};
        for(int index = 0; index < numbersToInsert.length; index++){
            binarySearchTree.insert(numbersToInsert[index]);
        }

        // Delopgave 2
        /*
        Preorder: 45, 22, 11, 15, 30, 25, 77, 90, 88
        Inorder: 15, 11, 22, 30, 25, 45, 88, 90, 77
        Postorder: 15, 11, 25, 30, 22, 88, 90, 77, 45
         */

        // Delopgave 3 -> se BSTTest.java

    // Opgave 2 -> se BSTTest.java
    // Opgave 3 -> se BSTTest.java
    // Opgave 4 -> se BSTTest.java

    }
}
