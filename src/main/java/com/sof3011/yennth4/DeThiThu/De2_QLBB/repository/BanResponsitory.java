package com.sof3011.yennth4.DeThiThu.De2_QLBB.repository;

import com.sof3011.yennth4.DeThiThu.De2_QLBB.entity.Ban;
import com.sof3011.yennth4.DeThiThu.De2_QLBB.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

public class BanResponsitory {
    public List<Ban> getAll() {
        List<Ban> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Ban" , Ban.class);
            list = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Ban getOne(int id) {
        Ban ban = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Ban WHERE id = :id" , Ban.class);
            query.setParameter("id" , id);
            ban = (Ban) query.getSingleResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ban;
    }

    public boolean sua(Ban ban) {
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            session.merge(ban);
            session.beginTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean them(Ban ban) {
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            session.persist(ban);
            session.beginTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoa(Ban ban) {
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            session.delete(ban);
            session.beginTransaction().commit();
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

