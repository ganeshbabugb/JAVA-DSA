package datastructures.linklist;

import java.util.StringJoiner;

public class LinkList {
    private int length;
    private Node head;
    private Node tail;

    public LinkList(int data) {
        Node node = new Node(data);
        head = node;
        tail = node;
        length = 1;
    }

    public int getLength() {
        return length;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void append(int data) {
        Node node = new Node(data);
        tail.next = node;
        tail = node;
        length += 1;
    }

    public void prepend(int data) {
        Node node = new Node(data);
        if (length == 0) {
            head = node;
            tail = node;
        }
        node.next = head;
        head = node;
        length += 1;
    }

    public void removeFirst() {
        if (length == 0) return;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length -= 1;
    }

    public void removeLast() {
        if (length == 0) return;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        pre.next = null;
        tail = pre;
        length -= 1;
    }

    public Node get(int idx) {
        if (idx < 0 || idx > length) return null;
        Node temp = head;
        for (int i = 0; i < idx; i++) temp = temp.next;
        return temp;
    }

    public void set(int idx, int data) {
        Node temp = get(idx);
        temp.data = data;
    }

    public void insert(int idx, int data) {
        if (idx < 0 || idx > length) return;
        Node node = new Node(data);
        if (idx == 0) {
            prepend(data);
            return;
        }
        if (idx == length - 1) {
            append(data);
            return;
        }
        Node pre = get(idx - 1);
        node.next = pre.next;
        pre.next = node;
        length += 1;
    }

    public void remove(int idx) {
        if (idx < 0 || idx > length) return;
        if (idx == 0) {
            removeFirst();
            return;
        }
        if (idx == length - 1) {
            removeLast();
            return;
        }
        Node pre = get(idx - 1);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        length -= 1;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void printList() {
        if (length == 0) return;
        Node temp = head;
        StringJoiner data = new StringJoiner(", ");
        for (int i = 0; i < length; i++) {
            data.add(Integer.toString(temp.data));
            temp = temp.next;
        }
        System.out.printf("[ %s ]%n", data);
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}