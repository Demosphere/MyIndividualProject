package persistence;

import entity.Level2;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by Michael on 3/21/2016.
 */
public class Level2DAO {

    private final Logger log = Logger.getLogger(this.getClass());

    public List<Level2> getAllLevelTwo () {
        List<Level2> levelOnes = new ArrayList<Level2>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        levelOnes = (ArrayList<Level2>)session.createCriteria(Level2.class).list();
        return levelOnes;
    }

    public void updateLevel2 (Level2 leveltwo) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(leveltwo);
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

    public Boolean deleteLevel2 (Level2 levelOne) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            Level2 LevelTeoToDelete = (Level2)session.get(Level2.class, levelOne.getLevelOneID());
            session.delete(LevelTeoToDelete);
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

    public int addLevel2 (Level2 levelTwo) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer levelTwoID = null;
        try {
            tx = session.beginTransaction();
            levelTwoID = (Integer) session.save(levelTwo);
            tx.commit();
            log.info("Added Level: " + levelTwo + " with id of: " + levelTwoID);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return levelTwoID;
    }
}
