package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Recommendation> recommendations = new HashMap<>();

        while (true) {
            System.out.println("\n--- Book Recommendation System ---");
            System.out.println("1. Create new recommendation");
            System.out.println("2. View recommendations");
            System.out.println("3. Clone and modify recommendation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter target audience: ");
                    String audience = scanner.nextLine();
                    Recommendation rec = new Recommendation(audience);
                    while (true) {
                        System.out.print("Book title (or 'done'): ");
                        String title = scanner.nextLine();
                        if (title.equalsIgnoreCase("done")) break;
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Genre: ");
                        String genre = scanner.nextLine();
                        System.out.print("Publication Year: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        rec.addBook(new Book(title, author, genre, year));
                    }
                    recommendations.put(audience, rec);
                    System.out.println("Recommendation created.");
                    break;

                case "2":
                    for (Recommendation r : recommendations.values()) {
                        System.out.println("\n--- " + r.getTargetAudience() + " ---");
                        System.out.println(r);
                    }
                    break;

                case "3":
                    System.out.print("Enter the audience to clone: ");
                    String source = scanner.nextLine();
                    Recommendation original = recommendations.get(source);
                    if (original != null) {
                        Recommendation cloned = original.clone();
                        System.out.print("New target audience: ");
                        String newAudience = scanner.nextLine();
                        cloned.setTargetAudience(newAudience);
                        while (true) {
                            System.out.print("Add or remove book? (add/remove/done): ");
                            String action = scanner.nextLine();
                            if (action.equalsIgnoreCase("done")) break;
                            if (action.equalsIgnoreCase("add")) {
                                System.out.print("Book title: ");
                                String title = scanner.nextLine();
                                System.out.print("Author: ");
                                String author = scanner.nextLine();
                                System.out.print("Genre: ");
                                String genre = scanner.nextLine();
                                System.out.print("Publication Year: ");
                                int year = Integer.parseInt(scanner.nextLine());
                                cloned.addBook(new Book(title, author, genre, year));
                            } else if (action.equalsIgnoreCase("remove")) {
                                System.out.print("Title to remove: ");
                                String title = scanner.nextLine();
                                cloned.removeBookByTitle(title);
                            }
                        }
                        recommendations.put(newAudience, cloned);
                        System.out.println("Cloned and modified recommendation saved.");
                    } else {
                        System.out.println("Audience not found.");
                    }
                    break;

                case "4":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
