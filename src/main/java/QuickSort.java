import java.util.Comparator;
import java.util.Objects;

/**
 * Класс реализует быструю сортировку для класса MyArrayList с помощью Comparator.
 */
public class QuickSort {

    /**
     * Публичный метод для вызова приватного метода quickSort.
     * Передает в качестве аргументов список и компаратор.
     * @param list - список MyArrayList для сортировки.
     * @param comparator - компаратор для сортировки элементов.
     * @param <T> - тип элементов, которые будут в списке list.
     */
    public static <T> void quickSort(MyArrayList<T> list, Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        quickSort(list, 0, list.getSize() - 1, comparator);
    }

    /**
     * Приватный метод для быстрой сортировки.
     * Проверяет, что в массиве больше одного элемента.
     * Вызывает метод partition, который делит массив на 2 части:
     * слева меньшие или равные опорному элементу, справа большие опорного элемента.
     * Метод quickSort вызывается рекурсивно для левой части списка (меньшей опорного элемента),
     * и для правой части списка (большей опорного элемента)
     * @param list - список MyArrayList для сортировки.
     * @param low - индекс начала массива для сортировки.
     * @param high - индекс конца массива для сортировки.
     * @param comparator - компаратор для сортировки элементов.
     * @param <T> - тип элементов, которые будут в списке list.
     */
    private static <T> void quickSort(MyArrayList<T> list, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator);
            quickSort(list, low, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Метод с выбором опорного элемента pivot и расстановкой других элементов по разные стороны
     * от опорного (в зависимости от того, меньше они или больше него).
     * В качестве опорного элемента выбирается последний элемент массива.
     * Переменной i присваивается последний элемент, который меньше или равен опорному, таких элементов пока нет.
     * Цикл массива проходит по всем его элементам от первого до последнего (не включая сам опорный элемент).
     * Внутри цикла текущий элемент сравнивается с опорным с помощью компаратора.
     * Если элемент меньше или равен опорному, он меняется местами с элементом, следующим за i.
     * После завершения цикла опорный элемент возвращается на свою позицию с помощью метода swap.
     * В конце метод возвращает индекс, по которому находится опорный элемент,
     * чтобы снова делить массив на две части для рекурсивно сортировки.
     * @param list - список MyArrayList для сортировки.
     * @param low - индекс начала массива для сортировки.
     * @param high - индекс конца массива для сортировки.
     * @param comparator - компаратор для сравнения элементов.
     * @return возвращает индекс, по которому находится опорный элемент,
     * чтобы снова делить массив на две части для рекурсивно сортировки.
     * @param <T> - тип элементов, которые будут в списке list.
     */
    private static <T> int partition(MyArrayList<T> list, int low, int high, Comparator<? super T> comparator) {
        T pivot = list.getElement(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.getElement(j), pivot) <= 0) {
                i++;
                list.swap(i, j);
            }
        }
        list.swap(i + 1, high);
        return i + 1;
    }

}
