package com.sof3011.yennth4.B9_UID_2Table.responsitory;
import com.sof3011.yennth4.B9_UID_2Table.entity.SanPham;
import com.sof3011.yennth4.B9_UID_2Table.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SanPhamResponsitory {

    public List<SanPham> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        List<SanPham> listSP = session.createQuery("FROM SanPham").list();
        session.close();
        return listSP;
    }

    public boolean create (SanPham sanPham) {
        Transaction tra = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tra = session.beginTransaction();
            session.persist(sanPham);
            tra.commit();
            session.close();
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SanPhamResponsitory().getAll());
    }
}
