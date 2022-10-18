package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookApplication
 {
    public static void main(String[] args) throws IOException {
        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of entries you want to make");
        int entries=Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<entries;i++)
        {
            //Object Mapping
            Book book=new Book();
            System.out.println("Enter the name of the book");
            String name = bufferedReader.readLine();
            System.out.println("Enter the author's name");
            String author_name = bufferedReader.readLine();
            System.out.println("Enter the price of the book");
            float price = Float.parseFloat(bufferedReader.readLine());
            book.setBook_name(name);
            book.setAuthor_name(author_name);
            book.setBook_price(price);
            //Mapping with relational==>save method will help in adding/insertion of record
            session.save(book);
        }
        System.out.println("We are going right.....");
        transaction.commit();//To save in the database
        session.close();
        sessionFactory.close();
    }
 }
