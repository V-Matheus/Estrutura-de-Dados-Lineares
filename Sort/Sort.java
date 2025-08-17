package Sort;

public class Sort {

 public class BubbleSort {
    public void sort(int[] list) {
      for(int i = 0; i < list.length - 1; i++) {
        for(int j = 0; j < list.length - 1 - i; j++) {
          if(list[j] > list[j + 1]) {
            int temp = list[j];
            list[j] = list[j + 1];
            list[j + 1] = temp;
          }
        }
      }
    }

    public void printArray(int[] list) {
      for(int i = 0; i < list.length; i++) {
        System.out.print(list[i] + " ");
      }
      System.out.println();
    }
  }


  public class SelectSort {
    public void sort(int[] list) {
      for(int i = 0; i < list.length - 1; i++) {
        int minIndex = i;

        for(int j = i + 1; j < list.length; j++) {
          if(list[j] < list[minIndex]) {
            minIndex = j;
          }
        }

        int temp = list[minIndex];
        list[minIndex] = list[i];
        list[i] = temp;
      }
    }

    public void printArray(int[] list) {
      for(int i = 0; i < list.length; i++) {
        System.out.print(list[i] + " ");
      }
      System.out.println();
    }
  }

  public class InsertSort {
    public void sort(int[] list) {
      int[] sorted = new int[list.length];
      sorted[0] = list[0];
      for(int i = 1; i < list.length; i++) {
        int current = list[i];
        int j = i - 1;
        while(j >= 0 && sorted[j] > current) {
          sorted[j + 1] = sorted[j];
          j--;
        }
        sorted[j + 1] = current;
      }
    }

    
    public void printArray(int[] list) {
      for(int i = 0; i < list.length; i++) {
        System.out.print(list[i] + " ");
      }
      System.out.println();
    }
  }
}
