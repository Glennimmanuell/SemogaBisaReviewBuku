package com.example.semogabisareviewbuku;

public class Review {
    private String username;
    private String title;
    private String author;
    private String review;

    public Review(String username, String title, String author, String review) {
        this.username = username;
        this.title = title;
        this.author = author;
        this.review = review;
    }

    // Getter methods
    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getReview() {
        return review;
    }

    // Setter methods
    public void setUsername(String username) {
        this.username = username;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
