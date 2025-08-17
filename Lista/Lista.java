package Lista;

public class Lista {
  public class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int value) {
      this.value = value;
      this.next = null;
      this.prev = null;
    }
  }

  Node head;
  Node tail;
  int size;

  public Lista() {
    this.head = new Node(Integer.MIN_VALUE);
    this.tail = new Node(Integer.MAX_VALUE);
    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Node first() {
    if (isEmpty()) {
      throw new IllegalStateException("A lista está vazia.");
    }
    return head.next;
  }

  public Node last() {
    if (isEmpty()) {
      throw new IllegalStateException("A lista está vazia.");
    }
    return tail.prev;
  }

  public Node before(Node node) {
    if (node.prev == head) {
       throw new IllegalArgumentException("Não existe nó antes do primeiro elemento.");
    }
    return node.prev;
  }

  public Node after(Node node) {
    if (node.next == tail) {
       throw new IllegalArgumentException("Não existe nó depois do último elemento.");
    }
    return node.next;
  }

  public void replaceElement(Node node, int element) {
    if (node == head || node == tail) {
      throw new IllegalArgumentException("Não é possível substituir o elemento do head ou tail.");
    }
    node.value = element;
  }

  public void swapElements(Node node1, Node node2) {
    if (node1 == head || node1 == tail || node2 == head || node2 == tail) {
      throw new IllegalArgumentException("Não é possível trocar elementos do head ou tail.");
    }
    int temp = node1.value;
    node1.value = node2.value;
    node2.value = temp;
  }

  public void insertBefore(Node node, int element) {
    if (node == head) {
      throw new IllegalArgumentException("Não é possível inserir antes do head.");
    }
    Node newNode = new Node(element);
    newNode.prev = node.prev;
    newNode.next = node;
    node.prev.next = newNode;
    node.prev = newNode;
    size++;
  }

  public void insertAfter(Node node, int element) {
    if (node == tail) {
      throw new IllegalArgumentException("Não é possível inserir depois do tail.");
    }
    Node newNode = new Node(element);
    newNode.prev = node;
    newNode.next = node.next;
    node.next.prev = newNode;
    node.next = newNode;
    size++;
  }

  public void insertFirst(int element) {
    insertAfter(head, element);
  }

  public void insertLast(int element) {
    insertBefore(tail, element);
  }

  public Node remove(Node node) {
    if (node == head || node == tail) {
      throw new IllegalArgumentException("Não é possível remover o head ou tail.");
    }
    node.prev.next = node.next;
    node.next.prev = node.prev;
    size--;
    node.next = null;
    node.prev = null;
    return node;
  }

  public Node atRank(int rank) {
    if (rank < 0 || rank >= size) {
      throw new IndexOutOfBoundsException("Rank fora dos limites.");
    }
    Node current = head.next;
    for (int i = 0; i < rank; i++) {
      current = current.next;
    }
    return current;
  }

  public int rankOf(Node node) {
    if (node == head || node == tail) {
      throw new IllegalArgumentException("Head ou tail não possuem rank.");
    }
    Node current = head.next;
    int rank = 0;
    while (current != tail) {
      if (current == node) {
        return rank;
      }
      current = current.next;
      rank++;
    }
    throw new IllegalArgumentException("Nó não pertence à lista.");
  }
}
