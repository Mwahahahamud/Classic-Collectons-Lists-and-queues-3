/*
 * Copyright 2022 Ben Philps <bp413@cam.ac.uk>, Andrew Rice <acr31@cam.ac.uk>, M. Haji
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.mh2169.linkedlists;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

@RunWith(JUnit4.class)
public class LinkListTest {

  @Test
  public void linkList_toStringIsEmptyList_whenListEmpty() {
    // ARRANGE
    LinkList empty = new LinkList();

    // ACT
    String value = empty.toString();

    // ASSERT
    assertThat(value).isEqualTo("[]");
  }

  @Test
  public void emptyWhenEmptyList (){
    Integer[] liszt = {};
    LinkList result = LinkList  .create(liszt);
    assertThat(result.toString()).isEqualTo("[]");
  }
@Test
  public void NonemptyWhenNonemptyList (){
    Integer[] liszt = {1,2,3,4,5};
    LinkList result = LinkList.create(liszt);
    assertThat(result.toString()).isEqualTo("[1,2,3,4,5]");
  }

  @Test
  public void linkList_toStringIsSingleItem_whenListContainsOneItem() {
    // ARRANGE
    LinkList list = new LinkList();
    list.addFirst(1);

    // ACT
    String value = list.toString();

    // ASSERT
    assertThat(value).isEqualTo("[1]");
  }

  @Test
  public void linkList_toStringIsTwoThenOne_whenListHasOneThenTwoAdded() {
    // ARRANGE
    LinkList list = new LinkList();
    list.addFirst(1);
    list.addFirst(2);

    // ACT
    String value = list.toString();

    // ASSERT
    assertThat(value).isEqualTo("[2,1]");
  }
  @Test
  public void testlengthempty(){
    LinkList list = new LinkList();
    assertThat(list.length()).isEqualTo(0);
  }
  @Test
  public void testlength5elements(){
    Integer[] elements = {1,2,3,4,5};
    LinkList list = LinkList.create(elements);

    assertThat(list.length()).isEqualTo(5);
  }
@Test
  public void getNegativeElementThrowsError(){
    LinkList list = new LinkList();

    assertThrows(NoSuchElementException.class, () -> list.get(-10));
  }
  @Test
  public void getElementOutOfRangeThrowsError(){
    Integer[] elements = {1, 2};
    LinkList list = LinkList.create(elements);

    assertThrows(NoSuchElementException.class, () -> list.get(10));

  }


@Test
  public void getsRightElement(){
    Integer[] elements = {1,2,3,4,5};
    LinkList list = LinkList.create(elements);
    assertThat(list.get(3)).isEqualTo(4);
  }
@Test
  public void removeReturnsValueForList(){
    Integer[] elements = {1,2,3,4,5};
    LinkList list = LinkList.create(elements);
    assertThat(list.removeFirst()).isEqualTo(1);
    assertThat(list.toString()).isEqualTo("[2,3,4,5]");
  }
  @Test
  public void removeThrowsErrorWhenEmpty(){
    Integer[] elements = {};
    LinkList list = LinkList.create(elements);
    assertThrows(NoSuchElementException.class, () -> list.removeFirst());

  }
  @Test
  public void createWithStrings(){
    String[] elements = {"Test1", "Hello World"};
    LinkList list = LinkList.create(elements);
//    System.out.println(list);
    assertThat(list.toString()).isEqualTo("[Test1,Hello World]");

  }

}
