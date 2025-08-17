package Pilha;

public class Pilha {
  private int topo;
  private int tamanho;
  private Object[] elementos;
  public int capacidade;

  public Pilha(int capacidade) {
    this.elementos = new Object[capacidade];
    this.capacidade = capacidade;
    this.tamanho = 0;
    this.topo = 0;
  }

  boolean isEmpty() {
    return tamanho == 0;
  }

  boolean isFull() {
    return tamanho == capacidade;
  }

  Object top() {
    if(isEmpty()) {
      throw new RuntimeException("Pilha vazia");
    }

    return elementos[topo - 1];
  }

  int size() {
    return tamanho;
  }

  void push(Object elemento) {
    if(isFull()) {
     resize();
    }

    elementos[topo] = elemento;
    tamanho++;
    topo++;
  }

  Object pop()  {
    if(isEmpty()) {
      throw new RuntimeException("Pilha vazia");
    }

    Object removedItem = elementos[topo - 1];
    elementos[topo - 1] = null;
    tamanho--;
    topo--;
    return removedItem;
  }

  void resize()  {
    Object[] newElementos = new Object[capacidade * 2];
    for(int i = 0; i < tamanho; i++) {
      newElementos[i] = elementos[i];
    }
    elementos = newElementos;
    capacidade *= 2;
  }
}