public class SortContext {
    private SortStrategy strategy;

    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] array) {
        if (strategy == null) {
            throw new IllegalStateException("SortStrategy not set");
        }
        strategy.sort(array);
    }
}
