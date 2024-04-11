package com.sof3011.yennth4.DeThiThu.De9_QLNV.responsitory;

import com.sof3011.yennth4.DeThiThu.De9_QLNV.entity.ChucVu;
import com.sof3011.yennth4.DeThiThu.De9_QLNV.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ChucVuResponsitory {
    public List<ChucVu> getAll() {
        List<ChucVu> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu", ChucVu.class);
            list = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new ChucVuResponsitory().getAll());
    }
}
