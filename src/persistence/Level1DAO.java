//package persistence;
//
//import entity.Level1;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.apache.log4j.Logger;
//
///**
// * Created by Michael on 3/21/2016.
// */
//public class Level1DAO {
//
//    private final Logger log = Logger.getLogger(this.getClass());
//
//    public List<Level1> getAllLevelOne () {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        Transaction tx = null;
//
//        List<Level1> levelOne = new ArrayList<Level1>();
//
//        try{
//            tx = session.beginTransaction();
//            levelOne = session.createQuery("FROM level1").list();
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//        return levelOne;
//    }
//
//    public void updateLevel1 (int updateLevel1ID) {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Level1 levelOne = (Level1)session.get(Level1.class);
//
//            session.update(levelOne);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//
//    public void deleteLevel1 (Level1 level1) {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            level1 = (Level1)session.get(Level1.class, level1.getLevelOneID());
//            session.delete(level1);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//
//    public int addLevel1 (Level1 level1) {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        Transaction tx = null;
//        Integer userId = null;
//        try {
//            tx = session.beginTransaction();
//            userId = (Integer) session.save(level1);
//            tx.commit();
//            log.info("Added user: " + level1 + " with id of: " + userId);
//        } catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            log.info(e.toString());
//        } finally {
//            session.close();
//        }
//        return userId;
//    }
//}
