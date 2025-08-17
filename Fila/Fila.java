package Fila;

public class Fila {
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

  Object first() {
    if (isEmpty()) {
      throw new RuntimeException("Fila vazia");
    }
    return elementos[inicio];
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
