package Vetor;

public class VetorTeste {
  public static void main(String[] args) {
    System.out.println("=== TESTANDO A IMPLEMENTACAO DO VETOR ===\n");
    
    // 1. Criando um vetor com capacidade 5
    System.out.println("1. Criando um vetor com capacidade 5...");
    Vetor vetor = new Vetor(5);
    System.out.println("Vetor criado. Tamanho: " + vetor.size() + ", Vazio? " + vetor.isEmpty());
    imprimirVetor(vetor);
    
    // 2. Testando insertAtRank()
    System.out.println("\n2. Inserindo elementos...");
    System.out.println("   - Inserindo 10 no rank 0");
    vetor.insertAtRank(0, 10);
    imprimirVetor(vetor);
    
    System.out.println("   - Inserindo 30 no rank 1");
    vetor.insertAtRank(1, 30);
    imprimirVetor(vetor);
    
    System.out.println("   - Inserindo 20 no rank 1 (empurrando o 30)");
    vetor.insertAtRank(1, 20);
    imprimirVetor(vetor);
    
    System.out.println("   - Inserindo 50 no rank 3 (final)");
    vetor.insertAtRank(3, 50);
    imprimirVetor(vetor);
    
    System.out.println("   - Inserindo 40 no rank 3 (empurrando o 50)");
    vetor.insertAtRank(3, 40);
    imprimirVetor(vetor);
    
    // 3. Testando exceção de vetor cheio
    System.out.println("\n3. Tentando inserir em vetor cheio...");
    try {
      vetor.insertAtRank(5, 60);
    } catch (IllegalStateException e) {
      System.out.println("   SUCESSO! Excecao capturada: " + e.getMessage());
    }
    
    // 4. Testando elemAtRank() e replaceAtRank()
    System.out.println("\n4. Acessando e substituindo elementos...");
    System.out.println("   - Elemento no rank 2 (deve ser 30): " + vetor.elemAtRank(2));
    System.out.println("   - Substituindo rank 2 por 35...");
    int antigo = vetor.replaceAtRank(2, 35);
    System.out.println("   - Valor antigo era (deve ser 30): " + antigo);
    imprimirVetor(vetor);
    
    // 5. Testando removeAtRank()
    System.out.println("\n5. Removendo elementos...");
    System.out.println("   - Removendo do rank 1 (elemento 20)...");
    int removido1 = vetor.removeAtRank(1);
    System.out.println("   - Valor removido (deve ser 20): " + removido1);
    imprimirVetor(vetor);
    
    System.out.println("   - Removendo do rank 3 (último elemento, 50)...");
    int removido2 = vetor.removeAtRank(3);
    System.out.println("   - Valor removido (deve ser 50): " + removido2);
    imprimirVetor(vetor);
    
    // 6. Testando exceções de rank inválido
    System.out.println("\n6. Testando excecoes de rank invalido...");
    try {
      vetor.elemAtRank(10);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("   - elemAtRank(10): SUCESSO! Excecao capturada.");
    }
    try {
      vetor.insertAtRank(-1, 99);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("   - insertAtRank(-1): SUCESSO! Excecao capturada.");
    }
    try {
      vetor.removeAtRank(vetor.size());
    } catch (IndexOutOfBoundsException e) {
      System.out.println("   - removeAtRank(tamanho): SUCESSO! Excecao capturada.");
    }
    
    // 7. Esvaziando o vetor
    System.out.println("\n7. Esvaziando o vetor...");
    vetor.removeAtRank(0);
    vetor.removeAtRank(0);
    vetor.removeAtRank(0);
    System.out.println("Vetor vazio? " + vetor.isEmpty());
    imprimirVetor(vetor);
    
    System.out.println("\n=== TODOS OS TESTES CONCLUIDOS ===");
  }
  
  // Método auxiliar para imprimir o estado atual do vetor
  public static void imprimirVetor(Vetor v) {
    System.out.print("   Estado do Vetor: [");
    for (int i = 0; i < v.size(); i++) {
      System.out.print(v.elemAtRank(i));
      if (i < v.size() - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("] (Tamanho: " + v.size() + ")");
  }
}