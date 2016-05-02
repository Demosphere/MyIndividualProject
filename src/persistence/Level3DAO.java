package persistence;

import entity.Level3;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by Michael on 3/21/2016.
 */
public class Level3DAO {

    private final Logger log = Logger.getLogger(this.getClass());

    public List<Level3> getAllLevel3 () {
        List<Level3> levelOnes = new ArrayList<Level3>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        levelOnes = (ArrayList<Level3>)session.createCriteria(Level3.class).list();
        return levelOnes;
    }

    public void updateLevel3 (Level3 levelThree) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(levelThree);
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

    public Boolean deleteLevel3 (Level3 levelThree) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            Level3 LevelThreeToDelete = (Level3)session.get(Level3.class, levelThree.getLevelThreeID());
            session.delete(LevelThreeToDelete);
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

    public int addLevel3 (Level3 levelThree) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer levelThreeID = null;
        try {
            tx = session.beginTransaction();
            levelThreeID = (Integer) session.save(levelThree);
            tx.commit();
            log.info("Added Level 3: " + levelThree + " with id of: " + levelThreeID);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return levelThreeID;
    }
}
