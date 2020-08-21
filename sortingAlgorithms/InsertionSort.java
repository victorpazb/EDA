import java.util.Arrays;


// https://www.youtube.com/watch?v=cUF_3sz0fR8  =====>>>> assistir esse video amanha
public class InsertionSort {

    private int[] array;

    public InsertionSort(int[] array) {
        this.array= array;
    }

    public void sortArray() {
        int arraySorted = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[arraySorted] > array[i]) {

                int j = i - 1;
                int x = i;
                arraySorted++;

                while (j >= 0) {
                    if (array[x] < array[j]) {

                        int aux = array[x];

                        array[x] = array[j];
                        array[j] = aux;
                        x--;
                    }
                    j--;

                }
            }
        }

    }

    @Override
    public String toString() {
        return "InsertionSort{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
	}
