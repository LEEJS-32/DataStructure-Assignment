/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.io.Serializable;
/**
 *
 * @author jians
 * @param <T>
 */

public class DoublyLinkedList<T> implements ListInterface<T>, Serializable {
  private Node firstNode;  // reference to first node
  private Node lastNode;   // reference to last node
  private int numberOfEntries;  	

  public DoublyLinkedList() {
    clear();
  }

  @Override
  public final void clear() {
    firstNode = null;
    lastNode = null;
    numberOfEntries = 0;
  }

  @Override
  public boolean add(T newEntry) {
    Node newNode = new Node(newEntry);	// create the new node

    if (isEmpty()) {
      firstNode = newNode;
      lastNode = newNode;
    } else {    
      newNode.prev = lastNode; // point new node’s prev to lastNode
      lastNode.next = newNode; // point last node’s next to new node
      lastNode = newNode;      // update lastNode reference
    }

    numberOfEntries++;
    return true;
  }

  @Override
  public boolean add(int newPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
      Node newNode = new Node(newEntry);

      if (isEmpty() || newPosition == 1) { // case 1: add to beginning
        newNode.next = firstNode;
        if (firstNode != null) {
          firstNode.prev = newNode;
        }
        firstNode = newNode;
        if (lastNode == null) { 
          lastNode = newNode; // Update lastNode if list was empty
        }
      } else if (newPosition == numberOfEntries + 1) { // case 2: add to end
        newNode.prev = lastNode;
        lastNode.next = newNode;
        lastNode = newNode;
      } else { // case 3: add in between
        Node nodeBefore = firstNode;
        for (int i = 1; i < newPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;
        }

        newNode.next = nodeBefore.next;
        newNode.prev = nodeBefore;
        nodeBefore.next.prev = newNode;
        nodeBefore.next = newNode;
      }

      numberOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  @Override
  public T remove(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      if (givenPosition == 1) { // case 1: remove first entry
        result = firstNode.data;
        firstNode = firstNode.next;
        if (firstNode != null) {
          firstNode.prev = null;
        } else {
          lastNode = null; // If list becomes empty
        }
      } else if (givenPosition == numberOfEntries) { // case 2: remove last entry
        result = lastNode.data;
        lastNode = lastNode.prev;
        lastNode.next = null;
      } else { // case 3: remove in between
        Node nodeToRemove = firstNode;
        for (int i = 1; i < givenPosition; ++i) {
          nodeToRemove = nodeToRemove.next;
        }

        result = nodeToRemove.data;
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;
      }

      numberOfEntries--;
    }

    return result;
  }

  @Override
  public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      Node currentNode = firstNode;
      for (int i = 1; i < givenPosition; ++i) {
        currentNode = currentNode.next;
      }
      currentNode.data = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  @Override
  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      Node currentNode = firstNode;
      for (int i = 1; i < givenPosition; ++i) {
        currentNode = currentNode.next;
      }
      result = currentNode.data;
    }

    return result;
  }

  @Override
  public boolean contains(T anEntry) {
    boolean found = false;
    Node currentNode = firstNode;

    while (!found && (currentNode != null)) {
      if (anEntry.equals(currentNode.data)) {
        found = true;
      } else {
        currentNode = currentNode.next;
      }
    }
    return found;
  }

  @Override
  public int getNumberOfEntries() {
    return numberOfEntries;
  }

  @Override
  public boolean isEmpty() {
    return numberOfEntries == 0;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public String toString() {
    StringBuilder outputStr = new StringBuilder();
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr.append(currentNode.data).append("\n");
      currentNode = currentNode.next;
    }
    return outputStr.toString();
  }

  // Inner class for Node
  private class Node {
    private T data;
    private Node next;
    private Node prev;

    private Node(T data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }

    private Node(T data, Node next, Node prev) {
      this.data = data;
      this.next = next;
      this.prev = prev;
    }
  }
}

