package Pilha;

public class Pilha2Fila {
  class Fila {
    private int inicio;
    private int fim;
    private int tamanho;
    private Object[] elementos;
    public int capacidade;

    public Fila(int capacidade) {
      this.elementos = new Object[capacidade];
      this.capacidade = capacidade;
      this.tamanho = 0;
      this.inicio = 0;
      this.fim = 0;
    }
    
    boolean isEmpty() {
      return tamanho == 0;
    }

    boolean isFull() {
      return tamanho == capacidade;
    }

    int size() {
      return tamanho;
    }
    
    void enqueue(Object elemento) {
      if (isFull()) {
        resize();
      }
      elementos[fim] = elemento;
      fim = (fim + 1) % capacidade;
      tamanho++;
    }

    Object dequeue() {
      if (isEmpty()) {
        throw new RuntimeException("Fila vazia");
      }
      Object removedItem = elementos[inicio];
      elementos[inicio] = null;
      inicio = (inicio + 1) % capacidade;
      tamanho--;
      return removedItem;
    }

    void resize() {
      Object[] newElementos = new Object[capacidade * 2];
      for (int i = 0; i < tamanho; i++) {
        newElementos[i] = elementos[(inicio + i) % capacidade];
      }
      elementos = newElementos;
      capacidade *= 2;
      inicio = 0;
      fim = tamanho;
    }
  }

  private Fila fila1;
  private Fila fila2;
  private int tamanho;
  private int capacidade;

  public Pilha2Fila(int capacidade) {
    this.fila1 = new Fila(capacidade);
    this.fila2 = new Fila(capacidade);
    this.tamanho = 0;
    this.capacidade = capacidade;
  }

  public void push(Object elemento) {
    if (fila1.isFull()) {
      throw new RuntimeException("Pilha cheia");
    }
    fila1.enqueue(elemento);
    tamanho++;
  }

  public Object pop() {
    if (fila1.isEmpty()) {
      throw new RuntimeException("Pilha vazia");
    }

    while (fila1.size() > 1) {
      fila2.enqueue(fila1.dequeue());
    }
    Object removedItem = fila1.dequeue();
    tamanho--;
    
    Fila temp = fila1;
    fila1 = fila2;
    fila2 = temp;

    return removedItem;
  }
}
