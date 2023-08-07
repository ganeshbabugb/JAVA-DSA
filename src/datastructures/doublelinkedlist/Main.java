package datastructures.doublelinkedlist;

public class Main {
    public static void main(String[] args) {
        System.out.println("DoublyLinkedList");
        DoublyLinkedList DLL = new DoublyLinkedList(5);

/*
        DLL.append(5);
        DLL.append(4);
        DLL.append(3);
        DLL.append(1);
*/

/*
        System.out.println(DLL.removeLast().data);
        System.out.println(DLL.removeLast().data);
        System.out.println(DLL.removeLast().data);
        System.out.println(DLL.removeLast().data);
*/


        DLL.prepend(1);
        DLL.prepend(2);
        DLL.prepend(3);
        DLL.prepend(4);


/*
        DLL.removeFirst();
        DLL.removeFirst();
        DLL.removeFirst();
        DLL.removeFirst();
*/

        DLL.remove(2);


        int headValue = DLL.getHead().data;
        int tailValue = DLL.getTail().data;
        int length = DLL.getLength();
        System.out.println("headValue = " + headValue);
        System.out.println("tailValue = " + tailValue);
        System.out.println("length = " + length);
        DLL.printList();
    }
}
