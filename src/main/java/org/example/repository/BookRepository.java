package org.example.repository;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Setter
@Getter
@Repository
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> getList() {
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("FROM Book ");
        List<Book> list = query.getResultList();
        System.out.println(list);
        session.close();
        return list;
    }
}
