import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Класс тестирует методы класса MyArrayList:
 * -добавление элемента addElement
 * -добавление элемента по индексу addElementByIndex
 * -получение элемента по индексу getElement
 * -удаление элемента по индексу removeElement
 * -удаление всех элементов из списка removeAllElements
 */
class MyArrayListTest {

    @Test
    void addElementTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addElement(10);
        myArrayList.addElement(20);
        myArrayList.addElement(30);

        Assertions.assertEquals(3, myArrayList.getSize());
        Assertions.assertEquals(10, myArrayList.getElement(0));
        Assertions.assertEquals(20, myArrayList.getElement(1));
        Assertions.assertEquals(30, myArrayList.getElement(2));
    }

    @Test
    void addElementAndEnlargeArrayTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 15; i++) {
            myArrayList.addElement(i);
        }
        Assertions.assertEquals(15, myArrayList.getSize());
        Assertions.assertEquals(5, myArrayList.getElement(5));
    }

    @Test
    void addElementByIndexTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addElement(10);
        myArrayList.addElement(20);
        myArrayList.addElement(30);
        myArrayList.addElementByIndex(1,5);

        Assertions.assertEquals(5, myArrayList.getElement(1));
        Assertions.assertEquals(3, myArrayList.getSize());
    }

    @Test
    void getElementTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addElement(10);
        myArrayList.addElement(20);
        myArrayList.addElement(30);

        Assertions.assertEquals(10, myArrayList.getElement(0));
        Assertions.assertEquals(20, myArrayList.getElement(1));
        Assertions.assertEquals(30, myArrayList.getElement(2));
    }

    @Test
    void removeElementTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addElement(10);
        myArrayList.addElement(20);
        myArrayList.addElement(30);
        myArrayList.removeElement(1);

        Assertions.assertEquals(2, myArrayList.getSize());
        Assertions.assertEquals(10, myArrayList.getElement(0));
        Assertions.assertEquals(30, myArrayList.getElement(1));
    }

    @Test
    void removeAllElementsTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addElement(10);
        myArrayList.addElement(20);
        myArrayList.addElement(30);
        myArrayList.removeAllElements();

        Assertions.assertEquals(0, myArrayList.getSize());
    }

    @Test
    void toStringTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addElement(10);
        myArrayList.addElement(20);
        myArrayList.addElement(30);
        System.out.println(myArrayList.toString());
        Assertions.assertEquals("[10, 20, 30]", myArrayList.toString());
    }

    @Test
    void getSizeTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addElement(10);
        myArrayList.addElement(20);
        myArrayList.addElement(30);

        Assertions.assertEquals(3, myArrayList.getSize());
    }
}