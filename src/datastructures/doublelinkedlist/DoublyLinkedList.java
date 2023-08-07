package datastructures.doublelinkedlist;

import java.util.StringJoiner;

public class DoublyLinkedList {
    private int length;
    private Node tail;
    private Node head;

    public DoublyLinkedList(int data) {
        Node node = new Node(data);
        head = node;
        tail = node;
        length += 1;
    }

    public int getLength() {
        return length;
    }

    public Node getTail() {
        return tail;
    }

    public Node getHead() {
        return head;
    }

    public void append(int data) {
        Node node = new Node(data);
        if (length == 0) {
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
        length += 1;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            temp.previous = null;
            tail.next = null;
        }
        length -= 1;
        return temp;
    }

    public void prepend(int data) {
        Node node = new Node(data);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            head.previous = node;
            node.next = head;
            head = node;
        }
        length += 1;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
            temp.next = null;
        }
        length += 1;
        return temp;
    }

    public Node get(int idx) {
        if (idx < 0 || idx >= length) return null;
        Node temp = head;
        if (idx < length / 2) {
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > idx; i--) {
                temp = temp.previous;
            }
        }
        return temp;
    }

    public boolean set(int data, int idx) {
        Node temp = get(idx);
        if (temp != null) {
            temp.data = data;
            return true;
        }
        return false;
    }

    public void printList() {
        StringJoiner sj = new StringJoiner(", ");
        Node temp = head;
        while (temp != null) {
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
        }
        System.out.printf("[ %s ]%n", sj);
    }

    public boolean insert(int idx, int data) {
        if (idx < 0 || idx > length) {
            return false;
        }
        if (length == idx) {
            append(data);
            return true;
        }
        if (idx == 0) {
            prepend(data);
            return true;
        }
        Node node = new Node(data);
        Node before = get(idx - 1);
        Node after = before.next;
        before.next = node;
        node.previous = before;
        node.next = after;
        after.previous = node;
        length += 1;
        return true;
    }

    public Node remove(int idx) {
        if (idx < 0 || idx >= length) return null;
        if (idx == 0) return removeFirst();
        if (idx == length - 1) return removeLast();
        Node before = get(idx - 1);
        Node after = get(idx + 1);
        Node temp = before.next;
        before.next = after;
        after.previous = before;
        temp.next = null;
        temp.previous = null;
        length -= 1;
        return temp;
    }

    class Node {
        int data;
        Node next;
        Node previous;

        public Node(int data) {
            this.data = data;
        }

    }
}
