import java.util.Arrays;

public class SelectionSort {

    private int[] data;

    public SelectionSort(int[] data) {
        this.data = new int[data.length];
        this.data = data;
    }

    public int[] getElement() {
        return this.data;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.data);
    }

    public boolean isEmpty() {
        return this.data.length == 0;
    }

    public void sortArray() {

            for (int i = 0; i < this.data.length - 1; i++) {

            int indiceMenor = i;
            boolean achou = false;
            int smallest = this.data[i];

            for (int j = i + 1; j < this.data.length; j++) {
                if (smallest > this.data[j]) {
                    smallest = this.data[j];
                    indiceMenor = j;
                    achou = true;
                }
            }

            if (achou) {
                int aux = this.data[i];
                this.data[i] = this.data[indiceMenor];
                this.data[indiceMenor] = aux;
            }

        }


    }
}
