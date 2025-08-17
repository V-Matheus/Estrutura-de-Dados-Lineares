package Pilha;

public class Pilha2FilaTeste {
  public static void main(String[] args) {
    System.out.println("=== TESTANDO A IMPLEMENTACAO DA PILHA COM DUAS FILAS ===\n");
    
    // 1. Criando uma pilha com capacidade inicial 4
    System.out.println("1. Criando uma Pilha com capacidade 4...");
    Pilha2Fila pilha = new Pilha2Fila(4);
    
    // 2. Empilhando 3 elementos
    System.out.println("\n2. Empilhando 3 elementos: 'A', 'B', 'C'");
    pilha.push("A");
    pilha.push("B");
    pilha.push("C");
    System.out.println("   -> Elementos foram enfileirados na Fila 1.");
    
    // 3. Desempilhando o primeiro elemento
    System.out.println("\n3. Desempilhando o primeiro elemento...");
    System.out.println("   -> Movendo 'A' e 'B' para a Fila 2...");
    Object primeiro = pilha.pop();
    System.out.println("   Elemento removido (deve ser 'C'): " + primeiro);
    System.out.println("   -> As filas foram trocadas. Fila 1 agora contem 'A' e 'B'.");
    
    // 4. Desempilhando mais um elemento
    System.out.println("\n4. Desempilhando o proximo elemento...");
    System.out.println("   -> Movendo 'A' para a Fila 2...");
    Object segundo = pilha.pop();
    System.out.println("   Elemento removido (deve ser 'B'): " + segundo);
    
    // 5. Empilhando mais elementos
    System.out.println("\n5. Empilhando mais 2 elementos: 'D', 'E'");
    pilha.push("D");
    pilha.push("E");
    System.out.println("   -> Fila 1 agora contem 'A', 'D', 'E'.");
    
    // 6. Esvaziando a pilha
    System.out.println("\n6. Esvaziando a pilha completamente...");
    System.out.println("   Removido (deve ser 'E'): " + pilha.pop());
    System.out.println("   Removido (deve ser 'D'): " + pilha.pop());
    System.out.println("   Removido (deve ser 'A'): " + pilha.pop());
    
    // 7. Testando pop em pilha vazia
    System.out.println("\n7. Tentando desempilhar de uma pilha vazia...");
    try {
      pilha.pop();
    } catch (RuntimeException e) {
      System.out.println("   SUCESSO! Excecao capturada: " + e.getMessage());
    }
    
    // 8. Testando push em pilha cheia
    System.out.println("\n8. Enchendo a pilha para testar o limite...");
    pilha.push(1);
    pilha.push(2);
    pilha.push(3);
    pilha.push(4);
    System.out.println("   Pilha cheia. Tentando empilhar mais um elemento...");
    try {
      pilha.push(5);
    } catch (RuntimeException e) {
      System.out.println("   SUCESSO! Excecao capturada: " + e.getMessage());
    }
    
    System.out.println("\n=== TODOS OS TESTES CONCLUIDOS ===");
  }
}