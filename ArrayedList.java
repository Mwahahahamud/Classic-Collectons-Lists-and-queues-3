package uk.ac.cam.mh2169.linkedlists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayedList <T> implements OopList{

    private T[] body;  // This is the body of the array


//    public ArrayedList(int size){
//        Object[] workaround = new Object[size];
//        this.body = (T[]) workaround;
//    }

    public ArrayedList(){
        this.body = (T[]) new Object[1];
    }

    @Override
    public void addFirst(Object element) {

        if (this.body == null){
            throw new NoSuchElementException("Array not initialised");
        }
        if (this.body[this.body.length - 1 ] == null){ // There is space in the list
            for (int i = 1; i < this.body.length; i++){ // Iterates backwards through the list, and moves the last elements up a space.
                this.body[this.body.length - i] = this.body[this.body.length - i - 1];
            }
        }
        else{ // no space

            T[] newArray;
            Object workaround = new Object[this.body.length * 2];
            newArray = (T[]) workaround;  // Slightly illegal method

            for (int i = 0; i < this.body.length; i++){
                newArray[this.body.length - i] = this.body[this.body.length - i - 1];
            }
            this.body = newArray;
        }
        this.body[0] = (T) element;
    }


    @Override
    public Object removeFirst() {
        Object returnObject = this.body[0];

        Object[] workaround = new Object[this.body.length - 1];
        T[] newBody = (T[]) workaround;


            for (int i = 1; i < this.body.length; i++){ // Iterates through every element excluding the last one, and then pushes
                newBody[i - 1] = this.body[i];
            }

        this.body[this.body.length - 1] = null; // Sets the last element to null as one was removed.
        this.body = newBody;
        return returnObject;
    }

    @Override
    public Object get(int n) {
        if (n >= this.body.length){
            throw new NoSuchElementException();
        }
        return this.body[n];
    }

    @Override
    public int length() {
        return body.length;
        // Cheating method
    }

    public static <T> ArrayedList create(T[] elements){
        ArrayedList newArrayedList = new ArrayedList();
        newArrayedList.body = elements;
        return newArrayedList;
    }

    @Override
    public String toString(){
        String returnString = "[";

        if (body.length > 0) {
            if (body[0] != null){
                returnString += body[0].toString();
                for (int i = 1; i < body.length; i++) {
                    returnString += "," + body[i].toString();
                }

            }

        }
        returnString += "]";

        return returnString;
    }
}
