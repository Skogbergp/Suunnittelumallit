import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class BogoSort  implements SortStrategy, Runnable {

    //https://www.geeksforgeeks.org/dsa/java-program-for-bogosort-or-permutation-sort/
    private BigInteger shuffleCount = BigInteger.ZERO;
    private String name;
    private int[] arr;
    ArrayList<String> messages = new ArrayList<>();

    public BogoSort(String name ,int[] array) {
        this.arr = array;
        this.name = name;
        loadMessages();

    }
    public void loadMessages() {
        InputStream input = getClass().getClassLoader().getResourceAsStream("messages.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                messages.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("BogoSort is lonely. No messages found.");
        }
    }
    public void bogoSortStart(int[] a)
    {
        // if array is not sorted then shuffle the
        // array again
        while (isSorted(a) == false){
            shuffleCount = shuffleCount.add(BigInteger.ONE);
            shuffle(a);

            if (shuffleCount.mod(new BigInteger("10000000")).equals(BigInteger.ZERO)) {
                System.out.println(messages.get((int)(Math.random() * messages.size())));
                System.out.println("Shuffle count is: " + shuffleCount);
            }
        }



    }

    // To generate permutation of the array
    void shuffle(int[] a)
    {
        // Math.random() returns a double positive
        // value, greater than or equal to 0.0 and
        // less than 1.0.
        for (int i = 0; i < a.length; i++)
            swap(a, i, (int)(Math.random() * i));
    }

    // Swapping 2 elements
    void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // To check if array is sorted or not
    boolean isSorted(int[] a)
    {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i - 1])
                return false;
        return true;
    }

    // Prints the array
    void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    @Override
    public void sort(int[] array) {
        long startTime = System.nanoTime();
        if (Math.random() < 0.5) {
            System.out.println("\n⚡⚡⚡ GREAT SORTING GODS OF CHAOS HAVE SUMMONED ME ⚡⚡⚡");
            System.out.println("🔥 THE GREAT " + name.toUpperCase() + " HAS ARRIVED 🔥\n");
        }else{
            System.out.println("🌪️🌪️🌪️ CHAOS ENGAGED 🌪️🌪️🌪️");
            System.out.println("I, " + name + ", DEFY ORDER AND EMBRACE RANDOMNESS!");

        }


        bogoSortStart(array);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.printf("Bogo Sort completed in %,d ns, sorting %,d elements.%n", timeElapsed, array.length);
        System.out.printf("Bogo Sort performed %,d shuffles.%n", shuffleCount);
        System.out.println("-----------------------------------" );
    }


    @Override
    public void run() {
        sort(arr);


    }
}
