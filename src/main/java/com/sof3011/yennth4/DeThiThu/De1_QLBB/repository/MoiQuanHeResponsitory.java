package com.sof3011.yennth4.DeThiThu.De1_QLBB.repository;

import com.sof3011.yennth4.DeThiThu.De1_QLBB.entity.MoiQuanHe;
import com.sof3011.yennth4.DeThiThu.De1_QLBB.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MoiQuanHeResponsitory {

    public List<MoiQuanHe> getAll() {
        List<MoiQuanHe> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MoiQuanHe", MoiQuanHe.class);
            list = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public MoiQuanHe getOneById(int id) {
        MoiQuanHe moiQuanHe = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MoiQuanHe WHERE id = :id", MoiQuanHe.class);
            query.setParameter("id", id);
            moiQuanHe = (MoiQuanHe) query.getSingleResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return moiQuanHe;
    }

    public boolean add(MoiQuanHe moiQuanHe) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(moiQuanHe);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean sua(MoiQuanHe moiQuanHe) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(moiQuanHe);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoa(MoiQuanHe moiQuanHe) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(moiQuanHe);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
