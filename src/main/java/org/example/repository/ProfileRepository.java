package org.example.repository;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.Profile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Setter
@Repository
public class ProfileRepository {
    @Autowired
    SessionFactory sessionFactory;
    public Profile login(String login, String password) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Query query = session.createQuery("from Profile where login=:l and password=:p");
        query.setParameter("l", login);
        query.setParameter("p",password);
        Profile profile = (Profile) query.getSingleResult();
        t.commit();

        return profile;
    }

    public Profile getProfileByPhone(String phone) {
//        select * from profile where login=? or phone=?
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Query query = session.createQuery("from Profile where  phone=:p");
        query.setParameter("p",phone);
        Profile profile = (Profile) query.getSingleResult();
        t.commit();

        return profile;
    }

    public Profile getProfileByLogin(String login) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Query query = session.createQuery("from Profile where  login=:l");
        query.setParameter("l",login);
        Profile profile = (Profile) query.getSingleResult();
        t.commit();
        session.close();
        return profile;
    }

    public boolean addProfile(Profile profile) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.save(profile);
        t.commit();
        session.close();
        return true;

    }
}
