package Fila;

public class FilaTeste {
  public static void main(String[] args) {
    System.out.println("=== TESTANDO A IMPLEMENTACAO DA FILA CIRCULAR ===\n");
    
    // 1. Criando uma fila com capacidade inicial 3
    System.out.println("1. Criando uma fila com capacidade 3...");
    Fila fila = new Fila(3);
    System.out.println("Fila criada. Tamanho: " + fila.size() + ", Vazia? " + fila.isEmpty());
    
    // 2. Testando enqueue()
    System.out.println("\n2. Enfileirando 3 elementos (A, B, C)...");
    fila.enqueue("A");
    fila.enqueue("B");
    fila.enqueue("C");
    
    System.out.println("Tamanho atual: " + fila.size());
    System.out.println("Primeiro elemento: " + fila.first());
    System.out.println("Esta cheia? " + fila.isFull());
    
    // 3. Testando o redimensionamento (resize)
    System.out.println("\n3. Enfileirando mais um elemento (D) para forcar o resize...");
    fila.enqueue("D");
    
    System.out.println("Tamanho apos resize: " + fila.size());
    System.out.println("Primeiro elemento (deve ser A): " + fila.first());
    System.out.println("Nova capacidade (deve ser 6): " + fila.capacidade);
    
    // 4. Testando dequeue()
    System.out.println("\n4. Desenfileirando elementos...");
    System.out.println("Elemento removido: " + fila.dequeue());
    System.out.println("Novo primeiro elemento: " + fila.first());
    System.out.println("Tamanho atual: " + fila.size());
    
    System.out.println("\nDesenfileirando mais um elemento...");
    System.out.println("Elemento removido: " + fila.dequeue());
    System.out.println("Novo primeiro elemento: " + fila.first());
    System.out.println("Tamanho atual: " + fila.size());
    
    // 5. Testando comportamento circular
    System.out.println("\n5. Testando comportamento circular (adicionando E, F, G)...");
    fila.enqueue("E");
    fila.enqueue("F");
    fila.enqueue("G");
    System.out.println("Tamanho atual: " + fila.size());
    System.out.println("Primeiro elemento (ainda C): " + fila.first());
    
    // 6. Esvaziando a fila
    System.out.println("\n6. Esvaziando a fila completamente...");
    System.out.println("Removido: " + fila.dequeue()); // C
    System.out.println("Removido: " + fila.dequeue()); // D
    System.out.println("Removido: " + fila.dequeue()); // E
    System.out.println("Removido: " + fila.dequeue()); // F
    System.out.println("Removido: " + fila.dequeue()); // G
    
    System.out.println("Fila vazia? " + fila.isEmpty());
    System.out.println("Tamanho final: " + fila.size());
    
    // 7. Testando exceções em fila vazia
    System.out.println("\n7. Testando operacoes em fila vazia (deve lancar excecao)...");
    try {
      fila.dequeue();
    } catch (RuntimeException e) {
      System.out.println("  - Tentativa de dequeue() em fila vazia: SUCESSO! Excecao capturada: " + e.getMessage());
    }
    
    try {
      fila.first();
    } catch (RuntimeException e) {
      System.out.println("  - Tentativa de first() em fila vazia: SUCESSO! Excecao capturada: " + e.getMessage());
    }
    
    System.out.println("\n=== TODOS OS TESTES CONCLUIDOS ===");
  }
}