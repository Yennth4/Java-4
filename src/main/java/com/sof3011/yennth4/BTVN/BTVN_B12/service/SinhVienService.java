package com.sof3011.yennth4.BTVN.BTVN_B12.service;

import com.sof3011.yennth4.B8_Hibernate.util.HibernateUtil;
import com.sof3011.yennth4.BTVN.BTVN_B12.entity.SinhVien;
import org.hibernate.Session;

import java.util.List;

public class SinhVienService {

    public Session session;

    public SinhVienService() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<SinhVien> getAll() {
        List<SinhVien> listSinhVien = session.createQuery("FROM SinhVien ").getResultList();
        session.close();
        return listSinhVien;
    }

    public boolean addSinhVien(SinhVien sinhVien) {
        try {
            session.persist(sinhVien);
            session.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
