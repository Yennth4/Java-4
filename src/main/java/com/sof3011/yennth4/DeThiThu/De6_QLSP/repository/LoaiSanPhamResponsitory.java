package com.sof3011.yennth4.DeThiThu.De6_QLSP.repository;

import com.sof3011.yennth4.DeThiThu.De6_QLSP.entity.LoaiSanPham;
import com.sof3011.yennth4.DeThiThu.De6_QLSP.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

public class LoaiSanPhamResponsitory {
    public List<LoaiSanPham> getAll() {
        List<LoaiSanPham> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM LoaiSanPham", LoaiSanPham.class);
            list = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new LoaiSanPhamResponsitory().getAll());
    }

}
