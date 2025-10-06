package org.example;

import java.util.*;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final List<Recommendation> recs = new ArrayList<>();

    public static void main(String[] args) {
        initDemo(); // keep or delete — just helps demo immediately

        println("=== Book Recs (Prototype Demo) ===");
        while (true) {
            println("1 list\n" +
                    "2 new\n" +
                    "3 clone\n" +
                    "4 view\n" +
                    "5 quit");
            print("> ");
            int cmd = in.nextInt();

            switch (cmd) {
                case 1: list(); break;
                case 2: create(); break;
                case 3: cloneAndTweak(); break;
                case 4: view(); break;
                case 5: println("bye!"); return;
                default: println("unknown command");
            }
        }
    }

    private static void list() {
        if (recs.isEmpty()) { println("(no recommendations yet)"); return; }
        for (int i = 0; i < recs.size(); i++) {
            Recommendation r = recs.get(i);
            println("#" + i + " • audience: " + r.getTargetAudience() + " • books: " + r.getBooks().size());
        }
    }

    private static void view() {
        Integer idx = pickIndex();
        if (idx == null) return;
        Recommendation r = recs.get(idx);
        println("\nAudience: " + r.getTargetAudience());
        if (r.getBooks().isEmpty()) { println("(no books)"); return; }
        for (Book b : r.getBooks()) {
            println("- " + b.getTitle() + " — " + b.getAuthor() +
                    " (" + b.getGenre() + ", " + b.getPublicationYear() + ")");
        }
    }

    private static void create() {
        println("\nCreate new recommendation");
        print("Target audience: ");
        String audience = in.nextLine().trim();
        Recommendation r = new Recommendation(audience);

        while (true) {
            Book b = promptBookOrFinish();
            if (b == null) break;
            r.addBook(b);
        }
        recs.add(r);
        println("Created as #" + (recs.size() - 1));
    }

    private static void cloneAndTweak() {
        Integer idx = pickIndex();
        if (idx == null) return;

        Recommendation clone = recs.get(idx).clone();

        println("\nCloned #" + idx + " → working copy");
        print("New audience (blank to keep '" + clone.getTargetAudience() + "'): ");
        String newAud = in.nextLine().trim();
        if (!newAud.isEmpty()) clone.setTargetAudience(newAud);

        println("\nAdd one book? [y/N]");
        if ((in.nextLine().trim().equalsIgnoreCase("y"))) {
            Book b = promptBookMinimal();
            if (b != null) clone.addBook(b);
        }

        println("Remove a book by title? (blank to skip)");
        String removeTitle = in.nextLine().trim();
        if (!removeTitle.isEmpty()) clone.removeBookByTitle(removeTitle);

        recs.add(clone);
        println("Saved clone as #" + (recs.size() - 1));
    }

    private static Book promptBookOrFinish() {
        print("Book title (blank to finish): ");
        String title = in.nextLine().trim();
        if (title.isEmpty()) return null;
        print("Author: "); String author = in.nextLine().trim();
        print("Genre: "); String genre = in.nextLine().trim();
        int year = readInt("Year: ");
        return new Book(title, author, genre, year);
    }

    private static Book promptBookMinimal() {
        print("Title: "); String title = in.nextLine().trim();
        if (title.isEmpty()) { println("skipped"); return null; }
        print("Author: "); String author = in.nextLine().trim();
        print("Genre: "); String genre = in.nextLine().trim();
        int year = readInt("Year: ");
        return new Book(title, author, genre, year);
    }

    private static Integer pickIndex() {
        if (recs.isEmpty()) { println("(nothing to pick)"); return null; }
        list();
        int i = readInt("Pick index: ");
        if (i < 0 || i >= recs.size()) { println("invalid index"); return null; }
        return i;
    }

    private static int readInt(String prompt) {
        while (true) {
            print(prompt);
            String s = in.nextLine().trim();
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) { println("enter a number"); }
        }
    }

    private static void initDemo() {
        Recommendation r = new Recommendation("YA fantasy lovers");
        r.addBook(new Book("Six of Crows", "Leigh Bardugo", "Fantasy", 2015));
        r.addBook(new Book("The Hobbit", "J. R. R. Tolkien", "Fantasy", 1937));
        recs.add(r);
    }

    private static void println(String s) { System.out.println(s); }
    private static void print(String s) { System.out.print(s); }
}
