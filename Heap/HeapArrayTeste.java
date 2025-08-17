public class HeapArrayTeste {
  public static void main(String[] args) {
    HeapArray heap = new HeapArray(10);
    
    heap.insert(5);
    heap.insert(3);
    heap.insert(8);
    heap.insert(1);
    heap.insert(7);
    heap.insert(6);
    heap.insert(2);
    heap.insert(4);

    heap.showHeap();
    
    System.out.println("Removed: " + heap.remove());
    System.out.println("Removed: " + heap.remove());

    heap.showHeap();

    System.out.println("Valor mínimo: " + heap.min());

    heap.sort();
    System.out.println("Array ordenado:");
    heap.showSorted();
  }
}
