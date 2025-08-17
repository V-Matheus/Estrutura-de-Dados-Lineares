package Hash;

public class HashLinear {
  public static class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
  private static final Entry AVAILABLE = new Entry(-1, -1);

  private Entry[] table;
  
  public HashLinear(int size) {
    this.table = new Entry[size];
  }

  private void rehash() {
    Entry[] oldTable = table;
    table = new Entry[table.length * 2];

    for(int i = 0; i < oldTable.length; i++) {
      if (oldTable[i] != null && oldTable[i] != AVAILABLE) {
        insert(oldTable[i].key, oldTable[i].value);
      }
    }
  }

  private double loadFactor() {
    int count = 0;
    for (int i = 0; i < table.length; i++) {
      if (table[i] != null && table[i] != AVAILABLE) count++;
    }
    return (double) count / table.length;
}

  void insert(int key, int value) {

    if(loadFactor() > 0.7) {
      rehash();
    }

    Entry newEntry = new Entry(key, value);
    int index = key % table.length;

    while (table[index] != null) {
      if(table[index].key == key) {
        table[index].value = value;
        return;
      }

      index = (index + 1) % table.length;
    }

    table[index] = newEntry;
  }

  Entry search(int key) {
    int index = key % table.length;

    while(table[index] != null) {
      if(table[index].key == key) return table[index];
      index = (index + 1) % table.length;
    }

    return null;
  }

  Entry remove(int key) {
    int index = key % table.length;
    Entry removedEntry = null;

    while(table[index] != null) {
      if(table[index].key  == key) {
        removedEntry = table[index];
        table[index] = null;
      }
    }

    return removedEntry;
  }



  public void display() {
    for(int i = 0; i < table.length; i++) {
      if(table[i] == null) {
        System.out.println("[" + i + "] = null");
      } else if(table[i] == AVAILABLE) {
        System.out.println("[" + i + "] = AVAILABLE");
      } else {
        System.out.println("[" + i + "] = {" + table[i].key + ", " + table[i].value + "}");
      }
    }
  }
}
