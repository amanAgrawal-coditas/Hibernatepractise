package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "Book_info")//Optional
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int book_id;
    private String book_name,author_name;
    private float book_price;

    public int getBook_id()
    {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public float getBook_price() {
        return book_price;
    }

    public void setBook_price(float book_price)
    {
        this.book_price = book_price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", author_name='" + author_name + '\'' +
                ", book_price=" + book_price +
                '}';
    }
}
