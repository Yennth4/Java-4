package com.sof3011.yennth4.DeThiThu.De6_QLSP.repository;

import com.sof3011.yennth4.DeThiThu.De6_QLSP.entity.SanPham;
import com.sof3011.yennth4.DeThiThu.De6_QLSP.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class SanPhamResponsitory {

    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham", SanPham.class);
            list = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public SanPham getOneById(int id) {
        SanPham sanPham = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham WHERE id = :id", SanPham.class);
            query.setParameter("id", id);
            sanPham = (SanPham) query.getSingleResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public boolean add(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sanPham);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sanPham);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SanPhamResponsitory().getAll());
    }
}
