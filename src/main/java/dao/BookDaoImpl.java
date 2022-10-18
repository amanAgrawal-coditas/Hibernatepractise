package dao;

import com.bean.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.Iterator;
import java.util.List;

public class BookDaoImpl implements BookDao
  {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    @Override
    public int insertBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int i = (int) session.save(book);
        if (i > 0) {
            transaction.commit();
            System.out.println("Record added successfully");
        } else
            System.out.println("Try again");
        return i;
    }

    @Override
    public int updateBook(String bn, float price) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Book SET book_price=:x where book_name=:y");
        query.setParameter("x", price);
        query.setParameter("y", bn);
        int i = query.executeUpdate();
        if (i > 0) {
            transaction.commit();
            System.out.println("Record updated successfully");
        }
        else
        {
            System.out.println("Try again");
        }
        return i;
    }

    @Override
    public int deleteBook(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("Delete from Book where id=:id");
        query.setParameter("id", id);
        int i = query.executeUpdate();
        if (i > 0) {
            transaction.commit();
            System.out.println("Record added successfully");
        } else
        {
            System.out.println("Try again");
        }
        return i;
    }

    @Override
    public List<Book> retrieveBook()
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Book");
        List<Book> list = query.list();
        int i = 1;
        if (i > 0)
        {
            transaction.commit();
            System.out.println("Record retrieved successfully");
        }
        else
        {
            System.out.println("Try again");
        }
        return list;
    }
    @Override
    public List<Book> fetchByCriteria(float p)
    {
          //Fetch by restrictions/criteria
          Session session=configuration.buildSessionFactory().openSession();
          Criteria criteria=session.createCriteria(Book.class);//select * from book
          criteria.add(Restrictions.gt("book_price",p));//where price >p
          return criteria.list();
    }

      public List<Book> fetchByDescendingPrice()
      {
          //Fetching by Price in descending order
          Session session=configuration.buildSessionFactory().openSession();
          Criteria criteria=session.createCriteria(Book.class);
          criteria.addOrder(Order.desc("book_price"));
          return criteria.list();
      }
     public void fetchByNameAndPrice()
     {
         Session session=configuration.buildSessionFactory().openSession();
         Criteria criteria= session.createCriteria(Book.class);
         Projection nameProjection= Projections.property("book_name");
         Projection priceProjection=Projections.property("book_price");
         ProjectionList projectionList=Projections.projectionList();
         projectionList.add(nameProjection);
         projectionList.add(priceProjection);
         criteria.setProjection(projectionList);
         List list=criteria.list();
         Iterator it=list.iterator();

         while(it.hasNext())
         {
             Object ob[] = (Object[])it.next();
             System.out.println(ob[0]+" "+ob[1]);

         }
     }
      public void fetchBypricing(float price)
      {
          Session session=configuration.buildSessionFactory().openSession();
          Criteria criteria=session.createCriteria(Book.class);
          Projection nameProjection= Projections.property("book_name");
          Projection priceProjection=Projections.property("book_price");
          Projection authorProjection=Projections.property("author_name");
          ProjectionList projectionList=Projections.projectionList();
          projectionList.add(nameProjection);
          projectionList.add(priceProjection);
          projectionList.add(authorProjection);
          criteria.setProjection(projectionList);
          criteria.add(Restrictions.gt("book_price",price));
          criteria.addOrder(Order.asc("book_price"));
          List list=criteria.list();
          Iterator it=list.iterator();

          while(it.hasNext())
          {
              Object ob[] = (Object[])it.next();
              System.out.println(ob[0]+" "+ob[1]+" "+ob[2]);

          }
      }


  }
