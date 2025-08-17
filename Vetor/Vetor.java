package Vetor;

public class Vetor {
  private int[] elementos;
  private int tamanho;

  public Vetor(int capacidade) {
    this.elementos = new int[capacidade];
    this.tamanho = 0;
  }

  public int size() {
    return tamanho;
  }

  public boolean isEmpty() {
    return tamanho == 0;
  }

  public int elemAtRank(int rank) {
    if (rank < 0 || rank >= tamanho) {
      throw new IndexOutOfBoundsException("Rank fora dos limites do vetor.");
    }
    return elementos[rank];
  }

  public int replaceAtRank(int rank, int element) {
    if(rank < 0 || rank >= tamanho) {
      throw new IndexOutOfBoundsException("Rank fora dos limites do vetor.");
    }

    int removedElement = elementos[rank];
    elementos[rank] = element;
    return removedElement;
  }

  public int insertAtRank(int rank, int element) {
    if (rank < 0 || rank > tamanho) {
      throw new IndexOutOfBoundsException("Rank fora dos limites do vetor.");
    }
    if (tamanho == elementos.length) {
      throw new IllegalStateException("Vetor cheio.");
    }

    for (int i = tamanho; i > rank; i--) {
      elementos[i] = elementos[i - 1];
    }
    elementos[rank] = element;
    tamanho++;
    return element;
  }

  public int removeAtRank(int rank) {
    if (rank < 0 || rank >= tamanho) {
      throw new IndexOutOfBoundsException("Rank fora dos limites do vetor.");
    }

    int removedElement = elementos[rank];
    for (int i = rank; i < tamanho - 1; i++) {
      elementos[i] = elementos[i + 1];
    }
    tamanho--;
    return removedElement;
  }
}
