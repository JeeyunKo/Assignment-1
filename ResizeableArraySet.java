import java.util.Arrays;
/**
 * this class contains the class ResizeableArraySet with the above 11 methods. Note: the class ResizeableArraySet
 * presents an implementation of the ADT using a resizable array. Generics are needed.
 * */

//include checkIntegrity
//test add method but can do add."A" one by one
//checking capacity and double capacity is fine

public final class ResizeableArraySet<T> implements SetInterface<T> {

    //core methods to see if add method works
    //일단 fixed size array for size 25
    //define an array called "set"
    public T[] set;
    //define a variable that represents the number of entries in a set (bag)
    public int numOfEntries;
    private int capacity;
    private boolean integrityOk;
    public static final int DEFAULT_CAPACITY = 25;
    public static final int MAX_CAPACITY = 1000000;

    // default constructor
    public ResizeableArraySet() {
        this(DEFAULT_CAPACITY);
    }

    // constructor
    // create an empty set with temporary set array
    //@param initialCapacity is the integer capacity desired
    public ResizeableArraySet(int desiredCapacity) {

        integrityOk = false;
        if (desiredCapacity <= MAX_CAPACITY) {
            @SuppressWarnings("unchecked")
            T[] tempSet = (T[]) new Object[desiredCapacity];
            set = tempSet;
            numOfEntries = 0;
            integrityOk = true;
        } else
            throw new IllegalStateException("Attempt to create a set whose " + "capacity exceeds allowed maximum.");

    }

    public ResizeableArraySet(T[] contents) {
        checkCapacity(contents.length);
        set = Arrays.copyOf(contents, contents.length);
        numOfEntries = set.length;
    }

    // 11 methods here:

    // returns the number of entries in a set
    public int getCurrentSize() {

        return numOfEntries;
    }

    // returns true if this set is empty, false if it's not
    public boolean isEmpty() {

        //boolean empty = true;

        //System.out.println("\nIs a set empty: ");

//        if (numOfEntries == 0) {
//            return true;
//        }

        return false;
    }

    // adds a new entry to the set
    // @param newEntry is the object being added to the set
    // MUST check if there are duplicates(contains()), do not add. If no duplicates(!contains()), add.
    public boolean add(T newEntry) {

        checkIntegrity();
        if (isFull()) {
            doubleCapacity();
        }
        System.out.println("\nAdding: ");


        if (contains(newEntry)) {
            System.out.println("This entry cannot be added since it already exists.");
        } else if (!contains(newEntry)) {
            set[numOfEntries] = newEntry;
            numOfEntries++;
            System.out.print(newEntry + " ");
        }
        return true;
    }


    //checks to see if the entry is contained in the set. The while loop will terminate either when an entry has been
    //found in the array, or the entire array has been checked, and there is no entry that is checked
    public boolean contains(T anEntry) {

//        boolean found = false;
//        int index = 0;
//
//        while (!found && (index < numOfEntries)) {
//            if (anEntry.equals(set[index])) {
//                found = true;
//            }
//            else {
//                index++;
//            }
//        } //end while loop, until it checks all the index in the array
//        return found;

        checkIntegrity();
        return getIndexOf(anEntry) > -1;
    }

    // removes one unspecified entry from the set
    // returns the removed entry or successful/unsuccessful for removing, or null
    public T remove() {

        checkIntegrity();
//        T result = null;
//        // if there is any entry inside a set,
//        if (numOfEntries > 0) {
//            //access the last entry
//            result = set[numOfEntries - 1];
//            //set the last entry of a set as empty (removing the last entry of the bag)
//            set[numOfEntries - 1] = null;
//            //decrement number of entries (last entry is ignored)
//            numOfEntries--;
//        }
        T result = removeEntry(numOfEntries - 1);

        //returns the set with removed component
        return result;
    }

    public boolean remove(T anEntry) {

        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);

        return anEntry.equals(result);
    }

    // clears all entries from the set
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    //retrieves all entries that are in this bag
    public T[] toArray() {

        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numOfEntries];

        for (int index = 0; index < numOfEntries; index++) {
            result[index] = set[index];
        }
        return result;
    }

    // additional three methods

    //public SetInterface<T> union(SetInterface<T> otherSet);

    //public SetInterface<T> intersection(SetInterface<T> otherSet);

    //public SetInterface<T> difference(SetInterface<T> otherSet);



    //EXTRA METHOD

    private void checkIntegrity() {
        if (!integrityOk) {
            throw new SecurityException("ArraySet object is corrupt. ");
        }
    }


    private boolean isFull() {

        return numOfEntries >= set.length;
    }

//    private void checkInitialization() {
//        if (!ini)
//    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a set whose " +
                    "capacity exceeds allowed" +
                    "maximum of " + MAX_CAPACITY);
        }
    }

    private void doubleCapacity() {
        int newLength = 2 * set.length;
        checkCapacity(newLength);
        set = Arrays.copyOf(set, newLength);

    }

    //locates a new entry within the set.
    //returns the index of the entry if located, -1 otherwise
    //pre-condition: checkInitialization has been called
    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean found = false;
        int index = 0;
        while (index < numOfEntries) {
            if (anEntry.equals(set[index])) {
                where = index;
            }
            index++;
        }

        //if where is > -1, anEntry is in the array set, and it equals set[where]; otherwise, anEntry is not in a set.
        return where;
    }

    private T removeEntry(int givenIndex) {

        T result = null;
        if (!isEmpty() && (givenIndex >= 0)) {
            result = set[givenIndex]; //entry to remove
            int lastIndex = numOfEntries - 1;

            set[givenIndex] = set[lastIndex];
            set[lastIndex] = null;
            numOfEntries--;
        }
        return result;
    }



}


