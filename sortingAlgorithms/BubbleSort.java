import java.util.Arrays;

public class BubbleSort {

    private int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    public int[] getElement() {
        return this.array;
    }

    public void sortArray() {

        boolean arrayAlreadySorted = true;
        int loopsCount = 0;
        for (int i = 0; i < this.array.length; i++) {

            arrayAlreadySorted = true;
            for (int j = 0; j < this.array.length - 1; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    Util.swap(j, this.array);
                    arrayAlreadySorted = false;
                }

                loopsCount += 1;
            }
            if (arrayAlreadySorted) {
                break;
            }
            System.out.println(loopsCount);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
}
