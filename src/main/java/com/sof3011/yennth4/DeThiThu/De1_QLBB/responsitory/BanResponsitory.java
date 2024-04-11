package com.sof3011.yennth4.DeThiThu.De1_QLBB.responsitory;

import com.sof3011.yennth4.DeThiThu.De1_QLBB.entity.Ban;
import com.sof3011.yennth4.DeThiThu.De1_QLBB.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BanResponsitory {

    public List<Ban> getAll() {

        List<Ban> listBan = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Ban", Ban.class);
            listBan = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBan;
    }

    public Ban getOne(int id) {
        Ban ban = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Ban WHERE id = :id", Ban.class);
            query.setParameter("id" , id);
            ban = (Ban) query.getSingleResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ban;
    }

    public boolean add(Ban ban){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ban);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Ban ban){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ban);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Ban ban){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ban);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new BanResponsitory().getAll());
    }
}
