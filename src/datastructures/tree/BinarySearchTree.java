package datastructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public boolean insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            return true;
        }
        Node temp = root;
        while (true) {
            if (temp.data == node.data) {
                return false;
            } else if (node.data < temp.data) {
                if (temp.left == null) {
                    temp.left = node;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int data) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            } else if (data < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    public ArrayList<Integer> BSF() {
        Node node = root;
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() > 0) {
            node = queue.remove();
            result.add(node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        class Traversal {
            Traversal(Node node) {
                if (node.left != null) {
                    new Traversal(node.left);
                }
                result.add(node.data);
                if (node.right != null) {
                    new Traversal(node.right);
                }
            }
        }
        new Traversal(root);
        return result;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        class Traversal {
            Traversal(Node node) {
                result.add(node.data);
                if (node.left != null) {
                    new Traversal(node.left);
                }
                if (node.right != null) {
                    new Traversal(node.right);
                }
            }
        }
        new Traversal(root);
        return result;
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        class Traversal {
            Traversal(Node node) {
                if (node.left != null) {
                    new Traversal(node.left);
                }
                if (node.right != null) {
                    new Traversal(node.right);
                }
                result.add(node.data);
            }
        }
        new Traversal(root);
        return result;
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
