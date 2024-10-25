package Heap;

public class Class_PriorityQueue {
  static class Node {
    int d;
    int p;
    Node next;
  }

  static Node newNode(int d, int p) {
    Node temp = new Node();
    temp.d = d;
    temp.p = p;
    temp.next = null;
    return temp;
  }

  static Node push(Node head, int data, int p) {
    Node temp = head;
    Node new_node = newNode(data, p);
    if (head == null) {
      head = new_node;
      return head;
    }
    if (head.p < new_node.p) {
      new_node.next = head;
      head = new_node;
    } else {
      while (temp.next != null && temp.next.p > p) {
        temp = temp.next;
      }
      new_node.next = temp.next;
      temp.next = new_node;
    }
    return head;
  }

  static int peek(Node head) {
    return head.d;
  }

  static Node pop(Node head) {
    System.out.println("Deleted data->" + head.d);
    head = head.next;
    return head;
  }

  static boolean isEmpty(Node head) {
    if (head == null)
      return true;
    return false;
  }

  static void display(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.d + " " + temp.p + "->");
      temp = temp.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Node Head = null;
    Head = push(Head, 4, 1);
    Head = push(Head, 5, 2);
    Head = push(Head, 6, 3);
    Head = push(Head, 7, 0);
    Head = push(Head, 8, 5);
    display(Head);
  }
}
