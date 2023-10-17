/**
 * This class contains a main method to test all 11 methods I have
 * implemented using a linked set. Generics are needed.
 * */

//getReferenceTo
//just have to figure out add method, checking for duplicates
//rest of them should be in textbook
//be able to
public final class LinkedSet<T> implements SetInterface<T> {

    public T[] set;

    private Node<T> firstNode;
    private int numOfEntries;

    // constructor
    public LinkedSet() {
        firstNode = null;
        numOfEntries = 0;
    }

    // 11 methods here
    /**
     * this method gets the current size of a set
     * @return the number of entries in a set
     * */
    public int getCurrentSize() {

        return numOfEntries;
    }

    /**
     * this method tests if the set is empty
     * @return True if this bag is empty, or false if not.
     */
    public boolean isEmpty() {

        return numOfEntries == 0;
    }

    /**
     * this method adds a new entry to this set. If there are any duplicates, this method will not add.
     * @param newEntry is the object that is being added to this set.
     * return true if a new entry was successfully added to this set.
     * */
    public boolean add(T newEntry) {

        //Adding a new node to the beginning of linked chain
        Node<T> newNode = new Node<>(newEntry);
        newNode.next = firstNode; // Make new node reference
        firstNode = newNode;
        numOfEntries++;

        return true;
    }

    /**
     * this method removes one unspecified entry from this bag.
     *
     * */
    public T remove() {

        T result = null;
        if (firstNode != null) {
            result = (T) firstNode.data;
            firstNode = firstNode.next;

            numOfEntries--;
        }
        return result;
    }

    /**
     * this method removes one occurrence of any given entry from this set.
     * */
    public boolean remove(T anEntry) {

        boolean result = false;
        Node<T> nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            nodeN.data = firstNode.data;
            firstNode = firstNode.next;
            numOfEntries--;
            result = true;
        }
        return result;
    }


    /**
     * this method removes all entries in this set.
     * */
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            }
            else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    public T[] toArray() {

        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numOfEntries];
        int index = 0;
        Node<T> currentNode = firstNode;
        while ((index < numOfEntries) && (currentNode != null)) {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }
        return result;
    }

    // Extra method
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            }
            else {
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }


    private static class Node<T> {

        private T data;    //element inside a set
        private Node<T> next; //link to next node

        //default constructor
        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        //constructor
        private Node(T dataPortion, Node<T> nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        private T getData() {

            return data;
        }

        private void setData(T newData) {
            data = newData;
        }

        private Node<T> getNextNode() {
            return next;
        }

        private void setNextNode(Node<T> nextNode) {
            next = nextNode;
        }

    }

}






// union
// T:data - compare with SetA
// iterate through
//

