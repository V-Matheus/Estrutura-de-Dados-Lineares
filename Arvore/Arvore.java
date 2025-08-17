package Arvore;
import java.util.ArrayList;
import java.util.List;

public class Arvore {
  public class Folha {
    private int valor;

    public Folha(int valor) {
      this.valor = valor;
    }

    public int getValor() {
      return valor;
    }

    public void setValor(int valor) {
      this.valor = valor;
    }
  }
  
  public Folha folha;
  public Arvore esquerda;
  public Arvore direita;
  private int size;

  public Arvore() {
    this.folha = null;
    this.esquerda = null;
    this.direita = null;
    this.size = 0;
  }

  public Arvore(Folha folha) {
    this.folha = folha;
    this.esquerda = null;
    this.direita = null;
    this.size = 1;
  }

  public boolean isEmpty() {
    return this.folha == null;
  }

  public int size() {
    int left = (esquerda != null) ? esquerda.size() : 0;
    int right = (direita != null) ? direita.size() : 0;
    return 1 + left + right;
  }

  public Folha leftChild() {
    return this.esquerda.folha;
  }

  public Folha rightChild() {
    return this.direita.folha;
  }

  public boolean hasLeftChild() {
    return this.esquerda != null;
  }

  public boolean hasRightChild() {
    return this.direita != null;
  }

  public int height() {
    if(this.isEmpty()) {
      return 0;
    } else {
      int leftHeight = this.esquerda != null ? this.esquerda.height() : 0;
      int rightHeight = this.direita != null ? this.direita.height() : 0;
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  public Arvore treeSearch(int valor) {
    if(this.isEmpty()) return null; 

    if(this.folha.getValor() == valor) {
      return this;
    } else if(valor < this.folha.getValor()) {
      if(this.esquerda != null) {
        return this.esquerda.treeSearch(valor);
      } else {
        return null;
      }
    } else {
      if(this.direita != null) {
        return this.direita.treeSearch(valor);
      } else {
        return null;
      }
    }
  }

  public void remove(int valor) {
    if(isEmpty()) return;

    Arvore removedNode = treeSearch(valor);

    if(removedNode == null) return;

    if (removedNode.esquerda == null && removedNode.direita == null) {
      removedNode.folha = null;
      return;
    }

    if (removedNode.esquerda == null) {
      removedNode.folha = removedNode.direita.folha;
      removedNode.esquerda = removedNode.direita.esquerda;
      removedNode.direita = removedNode.direita.direita;
      return;
    }

    if (removedNode.direita == null) {
      removedNode.folha = removedNode.esquerda.folha;
      removedNode.direita = removedNode.esquerda.direita;
      removedNode.esquerda = removedNode.esquerda.esquerda;
      return;
    }

    Arvore parent = removedNode;
    Arvore successor = removedNode.direita;

    while (successor.esquerda != null) {
      parent = successor;
      successor = successor.esquerda;
    }

    removedNode.folha = successor.folha;
    if (parent == removedNode) {
        parent.direita = successor.direita;
    } else {
        parent.esquerda = successor.direita;
    }
  }
  
  public void inserir(Object value) {
    Arvore.Folha novo =  new Folha((int) value);
    if(isEmpty()) {
      this.folha = novo;
      size++;
    } else {
      Arvore novaArvore = new Arvore(novo);

      if(novo.getValor() < this.folha.getValor()) {
        if(this.esquerda == null) {
          this.esquerda = novaArvore;
          size++;
          System.out.println("Inserindo " + novo.getValor() + " na subarvore esquerda de " + this.folha.getValor());
        } else {
          this.esquerda.inserir(novo.valor);
        }

      } else if(novo.getValor() > this.folha.getValor()) {
        if(this.direita == null) {
          this.direita = novaArvore;
          size++;
            System.out.println("Inserindo " + novo.getValor() + " na subarvore direita de " + this.folha.getValor());
        } else {
          this.direita.inserir(novo.valor);
        }
      }
    }
  }

  public void preOrder(List<Object> lista) {
    if (folha == null) return;

    lista.add(folha.getValor());

    if (esquerda != null) {
      esquerda.preOrder(lista);
    }

    if (direita != null) {
      direita.preOrder(lista);
    }
  }

  public void inOrder(List<Object> lista) {
    if (folha == null) return;

    if (esquerda != null) {
      esquerda.inOrder(lista);
    }

    lista.add(folha.getValor());

    if (direita != null) {
      direita.inOrder(lista);
    }
  }

  public void postOrder(List<Object> lista) {
    if (folha == null) return;

    if (esquerda != null) {
      esquerda.postOrder(lista);
    }

    if (direita != null) {
      direita.postOrder(lista);
    }

    lista.add(folha.getValor());
  }

  public void imprimir() {
    int height = height();
    int width = size();  

    String[][] matriz = new String[height][width];
    
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
          matriz[i][j] = " ";
      }
    }

    preencherMatriz(matriz, this, 0, 0, width - 1);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
          System.out.print(matriz[i][j]);
      }
      System.out.println();
    }
  }

  private void preencherMatriz(String[][] matriz, Arvore node, int row, int left, int right) {
    if (node == null || node.folha == null) return;
    int mid = (left + right) / 2;
    matriz[row][mid] = String.valueOf(node.folha.getValor());
    preencherMatriz(matriz, node.esquerda, row + 1, left, mid - 1);
    preencherMatriz(matriz, node.direita, row + 1, mid + 1, right);
  }

  public boolean editarValor(int valorAntigo, int valorNovo) {
    Arvore nodeEncontrado = treeSearch(valorAntigo);
    
    if (nodeEncontrado == null) {
      System.out.println("Valor " + valorAntigo + " nao encontrado na arvore.");
      return false;
    }
    
    Arvore valorExiste = treeSearch(valorNovo);
    if (valorExiste != null) {
      System.out.println("Valor " + valorNovo + " ja existe na arvore. Nao e possivel duplicar.");
      return false;
    }
    
    remove(valorAntigo);
    inserir(new Folha(valorNovo));
    
    System.out.println("Valor " + valorAntigo + " alterado para " + valorNovo + " com sucesso.");
    return true;
  }
}