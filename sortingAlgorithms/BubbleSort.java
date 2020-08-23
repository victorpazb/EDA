import java.util.Arrays;

public class BubbleSort {

    private int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    public void sortArray() {

        boolean sorted = true;
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					
                    //SWAPPING
                    int aux = array[j + 1];
					array[j + 1] = array[j];
					array[j] = aux;
					
                    //means that the array is not sorted yet
                    sorted = false;
				}
			}
			
			if(sorted){
				break;
			}
			ord = true;
		}
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
}
