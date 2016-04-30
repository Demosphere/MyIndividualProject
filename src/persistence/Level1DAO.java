package persistence;

import entity.Level1;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by Michael on 3/21/2016.
 */
public class Level1DAO {

    private final Logger log = Logger.getLogger(this.getClass());

    public List<Level1> getAllLevelOne () {
        List<Level1> levelOnes = new ArrayList<Level1>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        levelOnes = (ArrayList<Level1>)session.createCriteria(Level1.class).list();
        return levelOnes;
    }

    public void updateLevel1 (Level1 levelone) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(levelone);
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

    public Boolean deleteLevel1 (Level1 levelOne) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            Level1 LevelOneToDelete = (Level1)session.get(Level1.class, levelOne.getLevelOneID());
            session.delete(LevelOneToDelete);
            dbTransaction.commit();

        } catch (HibernateException error) {
            if (dbTransaction != null) dbTransaction.rollback();
            error.printStackTrace();
            return false;
        } finally {
            session.close();
        }

        return true;
    }

    public int addLevel1 (Level1 levelOne) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer levelOneID = null;
        try {
            tx = session.beginTransaction();
            levelOneID = (Integer) session.save(levelOne);
            tx.commit();
            log.info("Added Level: " + levelOne + " with id of: " + levelOneID);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return levelOneID;
    }
}
