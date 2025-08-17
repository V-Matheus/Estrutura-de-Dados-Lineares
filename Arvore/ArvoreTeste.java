package Arvore;
import java.util.List;

import java.util.ArrayList;

public class ArvoreTeste {
  public static void main(String[] args) {
    System.out.println("=== TESTE: inOrder e eArvoreBinariaDePesquisa ===\n");
    
    // TESTE 1: Arvore VALIDA (criada com insercoes corretas)
    System.out.println("1. ARVORE BINARIA DE PESQUISA VALIDA:");
    Arvore arvoreValida = new Arvore();
    
    arvoreValida.inserir(50);
    arvoreValida.inserir(30);
    arvoreValida.inserir(70);
    arvoreValida.inserir(20);
    arvoreValida.inserir(40);
    arvoreValida.inserir(60);
    arvoreValida.inserir(80);
    
    System.out.println("\nEstrutura da arvore valida:");
    System.out.println("      50");
    System.out.println("     /  \\");
    System.out.println("   30    70");
    System.out.println("  / \\   / \\");
    System.out.println(" 20 40 60 80");
    
    List<Object> inOrderValida = new ArrayList<>();
    arvoreValida.inOrder(inOrderValida);
    System.out.println("\ninOrder da arvore valida: " + inOrderValida);
    
    boolean isABPValida = eArvoreBinariaDePesquisa(arvoreValida);
    System.out.println("E uma ABP? " + isABPValida);
    System.out.println("Explicacao: inOrder resulta em sequencia CRESCENTE [20,30,40,50,60,70,80]");
    
    // TESTE 2: Simulando uma arvore INVALIDA
    System.out.println("\n" + "=".repeat(60));
    System.out.println("2. SIMULANDO ARVORE BINARIA QUE NAO E DE PESQUISA:");
    
    // Criamos uma arvore e depois "corrompemos" manualmente
    Arvore arvoreInvalida = new Arvore();
    arvoreInvalida.inserir(50);
    arvoreInvalida.inserir(30);
    arvoreInvalida.inserir(70);
    
    // CORROMPEMOS a arvore: colocamos 80 na subarvore esquerda (ERRO!)
    // Isso viola a propriedade da ABP: esquerda deve ser < raiz
    arvoreInvalida.esquerda.direita = new Arvore(arvoreInvalida.new Folha(80)); // 80 > 50, mas esta a esquerda!
    arvoreInvalida.direita.esquerda = new Arvore(arvoreInvalida.new Folha(25)); // 25 < 70, mas esta a direita!
    
    System.out.println("\nEstrutura da arvore INVALIDA (corrompida):");
    System.out.println("      50");
    System.out.println("     /  \\");
    System.out.println("   30    70");
    System.out.println("     \\   /");
    System.out.println("     80 25  <- ERRO! 80>50 mas esta a esquerda, 25<70 mas esta a direita");
    
    List<Object> inOrderInvalida = new ArrayList<>();
    arvoreInvalida.inOrder(inOrderInvalida);
    System.out.println("\ninOrder da arvore invalida: " + inOrderInvalida);
    
    boolean isABPInvalida = eArvoreBinariaDePesquisa(arvoreInvalida);
    System.out.println("E uma ABP? " + isABPInvalida);
    System.out.println("Explicacao: inOrder resulta em [30,80,50,25,70] - NAO esta em ordem crescente!"); 

    // TESTE 3: Arvore INVALIDA - Valor pequeno na subarvore direita
    System.out.println("\n" + "=".repeat(60));
    System.out.println("3. ARVORE INVALIDA - VALOR PEQUENO NA DIREITA:");
    
    Arvore arvoreInvalida2 = new Arvore();
    arvoreInvalida2.inserir(50);
    arvoreInvalida2.inserir(30);
    arvoreInvalida2.inserir(70);
    
    // ERRO: 25 < 50, mas esta na subarvore direita
    arvoreInvalida2.direita.esquerda = new Arvore(arvoreInvalida2.new Folha(25));
    
    System.out.println("\nEstrutura:");
    System.out.println("    50");
    System.out.println("   /  \\");
    System.out.println("  30   70");
    System.out.println("        /");
    System.out.println("       25  <- ERRO! 25 < 50 mas esta a direita");
    
    testarArvore(arvoreInvalida2, "Valor 25 menor que raiz 50 na subarvore direita");

    // TESTE 4: Intersecao de arvores
    System.out.println("\n" + "=".repeat(60));
    System.out.println("4. TESTANDO A INTERSECAO (UNIAO) DE ARVORES:");

    // Criando a primeira árvore
    Arvore arvore1 = new Arvore();
    arvore1.inserir(50);
    arvore1.inserir(30);
    arvore1.inserir(70);
    List<Object> lista1 = new ArrayList<>();
    arvore1.inOrder(lista1);
    System.out.println("\narvore 1 (inOrder): " + lista1);
    System.out.println("\narvore 1 (imprimir): ");
    arvore1.imprimir();

    // Criando a segunda árvore com valores sobrepostos e novos
    Arvore arvore2 = new Arvore();
    arvore2.inserir(60);
    arvore2.inserir(30);// Valor repetido
    arvore2.inserir(20);
    List<Object> lista2 = new ArrayList<>();
    arvore2.inOrder(lista2);
    System.out.println("arvore 2 (inOrder): " + lista2);
    System.out.println("\narvore 2 (imprimir): ");
    arvore2.imprimir();

    // Gerando a árvore de união
    System.out.println("\nGerando a arvore de união...");
    // Chamando o método estático corrigido
    Arvore arvoreUniao = intersecaoArv(arvore1, arvore2);

    // Imprimindo o resultado
    List<Object> listaUniao = new ArrayList<>();
    arvoreUniao.inOrder(listaUniao);
    System.out.println("\narvore de União Resultante (inOrder): " + listaUniao);
    System.out.println("Resultado esperado: [20, 30, 50, 60, 70]");
    System.out.println("\narvore uniao (imprimir): ");
    arvoreUniao.imprimir();
  }

  private static void testarArvore(Arvore arvore, String descricao) {
    List<Object> inOrder = new ArrayList<>();
    arvore.inOrder(inOrder);
    System.out.println("\ninOrder: " + inOrder);
    
    boolean isABP = eArvoreBinariaDePesquisa(arvore);
    System.out.println("E uma ABP? " + isABP);
    System.out.println("Problema: " + descricao);
  }
  
  private static boolean eArvoreBinariaDePesquisa(Arvore A) {
    List<Object> arvoreInOrder = new ArrayList<>();
    boolean isPesquisa = true;
    
    A.inOrder(arvoreInOrder);
    
    for(int i = 0; i < arvoreInOrder.size() - 1; i++) {
      isPesquisa = (int)arvoreInOrder.get(i) < (int)arvoreInOrder.get(i + 1);
      if(isPesquisa == false) return false;
    }
    
    return isPesquisa;
  }

  public static Arvore intersecaoArv(Arvore arvoreA, Arvore arvoreB) {
      Arvore arvoreUniao = new Arvore();

    List<Object> valoresA = new ArrayList<>();
    arvoreA.inOrder(valoresA);

    for (int i = 0; i < valoresA.size(); i++) {
      Object valor = valoresA.get(i);
      arvoreUniao.inserir(valor);
    }

    List<Object> valoresB = new ArrayList<>();
    arvoreB.inOrder(valoresB);

    for (int i = 0; i < valoresB.size(); i++) {
      Object valor = valoresB.get(i);
      if(arvoreUniao.treeSearch((int) valor) == null) {
        arvoreUniao.inserir(valor);
      }
    }

    return arvoreUniao;
  }
}