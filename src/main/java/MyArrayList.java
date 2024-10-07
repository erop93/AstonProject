/**
 * Класс представляет собой реализацию списка ArrayList
 * Содержит поля для инициализации - массив array, изначальный размер size, вместимость capacity.
 * Реализует основные методы Списка:
 * -добавление элемента addElement
 * -добавление элемента по индексу addElementByIndex
 * -получение элемента по индексу getElement
 * -удаление элемента по индексу removeElement
 * -удаление всех элементов из списка removeAllElements
 * @param <E> - любой тип данных, который будет указан при создании экземпляра класса.
 */
public class MyArrayList<E> {

    private Object[] array = new Object[10];
    private int size = 0;
    private final int capacity = 10;

    /**
     * Конструктор для создания Списка
     */
    public MyArrayList() {
        array = new Object[capacity];
    }

    /**
     * Метод добавляет элемент в конец списка.
     * Перед добавлением происходит проверка массива на свободные места.
     * Если количество элементов в массиве равно его вместимости, массив увеличивается в 1,5 раза.
     * @param element - элемент для добавления в список
     */
    public void addElement(Object element) {
        if (size == array.length) {
            enlargeArray();
        }
        array[size++] = element;
    }

    /**
     * Метод добавляет элемент в конкретное место в массиве.
     * @throws IndexOutOfBoundsException если переданные номер не входит в границы списка.
     * Перед добавлением происходит проверка массива на свободные места.
     * Если количество элементов в массиве равно его вместимости, массив увеличивается в 1,5 раза.
     * Все элемент массива, начиная с index, смещаются на 1 ячейку в сторону.
     * Ячейке под номером index присваивается переданный в параметре элемент element.
     * @param index - номер ячейки массива, куда нужно подставить переданный элемент.
     * @param element - элемент для добавления в список
     */
    public void addElementByIndex(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            enlargeArray();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
    }

    /**
     * Метод получает элемент списка по его номеру index.
     * @throws IndexOutOfBoundsException если переданные номер не входит в границы списка.
     * @param index - номер ячейки массива, по которой нужно получить элемент.
     * @return возвращает элемент списка по его номеру.
     */
    public E getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    /**
     * Метод удаляет элемент списка по его номеру index.
     * @throws IndexOutOfBoundsException если переданные номер не входит в границы списка.
     * Все элементы списка, начиная со следующего после удаляемого, смещаются на 1 ячейку влево.
     * Список становится на 1 элемент короче.
     * @param index - номер ячейки массива, из которой удаляется элемент
     * @return возвращает список на один элемент меньше, без удаленного.
     */
    public Object removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        return array[--size];
    }

    /**
     * Метод удаляет все элементы списка.
     * Цикл проходит по всем элементам массива и присваивает им null.
     * Размер списка приравнивается к нулю.
     */
    public void removeAllElements() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * Переопределенный метод toString() для вывода списка в консоль.
     * С помощью класса StringBuilder собираем строку из [] и элементов массива через запятую.
     * @return возвращает список в виде строки.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Метод для получения количества элементов в массиве.
     * @return возвращает количество элементов в массиве.
     */
    public int getSize() {
        return size;
    }

    /**
     * Метод для замены элементов в списке при его сортировке.
     * @param i - номер элемента, который меняем.
     * @param j - номер элемента, на который меняем.
     */
    public void swap(int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Метод для увеличения массива в 1,5 раза в случае, если он заполнен.
     * Создается новый массив длиной в 1,5 раза +1 больше изначального
     * Изначальный массив копируется в новый.
     * Изначальному массиву присваивается новый.
     */
    private void enlargeArray() {
        Object[] newArray = new Object[(array.length * 3 / 2) + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

}
