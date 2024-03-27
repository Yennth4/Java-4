package com.sof3011.yennth4.BTVN.BTVN_B10.repository;


import com.sof3011.yennth4.BTVN.BTVN_B10.config.HibernateConfig;
import com.sof3011.yennth4.BTVN.BTVN_B10.entity.GiangVien;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GiangVienRepository {

    public List<GiangVien> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<GiangVien> lists = session.createQuery("FROM GiangVien").getResultList();
        session.close();
        return lists;
    }

    public GiangVien getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        GiangVien giangVien = null;
        try {
            Query query = session.createQuery("FROM GiangVien WHERE id = :id");
            query.setParameter("id", id);
            giangVien = (GiangVien) query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return giangVien;
    }


    public boolean add(GiangVien gv) {
        Transaction tra = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            tra = s.beginTransaction();
            s.persist(gv);
            tra.commit();
            return false;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return true;
    }

        public boolean update(GiangVien gv) {
        Transaction tra = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            tra = s.beginTransaction();
            s.merge(gv); // Update
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public boolean delete(GiangVien gv) {
        Transaction tra = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            tra = s.beginTransaction();
            s.delete(gv);
            tra.commit();
            return false;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return true;
    }

}
