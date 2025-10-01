package org.example;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable{
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<Book>();
    }
    public String getTargetAudience() {
        return targetAudience;

    }
    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }
    public List<Book> getBooks() {
        return books;
    }
    public void addBook(Book book) {
        this.books.add(book);
    }
    public void printBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public void getBookByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {

            }
        }

    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation cloned = (Recommendation) super.clone();
            cloned.books = new ArrayList<>();
            for (Book book : this.books) {
                cloned.books.add(book.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed", e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Target Audience: " + targetAudience + "\nBooks:\n");
        for (Book book : books) {
            sb.append("  ").append(book).append("\n");
        }
        return sb.toString();
    }
    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

}
