package com.sof3011.yennth4.DeThiThu.De9_QLNV.responsitory;

import com.sof3011.yennth4.DeThiThu.De9_QLNV.util.HibernateUtil;
import com.sof3011.yennth4.DeThiThu.De9_QLNV.entity.NhanVien;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class NhanVienResponsitory {

    public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien", NhanVien.class);
            list = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public NhanVien getOne(int id) {
        NhanVien nhanVien = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien WHERE id = :id", NhanVien.class);
            query.setParameter("id" , id);
            nhanVien = (NhanVien) query.getSingleResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    public boolean add(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nhanVien);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean sua(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoa(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new NhanVienResponsitory().getAll());
    }
}
