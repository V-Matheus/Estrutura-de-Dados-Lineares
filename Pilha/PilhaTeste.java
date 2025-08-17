package Pilha;

public class PilhaTeste {
  public static void main(String[] args) {
    System.out.println("=== TESTANDO A IMPLEMENTACAO DA PILHA ===\n");
    
    // 1. Criando uma pilha com capacidade inicial 3
    System.out.println("1. Criando uma pilha com capacidade 3...");
    Pilha pilha = new Pilha(3);
    System.out.println("Pilha criada. Tamanho: " + pilha.size() + ", Vazia? " + pilha.isEmpty());
    
    // 2. Testando push()
    System.out.println("\n2. Empilhando 3 elementos (10, 20, 30)...");
    pilha.push(10);
    pilha.push(20);
    pilha.push(30);
    
    System.out.println("Tamanho atual: " + pilha.size());
    System.out.println("Elemento no topo: " + pilha.top());
    System.out.println("Esta cheia? " + pilha.isFull());
    
    // 3. Testando o redimensionamento (resize)
    System.out.println("\n3. Empilhando mais um elemento (40) para forcar o resize...");
    pilha.push(40);
    
    System.out.println("Tamanho apos resize: " + pilha.size());
    System.out.println("Elemento no topo: " + pilha.top());
    System.out.println("Nova capacidade (deve ser 6): " + pilha.capacidade);
    
    // 4. Testando pop()
    System.out.println("\n4. Desempilhando elementos...");
    System.out.println("Elemento removido: " + pilha.pop());
    System.out.println("Novo topo: " + pilha.top());
    System.out.println("Tamanho atual: " + pilha.size());
    
    System.out.println("\nDesempilhando mais dois elementos...");
    System.out.println("Elemento removido: " + pilha.pop());
    System.out.println("Elemento removido: " + pilha.pop());
    System.out.println("Novo topo: " + pilha.top());
    System.out.println("Tamanho atual: " + pilha.size());
    
    // 5. Esvaziando a pilha
    System.out.println("\n5. Esvaziando a pilha...");
    System.out.println("Elemento removido: " + pilha.pop());
    System.out.println("Pilha vazia? " + pilha.isEmpty());
    System.out.println("Tamanho final: " + pilha.size());
    
    // 6. Testando exceções em pilha vazia
    System.out.println("\n6. Testando operacoes em pilha vazia (deve lancar excecao)...");
    try {
      pilha.pop();
    } catch (RuntimeException e) {
      System.out.println("  - Tentativa de pop() em pilha vazia: SUCESSO! Excecao capturada: " + e.getMessage());
    }
    
    try {
      pilha.top();
    } catch (RuntimeException e) {
      System.out.println("  - Tentativa de top() em pilha vazia: SUCESSO! Excecao capturada: " + e.getMessage());
    }
    
    System.out.println("\n=== TODOS OS TESTES CONCLUIDOS ===");
  }
}