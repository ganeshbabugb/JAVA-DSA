package datastructures.linklist;

public class Main {
    public static void main(String[] args) {
        System.out.println("LinkList");
        LinkList list = new LinkList(4);

        list.append(1);
        list.append(2);
        list.append(3);

        list.prepend(5);
        list.prepend(8);
        list.prepend(9);

//        list.removeFirst();
//        list.removeFirst();
//        list.removeFirst();
//
//        list.removeLast();
//        list.removeLast();
//        list.removeLast();

        System.out.println(list.get(1).data);
        System.out.println(list.get(2).data);


        list.set(1, 5);
        list.set(2, 6);

        list.insert(0, 500);

        list.remove(99);

        list.reverse();

        int length = list.getLength();
        int head = list.getHead().data;
        int tail = list.getTail().data;
        System.out.println("length = " + length);
        System.out.println("head = " + head);
        System.out.println("tail = " + tail);
        System.out.print("list = ");
        list.printList();
    }
}