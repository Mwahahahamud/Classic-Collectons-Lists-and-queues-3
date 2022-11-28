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

public class Main {

  public static void main(String[] args) {
    LinkList list = new LinkList();
    System.out.println(list);
    list.addFirst("a");
    list.addFirst("b");
    list.addFirst("c");

    System.out.println(list);

    String[] things = {"Hello", "World"};
    int[] elements = {1,2,3,4,5};
    LinkList list2 = LinkList.create(things);
    System.out.println();
    System.out.println(list.length());
//    System.out.println(list2);
//    System.out.println(list2.removeFirst());

    ArrayedList testificate = ArrayedList.create(things);

    testificate.addFirst("bozo");
    System.out.println(testificate);

  }
}
