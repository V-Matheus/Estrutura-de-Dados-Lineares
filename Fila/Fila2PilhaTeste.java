package Fila;

public class Fila2PilhaTeste {
  public static void main(String[] args) {
    System.out.println("=== TESTANDO A IMPLEMENTACAO DA FILA COM DUAS PILHAS ===\n");
    
    // 1. Criando uma fila com capacidade inicial 5
    System.out.println("1. Criando uma Fila com capacidade 5...");
    Fila2Pilha fila = new Fila2Pilha(5);
    
    // 2. Enfileirando 3 elementos
    System.out.println("\n2. Enfileirando 3 elementos: 10, 20, 30");
    fila.enqueue(10);
    fila.enqueue(20);
    fila.enqueue(30);
    System.out.println("   -> Elementos foram para a Pilha 1.");
    
    // 3. Desenfileirando o primeiro elemento
    System.out.println("\n3. Desenfileirando o primeiro elemento...");
    System.out.println("   -> Pilha 2 esta vazia, transferindo da Pilha 1 para a 2...");
    Object primeiro = fila.dequeue();
    System.out.println("   Elemento removido (deve ser 10): " + primeiro);
    
    // 4. Desenfileirando mais um elemento
    System.out.println("\n4. Desenfileirando o proximo elemento...");
    System.out.println("   -> Pilha 2 nao esta vazia, remove direto dela...");
    Object segundo = fila.dequeue();
    System.out.println("   Elemento removido (deve ser 20): " + segundo);
    
    // 5. Enfileirando mais elementos
    System.out.println("\n5. Enfileirando mais 2 elementos: 40, 50");
    fila.enqueue(40);
    fila.enqueue(50);
    System.out.println("   -> Elementos foram para a Pilha 1.");
    
    // 6. Esvaziando a fila
    System.out.println("\n6. Esvaziando a fila completamente...");
    System.out.println("   Removido (deve ser 30): " + fila.dequeue());
    System.out.println("   -> Pilha 2 esvaziou, transferindo da Pilha 1 para a 2...");
    System.out.println("   Removido (deve ser 40): " + fila.dequeue());
    System.out.println("   Removido (deve ser 50): " + fila.dequeue());
    
    // 7. Testando dequeue em fila vazia
    System.out.println("\n7. Tentando desenfileirar de uma fila vazia...");
    Object vazio = fila.dequeue();
    System.out.println("   Resultado (deve ser null): " + vazio);
    
    System.out.println("\n=== TODOS OS TESTES CONCLUIDOS ===");
  }
}