package Hash;

public class HashLinearTeste {
  public static void main(String[] args) {
    HashLinear hash = new HashLinear(7);
    
    hash.insert(10, 100);
    hash.insert(22, 220);
    hash.insert(31, 310);
    hash.insert(4, 40);
    hash.insert(15, 150);

    System.out.println("Tabela antes do rehash:");
    hash.display();

    hash.insert(46, 15);
    hash.insert(63, 19);
    hash.insert(39, 97);
    hash.insert(40, 21);

    System.out.println("Tabela depois do rehash:");
    hash.display();
    
    System.out.println("\nBuscas:");
    HashLinear.Entry result = hash.search(22);
    System.out.println("Busca por chave 22: " + (result != null ? result.value : "não encontrado"));
    
    result = hash.search(99);
    System.out.println("Busca por chave 99: " + (result != null ? result.value : "não encontrado"));
    
    System.out.println("\nRemovendo chave 22:");
    hash.remove(22);
    hash.display();
    
    System.out.println("\nInserindo chave 8 após remoção:");
    hash.insert(8, 80);
    hash.display();
  }
}