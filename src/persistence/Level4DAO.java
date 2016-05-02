package persistence;

import entity.Level4;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by Michael on 3/21/2016.
 */
public class Level4DAO {

    private final Logger log = Logger.getLogger(this.getClass());

    public List<Level4> getAllLevelFour () {
        List<Level4> levelFours = new ArrayList<Level4>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        levelFours = (ArrayList<Level4>)session.createCriteria(Level4.class).list();
        return levelFours;
    }

    public void updateLevel4 (Level4 levelFour) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(levelFour);
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

    public Boolean deleteLevel4 (Level4 levelFour) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction dbTransaction = null;

        try {
            dbTransaction = session.beginTransaction();
            Level4 LevelFourToDelete = (Level4)session.get(Level4.class, levelFour.getLevelFourID());
            session.delete(LevelFourToDelete);
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

    public int addLevel4 (Level4 levelFour) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer levelFourID = null;
        try {
            tx = session.beginTransaction();
            levelFourID = (Integer) session.save(levelFour);
            tx.commit();
            log.info("Added Level 4: " + levelFour + " with id of: " + levelFourID);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return levelFourID;
    }
}
