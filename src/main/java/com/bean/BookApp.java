package com.bean;


import dao.BookDaoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BookApp
{
    public static void main(String[] args) throws IOException
    {
        Book book;
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        BookDaoImpl bookDao=new BookDaoImpl();
        System.out.println("Enter 1 for insert");
        System.out.println("Enter 2 for update");
        System.out.println("Enter 3 for Delete");
        System.out.println("Enter 4 to display all");
        System.out.println("Enter 5 for fetch by price");
        System.out.println("Enter 6 for fetching by descending order of price");
        System.out.println("Enter 7 for fetching by name and price");
        System.out.println("Enter 8 For fetching selected price and name");
        System.out.println("Enter 9 for exit");
        int ch=Integer.parseInt(bufferedReader.readLine());
            switch (ch) {
                case 1://Insert
                    System.out.println("Enter book details==> Book name,author name and price");
                    book = new Book();
                    book.setBook_name(bufferedReader.readLine());
                    book.setAuthor_name(bufferedReader.readLine());
                    book.setBook_price(Float.parseFloat(bufferedReader.readLine()));
                    int i = bookDao.insertBook(book);
                    if (i > 0) {
                        System.out.println("Record added ");
                    } else {
                        System.out.println("Try again");
                    }
                    break;
                case 2://Update
                {
                    System.out.println("Enter the name");
                    String name = bufferedReader.readLine();
                    System.out.println("Enter the price");
                    float price = Float.parseFloat(bufferedReader.readLine());
                    i = bookDao.updateBook(name, price);
                    if (i > 0) {

                        System.out.println("Record added successfully");
                    } else
                        System.out.println("Try again");
                    break;
                }
                case 3://Delete
                {
                    System.out.println("Enter the id");
                    int id = Integer.parseInt(bufferedReader.readLine());
                    i = bookDao.deleteBook(id);
                    if (i > 0) {

                        System.out.println("Record deleted successfully");
                    } else
                        System.out.println("Try again");
                    break;
                }
                case 4: //Select All
                {
                    System.out.println("All the details are");
                    List<Book> bookList = bookDao.retrieveBook();
                    bookList.stream().forEach(System.out::println);

                    break;
                }
                case 5://display values for specific or greater price
                {
                    System.out.println("Enter price");
                    float p = Float.parseFloat(bufferedReader.readLine());
                    List<Book> list = bookDao.fetchByCriteria(p);
                    list.stream().forEach(System.out::println);
                    break;
                }
                case 6://Descending order of the price
                {
                    System.out.println("The order of books in descending order on the basis of price is");
                    List<Book> list = bookDao.fetchByDescendingPrice();
                    list.stream().forEach(System.out::println);
                    break;
                }
                case 7:
                {
                    System.out.println("The name and the price of the book is as follows");
                    bookDao.fetchByNameAndPrice();
                }
                case 8:
                {
                    System.out.println("Enter the price you want to filter for");
                    float price=Float.parseFloat(bufferedReader.readLine());
                    bookDao.fetchBypricing(price);

                }
                case 9:
                {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Select a valid number");
                }
            }
        }
    }

