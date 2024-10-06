import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
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
        System.out.println(list); // выводим список после добавления элементов в конец списка

        list.addElementByIndex(5, 10);
        System.out.println(list); // выводим список после добавления элемента по индексу

        System.out.println(list.getElement(3)); // выводим элемент списка по индексу

        list.removeElement(4);
        System.out.println(list); // выводим список после удаления элемента по индексу

        QuickSort.quickSort(list, Comparator.naturalOrder());
        System.out.println(list);
        QuickSort.quickSort(list, Comparator.reverseOrder());
        System.out.println(list);// выводим список после сортbровки

        list.removeAllElements();
        System.out.println(list); // выводим список после удаления всех элементов


        MyArrayList<String> strings = new MyArrayList<>();
        strings.addElement("Cat");
        strings.addElement("Dog");
        strings.addElement("Elephant");
        strings.addElement("Snake");
        strings.addElement("Rabbit");
        strings.addElement("Eagle");

        QuickSort.quickSort(strings, Comparator.reverseOrder());
        System.out.println(strings); // выводим список строк в обратном порядке
    }
}
