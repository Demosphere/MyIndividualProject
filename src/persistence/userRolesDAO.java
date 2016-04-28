package persistence;

import entity.UserRoles;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 3/14/2016.
 */
public class UserRolesDAO {


    private final Logger log = Logger.getLogger(this.getClass());

    public List<UserRoles> getAllRoles() {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<UserRoles> allRoles = new ArrayList<UserRoles>();

        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(UserRoles.class);
            List<UserRoles> roles = criteria.list();

            for (UserRoles r: roles) {
                allRoles.add(r);
            }

            tx.commit();
        } catch (HibernateException e) {
            if(tx != null) {
                e.printStackTrace();
            }
        } finally {
            session.close();
        }

        return allRoles;
    }

    public void updateRole(UserRoles role) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(role);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteRole(UserRoles role) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(role);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public int addRole(UserRoles role) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(role);
            tx.commit();
            log.info("Added role: " + role + " with id of: " + id);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return id;

    }}
