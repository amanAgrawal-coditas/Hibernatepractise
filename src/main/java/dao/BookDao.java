package dao;

import com.bean.Book;

import java.util.List;

public interface BookDao
{
     int insertBook(Book book);

    int updateBook(String bn, float price);

    int deleteBook(int id);

     List<Book> retrieveBook();
     List<Book> fetchByCriteria(float p);
     List<Book> fetchByDescendingPrice();
      void fetchByNameAndPrice();
      void fetchBypricing(float price);

}
