package com.example.Library.App.server.model;

import javax.persistence.*;

@Entity
@Table(name="BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITLE", nullable = false, unique = true, length = 45)
    private String title;
    @Column(name = "AUTHOR", nullable = false, unique = true, length = 45)
    private String author;
    @Column(name = "DESCRIPTION", nullable = false, unique = true, length = 300)
    private String desciption;
    @Column(name = "IMAGEURL", nullable = false, unique = true, length = 45)
    private String imageUrl;
    @Column(name = "PRICE", nullable = false, length = 45)
    private float price;

    public Book(String title, String author, String desciption, String imageUrl, float price) {
        this.title = title;
        this.author = author;
        this.desciption = desciption;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
