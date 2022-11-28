package uk.ac.cam.mh2169.linkedlists;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

@RunWith(JUnit4.class)


public class ArrayedListTest {
    @Test
    public void ArrayedListAddsElementToFrontCorrectlyWhenListIsFull(){

        String[] elements = {"Hello", "World"};
        ArrayedList testArrayed = ArrayedList.create(elements);
        testArrayed.addFirst("Why");

        assertThat(testArrayed.get(0)).isEqualTo("Why");
        assertThat(testArrayed.get(1)).isEqualTo("Hello");
        assertThat(testArrayed.get(2)).isEqualTo("World");
        assertThat(testArrayed.get(3)).isEqualTo(null);

    }
    @Test
    public void ArrayedListAddsElementToFrontCorrectlyWhenListIs_Not_Full() {

        String[] elements = {"Hello", null};
        ArrayedList testArrayed = ArrayedList.create(elements);
        testArrayed.addFirst("Why");

        assertThat(testArrayed.get(0)).isEqualTo("Why");
        assertThat(testArrayed.get(1)).isEqualTo("Hello");

    }

    @Test
    public void ArrayedListRemovesElementAndReturnsRightValue(){
        Integer[] elements = {1, 2, 4, 57};
        ArrayedList testArrayed = ArrayedList.create(elements);
        Object removedElement = testArrayed.removeFirst();

        assertThat(testArrayed.get(0)).isEqualTo(2);
        assertThat(testArrayed.get(1)).isEqualTo(4);
        assertThat(testArrayed.get(2)).isEqualTo(57);
        assertThat(removedElement).isEqualTo(1);




    }

    @Test
    public void AddingElementToNullListWorks(){

        ArrayedList testArrayed = new ArrayedList<>();
        testArrayed.addFirst(4);
        testArrayed.addFirst(2);
//        System.out.println(testArrayed);
        assertThat(testArrayed.get(0)).isEqualTo(2);
    }
    @Test
    public void AddingAndRemovingElementToEmptyListResultsInEmptyList(){
        ArrayedList testArrayed = new ArrayedList<Integer>();
        testArrayed.addFirst(4);
        testArrayed.removeFirst();
//        System.out.println(testArrayed);
        assertThat(testArrayed.toString()).isEqualTo("[]");

    }

    @Test
    public void PrintsNullArrayList(){
        ArrayedList testArrayed = new ArrayedList();
//        System.out.println(testArrayed);
        assertThat(testArrayed.toString()).isEqualTo("[]");
    }

    @Test
    public void PrintsRightLength(){
        Integer[] elements = {1, 2, 4, 57};
        ArrayedList testArrayed = ArrayedList.create(elements);
        assertThat(testArrayed.length()).isEqualTo(4);
    }



}
