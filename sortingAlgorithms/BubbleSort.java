import java.util.Arrays;

public class BubbleSort {

    private int[] data;

    public BubbleSort(int[] data) {
        this.data = data;
    }

    public int[] getElement() {
        return this.data;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.data);
    }

    public void sortedArray(int[] array) {


        int AUX = array[0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    array = Util.swap(j, array);
                }
            }
        }

        this.data = array;


    }
}
