package Lista;

public class ListaTeste {
  public static void main(String[] args) {
    System.out.println("=== TESTANDO A IMPLEMENTACAO DA LISTA DUPLAMENTE LIGADA ===\n");
    
    // 1. Criando uma lista
    System.out.println("1. Criando uma lista...");
    Lista lista = new Lista();
    System.out.println("Lista criada. Tamanho: " + lista.size() + ", Vazia? " + lista.isEmpty());
    imprimirLista(lista);
    
    // 2. Inserindo elementos
    System.out.println("\n2. Inserindo elementos...");
    System.out.println("   - Inserindo 10 no final (insertLast)");
    lista.insertLast(10);
    imprimirLista(lista);
    
    System.out.println("   - Inserindo 20 no final (insertLast)");
    lista.insertLast(20);
    imprimirLista(lista);
    
    System.out.println("   - Inserindo 5 no início (insertFirst)");
    lista.insertFirst(5);
    imprimirLista(lista);
    
    // 3. Acessando elementos
    System.out.println("\n3. Acessando elementos...");
    System.out.println("   - Primeiro elemento (deve ser 5): " + lista.first().value);
    System.out.println("   - Último elemento (deve ser 20): " + lista.last().value);
    
    // 4. Testando atRank e rankOf
    System.out.println("\n4. Testando rank e acesso por rank...");
    Lista.Node noRank1 = lista.atRank(1);
    System.out.println("   - Nó no rank 1 (deve ser 10): " + noRank1.value);
    System.out.println("   - Rank do nó com valor 10 (deve ser 1): " + lista.rankOf(noRank1));
    
    // 5. Inserção no meio
    System.out.println("\n5. Inserindo no meio da lista...");
    System.out.println("   - Inserindo 7 antes do nó 10 (insertBefore)");
    lista.insertBefore(noRank1, 7);
    imprimirLista(lista);
    
    System.out.println("   - Inserindo 15 depois do nó 10 (insertAfter)");
    lista.insertAfter(noRank1, 15);
    imprimirLista(lista);
    
    // 6. Modificando elementos
    System.out.println("\n6. Modificando elementos...");
    Lista.Node noRank3 = lista.atRank(3); // Nó com valor 15
    System.out.println("   - Trocando valor do nó no rank 3 (15) por 18 (replaceElement)");
    lista.replaceElement(noRank3, 18);
    imprimirLista(lista);
    
    System.out.println("   - Trocando os elementos dos nós nos ranks 0 e 4 (swapElements)");
    lista.swapElements(lista.atRank(0), lista.atRank(4));
    imprimirLista(lista);
    
    // 7. Removendo elementos
    System.out.println("\n7. Removendo elementos...");
    System.out.println("   - Removendo o primeiro elemento (rank 0)");
    lista.remove(lista.first());
    imprimirLista(lista);
    
    System.out.println("   - Removendo o último elemento (rank 3)");
    lista.remove(lista.last());
    imprimirLista(lista);
    
    System.out.println("   - Removendo o elemento do meio (rank 1, valor 10)");
    lista.remove(lista.atRank(1));
    imprimirLista(lista);
    
    // 8. Testando before e after
    System.out.println("\n8. Testando before e after...");
    System.out.println("   - Elemento antes de 18 (deve ser 7): " + lista.before(lista.last()).value);
    System.out.println("   - Elemento depois de 7 (deve ser 18): " + lista.after(lista.first()).value);
    
    // 9. Esvaziando a lista e testando exceções
    System.out.println("\n9. Esvaziando a lista e testando exceções...");
    lista.remove(lista.first());
    lista.remove(lista.first());
    System.out.println("Lista vazia? " + lista.isEmpty());
    
    try {
      lista.first();
    } catch (IllegalStateException e) {
      System.out.println("   - first() em lista vazia: SUCESSO! Exceção capturada.");
    }
    try {
      lista.atRank(0);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("   - atRank(0) em lista vazia: SUCESSO! Exceção capturada.");
    }
    
    System.out.println("\n=== TODOS OS TESTES CONCLUIDOS ===");
  }
  
  // Método auxiliar para imprimir o estado atual da lista
  public static void imprimirLista(Lista l) {
    System.out.print("   Estado da Lista: [");
    if (!l.isEmpty()) {
      Lista.Node current = l.first();
      while (true) {
        System.out.print(current.value);
        if (current == l.last()) {
          break;
        }
        System.out.print(", ");
        current = l.after(current);
      }
    }
    System.out.println("] (Tamanho: " + l.size() + ")");
  }
}