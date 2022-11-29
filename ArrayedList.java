import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayedList <T> implements OopList{

    private T[] body;  // This is where the data is stored.
    

    public ArrayedList(){
        this.body = (T[]) new Object[1];
    }

    @Override
    public void addFirst(Object element) {
        // Appends an element to the start of the list. If necessary, then it double the length of the list.
        
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
            newArray = (T[]) workaround; 

            for (int i = 0; i < this.body.length; i++){
                newArray[this.body.length - i] = this.body[this.body.length - i - 1];
            }
            this.body = newArray;
        }
        this.body[0] = (T) element;
    }


    @Override
    public Object removeFirst() {
        // Removes the first element, and also reduces the size of the ArrayedList by one.
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
        // Returns an object
        if (n >= this.body.length){
            throw new NoSuchElementException();
        }
        return this.body[n];
    }

    @Override
    public int length() {
        // Returns the length of the object
        return body.length;
    }

    public static <T> ArrayedList create(T[] elements){
        // Creates a new ArrayedList based on the input.
        ArrayedList newArrayedList = new ArrayedList();
        newArrayedList.body = elements;
        return newArrayedList;
    }

    @Override
    public String toString(){
        // String method that gets rid of spaces between the elements in the list.
        
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
