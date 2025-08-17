package Sort;

public class SortTest {
  
  // Lista com números em ordem aleatória
  public static int[] listaAleatoria = {47, 23, 91, 8, 56, 12, 73, 34, 89, 15};

  // Lista ordenada de forma inversa (maior para menor)
  public static int[] listaInversa = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};

  // Lista já ordenada corretamente (menor para maior)
  public static int[] listaOrdenada = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

  // Lista com itens repetidos
  public static int[] listaRepetidos = {5, 15, 5, 25, 15, 5, 25, 15, 5, 25};

  public static void main(String[] args) {
    Sort sort = new Sort();
    Sort.BubbleSort bubble = sort.new BubbleSort();

    System.out.println("=== TESTANDO BUBBLE SORT ===\n");

    System.out.println("Lista aleatória:");
    int[] bubble1 = listaAleatoria.clone();
    bubble.sort(bubble1);
    bubble.printArray(bubble1);

    System.out.println("\nLista inversa:");
    int[] bubble2 = listaInversa.clone();
    bubble.sort(bubble2);
    bubble.printArray(bubble2);

    System.out.println("\nLista já ordenada:");
    int[] bubble3 = listaOrdenada.clone();
    bubble.sort(bubble3);
    bubble.printArray(bubble3);

    System.out.println("\nLista com repetidos:");
    int[] bubble4 = listaRepetidos.clone();
    bubble.sort(bubble4);
    bubble.printArray(bubble4);

    System.out.println("=== TESTANDO SELECT SORT ===\n");

    System.out.println("Lista aleatória:");
    int[] select1 = listaAleatoria.clone();
    bubble.sort(select1);
    bubble.printArray(select1);

    System.out.println("\nLista inversa:");
    int[] select2 = listaInversa.clone();
    bubble.sort(select2);
    bubble.printArray(select2);

    System.out.println("\nLista já ordenada:");
    int[] select3 = listaOrdenada.clone();
    bubble.sort(select3);
    bubble.printArray(select3);

    System.out.println("\nLista com repetidos:");
    int[] select4 = listaRepetidos.clone();
    bubble.sort(select4);
    bubble.printArray(select4);

    System.out.println("=== TESTANDO INSERT SORT ===\n");

    System.out.println("Lista aleatória:");
    int[] insert1 = listaAleatoria.clone();
    bubble.sort(insert1);
    bubble.printArray(insert1);

    System.out.println("\nLista inversa:");
    int[] insert2 = listaInversa.clone();
    bubble.sort(insert2);
    bubble.printArray(insert2);

    System.out.println("\nLista já ordenada:");
    int[] insert3 = listaOrdenada.clone();
    bubble.sort(insert3);
    bubble.printArray(insert3);

    System.out.println("\nLista com repetidos:");
    int[] insert4 = listaRepetidos.clone();
    bubble.sort(insert4);
    bubble.printArray(insert4);
  }
}