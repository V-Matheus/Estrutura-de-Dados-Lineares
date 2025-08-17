public class HeapNo {
  private class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  private Node root;
  private int size;

  public HeapNo() {
    this.root = null;
    this.size = 0;
  }

  public void insert(int value) {
    Node newNode = new Node(value);
    size++;

    if(root == null) {
      root = newNode;
      return;
    }

    Node[] nodes = new Node[size];
    nodes[0] = root;
    int idx = 0, count = 1;

    while (idx < count) {
      Node current = nodes[idx];

      if (current.left == null) {
        current.left = newNode;
        break;
      } else {
        nodes[count++] = current.left;
      }

      if (current.right == null) {
        current.right = newNode;
        break;
      } else {
        nodes[count++] = current.right;
      }

      idx++;
    }
  }

  public Node remove() {
    if (root == null) {
      return null;
    }

    Node removedNode = root;

    Node[] nodes = new Node[size];
    nodes[0] = root;
    int idx = 0, count = 1;
    Node lastParent = null;
    Node lastNode = null;

    while (idx < count) {
      Node current = nodes[idx];

      if (current.left != null) {
        lastParent = current;
        lastNode = current.left;
        nodes[count++] = current.left;
      }
      if (current.right != null) {
        lastParent = current;
        lastNode = current.right;
        nodes[count++] = current.right;
      }
      idx++;
    }

    if (lastNode != null && root != lastNode) {
      root.value = lastNode.value;
      if (lastParent.right == lastNode) {
        removedNode = lastParent.right;
        lastParent.right = null;
      } else {
        removedNode = lastParent.left;
        lastParent.left = null;
      }
    } else {
      root = null;
    }

    size--;
    return removedNode;
  }


  public boolean isEmpty() {
    return size == 0;
  }
}
