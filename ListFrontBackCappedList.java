// Written by Frances Belleza - Project A

// STIPS:
//  Pay close attention to what should happen in "failed" conditions as
//    described by the FrontBackCappedList.
//  The behavior might be different from what happens in List.
//  Make sure your ListFrontBackCappedList behaves as described in
//    FrontBackCappedList.

// ---->>>> Use the methods of the List interface/ArrayList class when possible
//    instead of re-writing the code yourself. <<<<----
// ****** Use Interface Methods to help reduce work ******

import java.util.*;
public class ListFrontBackCappedList<T> implements FrontBackCappedList<T> {
    private List<T> list; // initialize to type ArrayList<T> in the ListFrontBackCappedList constructor
    private int numberOfElements;
    private int capacity;

    public ListFrontBackCappedList(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<T>();
        numberOfElements = 0;

    }

    @Override
    public String toString() {
        String s = "[";

        for(int x = 0; x < numberOfElements; x++) {
            s += list.get(x);
            if(x < numberOfElements-1) {
                s += ", ";
            }
        }
        s += "]";

        return "size=" + numberOfElements + "; capacity=" + capacity + ";   " + s;
    }

    @Override
    public int size(){
        return numberOfElements;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean contains(T anEntry) {
        return lastIndexOf(anEntry) >= 0;
    }

    @Override
    public boolean addFront(T newEntry) {
        if(!isFull()) {
            list.add(0, newEntry); // interface add void method this method will shift it already
            numberOfElements++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addBack(T newEntry) {
        if(!isFull()) {
            list.add(newEntry); // interface add bool method automatically adds to the back yay!
            numberOfElements++;
            return true;
        } else {
            return false;
        }
    }

    public T removeFront() {
        if(!isEmpty()) {
            numberOfElements--;

            return list.remove(0);
        } else {
            return null; // empty list
        }
    }

    @Override
    public T removeBack() {
        if(!isEmpty())  {
            numberOfElements--;

            return list.remove(numberOfElements); // interface List
        } else {
            return null; // empty
        }
    }


    @Override
    public void clear() {
        list.clear();
        numberOfElements = 0;
    }


    @Override
    public T getEntry(int position) {
        if(position >= 0 && position < numberOfElements) {
            return list.get(position);
        } else {
            return null;
        }
    }

    @Override
    public int indexOf(T anEntry) {
        for(int x = 0; x < list.size(); x++) {
            if(Objects.equals(anEntry, list.get(x))) {
                return x;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T anEntry) {
        for(int x = list.size()-1; x >= 0; x--) {
            if (Objects.equals(anEntry, list.get(x))) {  // from javadoc
                return x;
            }
        }
        return -1;

    }

    @Override
    public boolean isFull() {
        return numberOfElements == capacity;
    }

}
