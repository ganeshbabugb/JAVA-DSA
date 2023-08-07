package datastructures.tree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();
        List<Integer> list = List.of(47, 21, 76, 18, 27, 52, 82);
        /*
            BST.contains(1);
        */
        for (Integer x : list) {
            String a = String.valueOf(BST.insert(x));
            System.out.printf("BST.insert(%d) Inserted %s%n", x, a.toUpperCase());
        }
        System.out.println("Traversal BFS  = " + BST.BSF());
        System.out.println("Traversal DFS PREORDER = " + BST.DFSPreOrder());
        System.out.println("Traversal DFS POSTORDER = " + BST.DFSPostOrder());
        System.out.println("Traversal DFS INORDER = " + BST.DFSInOrder());
    }
}
