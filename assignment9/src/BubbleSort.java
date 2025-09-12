public class BubbleSort implements SortStrategy {

    public void bubbleSorting(int[] arr, int n) {


        // Bubble sort algorithm https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/

        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }


    }

    @Override
    public void sort(int[] array) {
        long startTime = System.nanoTime();
        bubbleSorting(array, array.length);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.printf("Bubble Sort completed in %,d ns (%.6f s), sorting %,d elements.%n", timeElapsed, timeElapsed / 1_000_000_000.0, array.length);
        System.out.println("-----------------------------------" );
    }
}


