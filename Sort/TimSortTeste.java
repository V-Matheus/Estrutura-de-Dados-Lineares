package Sort;

public class TimSortTeste {
  
  public static int[] listaAleatoria = {47, 23, 91, 8, 56, 12, 73, 34, 89, 15};
  public static int[] listaInversa = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
  public static int[] listaOrdenada = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
  public static int[] listaRepetidos = {5, 15, 5, 25, 15, 5, 25, 15, 5, 25};
  
  public static void main(String[] args) {
    System.out.println("=== TESTANDO TIMSORT ===\n");
    
    System.out.println("1. LISTA ALEATORIA:");
    int[] teste1 = listaAleatoria.clone();
    imprimirArray("Antes: ", teste1);
    TimSort.timSort(teste1, teste1.length);
    imprimirArray("Depois:", teste1);
    verificarOrdenacao(teste1);
    
    System.out.println("\n2. LISTA INVERSA:");
    int[] teste2 = listaInversa.clone();
    imprimirArray("Antes: ", teste2);
    TimSort.timSort(teste2, teste2.length);
    imprimirArray("Depois:", teste2);
    verificarOrdenacao(teste2);
    
    System.out.println("\n3. LISTA JA ORDENADA:");
    int[] teste3 = listaOrdenada.clone();
    imprimirArray("Antes: ", teste3);
    TimSort.timSort(teste3, teste3.length);
    imprimirArray("Depois:", teste3);
    verificarOrdenacao(teste3);
    
    System.out.println("\n4. LISTA COM REPETIDOS:");
    int[] teste4 = listaRepetidos.clone();
    imprimirArray("Antes: ", teste4);
    TimSort.timSort(teste4, teste4.length);
    imprimirArray("Depois:", teste4);
    verificarOrdenacao(teste4);
    
    System.out.println("\n5. ARRAY PEQUENO (menor que RUN=32):");
    int[] pequeno = {5, 2, 8, 1, 9};
    imprimirArray("Antes: ", pequeno);
    TimSort.timSort(pequeno, pequeno.length);
    imprimirArray("Depois:", pequeno);
    verificarOrdenacao(pequeno);
    
    System.out.println("\n6. ARRAY GRANDE (maior que RUN=32):");
    int[] grande = gerarArrayGrande(50);
    System.out.println("Array de 50 elementos gerado");
    imprimirArray("Primeiros 10 antes: ", java.util.Arrays.copyOf(grande, 10));
    TimSort.timSort(grande, grande.length);
    imprimirArray("Primeiros 10 depois:", java.util.Arrays.copyOf(grande, 10));
    verificarOrdenacao(grande);
    
    System.out.println("\n7. ARRAY COM 1 ELEMENTO:");
    int[] umElemento = {42};
    imprimirArray("Antes: ", umElemento);
    TimSort.timSort(umElemento, umElemento.length);
    imprimirArray("Depois:", umElemento);
    verificarOrdenacao(umElemento);
    
    System.out.println("\n=== TODOS OS TESTES CONCLUIDOS ===");
  }
  
  public static void imprimirArray(String label, int[] arr) {
    System.out.print(label + " ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
      if (i < arr.length - 1) System.out.print(", ");
    }
    System.out.println();
  }
  
  public static void verificarOrdenacao(int[] arr) {
    boolean ordenado = true;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        ordenado = false;
        break;
      }
    }
    System.out.println("Resultado: " + (ordenado ? "✓ ORDENADO CORRETAMENTE" : "✗ ERRO NA ORDENACAO"));
  }
  
  public static int[] gerarArrayGrande(int tamanho) {
    int[] arr = new int[tamanho];
    for (int i = 0; i < tamanho; i++) {
      arr[i] = (int)(Math.random() * 100);
    }
    return arr;
  }
}