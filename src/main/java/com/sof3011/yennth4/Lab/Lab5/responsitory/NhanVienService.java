package com.sof3011.yennth4.Lab.Lab5.responsitory;

import com.sof3011.yennth4.Lab.Lab5.entity.NhanVien;
import com.sof3011.yennth4.Lab.Lab5.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NhanVienService {

    public List<NhanVien> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        List<NhanVien> listNV = session.createQuery("FROM NhanVien").list();
        session.close();
        return listNV;
    }

    public NhanVien getOne(String ma) {
        Session session = HibernateUtil.getFACTORY().openSession();
        NhanVien nhanVien = (NhanVien) session.createQuery("FROM NhanVien WHERE ma = :ma")
                .setParameter("ma", ma)
                .getSingleResult();
        session.close();
        return nhanVien;
    }

    public boolean addNhanVien(NhanVien nhanVien) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteNhanVien(NhanVien nhanVien) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            NhanVien nhanVienMa = session.get(NhanVien.class, nhanVien.getMa());
            session.delete(nhanVienMa);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
