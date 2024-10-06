import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * Класс тестирует сортировку класса quickSort на примере чисел и строк.
 */
class QuickSortTest {

    @Test
    void quickSortIntegerTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.addElement(8);
        list.addElement(3);
        list.addElement(6);
        list.addElement(1);
        list.addElement(7);
        list.addElement(4);
        list.addElement(2);
        list.addElement(9);
        list.addElement(5);
        QuickSort.quickSort(list, Comparator.naturalOrder());

        Assertions.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());
    }

    @Test
    void quickSortStringTest() {
        MyArrayList<String> strings = new MyArrayList<>();
        strings.addElement("Cat");
        strings.addElement("Dog");
        strings.addElement("Elephant");
        strings.addElement("Snake");
        strings.addElement("Rabbit");
        strings.addElement("Eagle");
        QuickSort.quickSort(strings, Comparator.reverseOrder());
        Assertions.assertEquals("[Snake, Rabbit, Elephant, Eagle, Dog, Cat]", strings.toString());
    }
}