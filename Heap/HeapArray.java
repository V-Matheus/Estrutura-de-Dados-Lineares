public class HeapArray {
  private int[] heap;
  private int size;

  public HeapArray(int capacity) {
    this.heap = new int[capacity];
    this.size = 1;
  }

  public void insert(int value) {
    if(isFull()) System.out.println("Heap is full");

    heap[size] = value;
    upheap(size);
    size++;
  }

  public void upheap(int filho) {
    if (filho <= 1) return;
    int pai = filho / 2;

    if(heap[filho] > heap[pai]) {
      int temp = heap[filho];
      heap[filho] = heap[pai];
      heap[pai] = temp;
      upheap(pai);
    }
  }

  public int min() {
    if (isEmpty()) return -1;
    int min = heap[size / 2];
  
    for (int i = size / 2; i < size; i++) {
      if (heap[i] < min) {
        min = heap[i];
      }
    }
  
    return min;
  }

  public int remove() {
    int root = heap[1];

    heap[1] = heap[size - 1];
    downheap(1);
    size--;
    return root;
  }

  public void sort() {
    if(isEmpty()) {
      System.out.println("Heap is empty");
      return;
    }

    int originalSize = size;

    for(int  i = originalSize - 1; i > 0; i--) {
      int temp = heap[1];
      heap[1] = heap[i];
      heap[i] = temp;
      size--;

      downheap(1);
    }

    size = originalSize;
  }

  public void downheap(int pai) {
    int filhoEsquerdo = pai * 2;
    int filhoDireito = pai * 2 + 1;

    int maior = pai;

    if(filhoEsquerdo < size && heap[filhoEsquerdo] > heap[maior]) {
      maior = filhoEsquerdo;
    }
    
    if(filhoDireito < size && heap[filhoDireito] > heap[maior]) {
      maior = filhoDireito;
    }

    if(maior != pai) {
      int temp = heap[pai];
      heap[pai] = heap[maior];
      heap[maior] = temp;
      downheap(maior);
    }
  }


  public boolean isFull() {
    return size == heap.length;
  }

  public boolean isEmpty() {
    return size == 1;
  }

  public void showHeap() {
    for(int i = 1; i < size; i++) {
      System.out.print(heap[i] + " ");
    }
    System.out.println();
  }

  public void showSorted() {
    for(int i = 1; i < size; i++) {
      System.out.print(heap[i] + " ");
    }
    System.out.println();
  }
}