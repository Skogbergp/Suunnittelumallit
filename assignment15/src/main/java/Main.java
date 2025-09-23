public class Main {
    public static void main(String[] args) {
        CalendarToNewDateAdapter adapter = new CalendarToNewDateAdapter();
        System.out.println(adapter.getDay());
        System.out.println(adapter.getMonth());
        System.out.println(adapter.getYear());

        adapter.setYear(2015);
        System.out.println(adapter.getDay());
        System.out.println(adapter.getMonth());
        System.out.println(adapter.getYear());

        adapter.advanceDays(500);
        System.out.println(adapter.getDay());
        System.out.println(adapter.getMonth());
        System.out.println(adapter.getYear());

        adapter.advanceDays(2500);
        System.out.println(adapter.getDay());
        System.out.println(adapter.getMonth());
        System.out.println(adapter.getYear());

    }
}
