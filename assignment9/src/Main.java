public class Main {
    public static void main(String[] args) {

        int[] bogoarr1 = randomArray(5);
       Thread bogo1 = new Thread (new BogoSort("bogo1",bogoarr1));

        int[] bogoarr2 = randomArray(10);
        Thread bogo2 = new Thread (new BogoSort("bogo2",bogoarr2));
        bogo1.start();
        bogo2.start();




        SortContext context = new SortContext();

        context.setSortStrategy(new BubbleSort());
        int[] arr1 = randomArray(10);

        context.sortArray(arr1);

        context.setSortStrategy(new MergeSort());
        int[] arr2 = randomArray(10);
        context.sortArray(arr2);

        context.setSortStrategy(new RadixSort());
        int[] arr3 = randomArray(10);
        context.sortArray(arr3);

        context.setSortStrategy(new BubbleSort());
        arr1 = randomArray(100);

        context.sortArray(arr1);

        context.setSortStrategy(new MergeSort());
        arr2 = randomArray(100);
        context.sortArray(arr2);

        context.setSortStrategy(new RadixSort());
        arr3 = randomArray(100);
        context.sortArray(arr3);

        try {
            bogo1.join();
            bogo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }
    public static int[] randomArray(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }
    public static void print(int[] arr, int n){
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
