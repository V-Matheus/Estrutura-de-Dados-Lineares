package Fila;

public class FilaNo {
  public class Node {
    public Node next;
    public Node prev;
    public Object data;

    public Node(Object data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

  private Node head;
  private Node tail;
  private int size;

  public FilaNo() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void enqueue(Object data) {
    Node newNode = new Node(data);
    if(size() == 0) {
      head.next = newNode;
      tail.prev = newNode;
      return;
    }

    newNode.prev = tail.prev;
    newNode.next = tail;
    tail.prev.next = newNode;
    tail.prev = newNode;
  }

  public Object dequeue() {
    if(size() == 0) {
      return null;
    }

    Node removedNode = head.next;
    head.next = removedNode.next;
    if(head.next != null) {
      head.next.prev = head;
    } else {
      tail.prev = null;
    }
    size--;
    return removedNode.data;
  }

  int size() {
    return size;
  }
}
