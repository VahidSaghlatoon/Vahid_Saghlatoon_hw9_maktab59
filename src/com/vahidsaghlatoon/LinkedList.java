package com.vahidsaghlatoon;


import java.util.NoSuchElementException;

public class LinkedList {

    private Node first;
    private Node last;
    private int size;

    public static void main(String[] args) {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addMiddle(50, 30);
        list.print();
        list.remove(30);
        list.print();

        System.out.println(list.size());
//        list.removeFirst();
//        list.removeLast();
//        System.out.println(list.isEmpty());
//        System.out.println(list.indexOf(20));
//        System.out.println(list.contains(20));


    }

    public void print() {
        if (isEmpty())
            System.out.println("null");
        var current = first;
        System.out.print("[ ");
        while (current.next != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.print(last.value + " ]");
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void remove(int item) {

        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else {
            var itemNode = findNode(item);
            if (itemNode.next != null) {
                var previous = getPrevious(itemNode);
                previous.next = itemNode.next;
            }
            else{
               removeLast();
            }
        }
        size--;

    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else {
            Node previous = getPrevious(last);
            previous.next = null;
            last = previous;
        }
        size--;
    }

    public Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addMiddle(int item, int select) {
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            var selectNode = findNode(select);
            var previous = getPrevious(selectNode);
            previous.next = node;
            node.next = selectNode;
        }
        size++;
    }

    public void addLast(int item) {
        var node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    private Node findNode(int select) {
        var current = first;
        while (current != null) {
            if (current.value == select)
                return current;
            current = current.next;
        }
        return null;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    private class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }


}
