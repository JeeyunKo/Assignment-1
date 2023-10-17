
/**
 * 11 operations needed here:
 * getCurrentSize(): integer
 * isEmpty(): Boolean
 * add(newEntry T): Boolean
 * remove(): T
 * remove(anEntry: T): boolean
 * clear(): void
 * contains(anEntry: T): boolean
 * toArray(): T[]
 * union(otherSet: SetInterface<T>): SetInterface<T>
 * intersection(otherSet: SetInterface<T>): SetInterface<T>
 * difference(otherSet: SetInterface<T>): SetInterface<T>

 */

/** An interface that describes 11 operations of a bag of objects.*/
public interface SetInterface<T> {

    public int getCurrentSize();

    public boolean isEmpty();

    public boolean add(T newEntry);

    public T remove();

    public boolean remove(T anEntry);

    public void clear();

    public boolean contains(T anEntry);

    public T[] toArray();

    //public SetInterface<T> union(SetInterface<T> otherSet);

    //public SetInterface<T> intersection(SetInterface<T> otherSet);

    //public SetInterface<T> difference(SetInterface<T> otherSet);

}
