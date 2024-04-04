package com.sof3011.yennth4.Lab.Lab6.responsitory;
import com.sof3011.yennth4.Lab.Lab6.entity.KhachHang;
import com.sof3011.yennth4.Lab.Lab6.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class KhachHangResponsitory {

    public List<KhachHang> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        List<KhachHang> listKH = session.createQuery("FROM KhachHang").list();
        session.close();
        return listKH;
    }

    public void updateKhachHang(KhachHang khachHang , String makh) {
        Session session = HibernateUtil.getFACTORY().openSession();

        session.close();
    }
}
