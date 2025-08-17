package Fila;

public class Fila2Pilha {
  class Pilha {
    private Object[] stack;
    private int top;
    private int tamanho;
    private int capacidade;

    public Pilha(int capacidadeInicial) {
      this.capacidade = capacidadeInicial;
      this.stack = new Object[capacidadeInicial];
      this.top = 0;
      this.tamanho = 0;
    }

    boolean isEmpty() {
      return tamanho == 0;
    }

    boolean isFull() {
      return tamanho == capacidade;
    }

    void push(Object elemento) {
      if(isFull()) {
      resize();
      }

      stack[top] = elemento;
      tamanho++;
      top++;
    }

    Object pop()  {
      if(isEmpty()) {
        throw new RuntimeException("Pilha vazia");
      }

      Object removedItem = stack[top - 1];
      stack[top - 1] = null;
      tamanho--;
      top--;
      return removedItem;
    }

    void resize()  {
      Object[] newElementos = new Object[capacidade * 2];
      for(int i = 0; i < tamanho; i++) {
        newElementos[i] = stack[i];
      }
      stack = newElementos;
      capacidade *= 2;
    }
  }

  private Pilha pilha1;
  private Pilha pilha2;

  public Fila2Pilha(int capacidade) {
    this.pilha1 = new Pilha(capacidade);
    this.pilha2 = new Pilha(capacidade);
  }

  public void enqueue(Object data) {
    pilha1.push(data);
  }

  public Object dequeue() {
    if(pilha2.isEmpty()) {
      while(!pilha1.isEmpty()) {
        pilha2.push(pilha1.pop());
      }
    }

    if(pilha2.isEmpty()) {
      return null; 
    }

    return pilha2.pop();  
  }
}
