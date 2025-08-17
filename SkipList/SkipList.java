package SkipList;

import java.util.Random;

public class SkipList {
    private class Node {
    int value;
    Node[] next;
    
    public Node(int value, int level) {
      this.value = value;
      this.next = new Node[level + 1];
    }
  } 

  private static final int MAX_LEVEL = 16;
  private Node head;
  private int currentLevel;
  private Random random;

  public SkipList() {
    this.head = new Node(-1, MAX_LEVEL);
    this.currentLevel = 0;
    this.random = new Random();
  }

  private Node findPosition(int value, Node[] update) {
    Node current = head;
    
    for (int i = currentLevel; i >= 0; i--) {
      while (current.next[i] != null && current.next[i].value < value) {
        current = current.next[i];
      }
      update[i] = current;
    }
    
    return current.next[0];
  }
  
  public void insert(int value) { 
    Node[] update = new Node[MAX_LEVEL + 1];
    Node current = findPosition(value, update);
    
    if (current != null && current.value == value) {
      return;
    }
    
    int newLevel = randomLevel();
    
    if (newLevel > currentLevel) {
      for (int i = currentLevel + 1; i <= newLevel; i++) {
        update[i] = head;
      }
      currentLevel = newLevel;
    }
    
    Node newNode = new Node(value, newLevel);
    
    for (int i = 0; i <= newLevel; i++) {
      newNode.next[i] = update[i].next[i];
      update[i].next[i] = newNode;
    }
  }

  private int randomLevel() {
    int level = 0;
    while (random.nextBoolean() && level < MAX_LEVEL) {
      level++;
    }
    return level;
  }

  public boolean search(int value) {
    Node[] dummy = new Node[MAX_LEVEL + 1];
    Node current = findPosition(value, dummy);
  
    return current != null && current.value == value;
  }

  public boolean remove(int value) {
    Node[] update = new Node[MAX_LEVEL + 1];
    Node current = findPosition(value, update);
    
    if (current == null || current.value != value) {
      return false;
    }
    
    for (int i = 0; i <= currentLevel; i++) {
      if (update[i].next[i] != current) {
        break;
      }
      update[i].next[i] = current.next[i];
    }
    
    while (currentLevel > 0 && head.next[currentLevel] == null) {
      currentLevel--;
    }
    
    return true;
  }
}


