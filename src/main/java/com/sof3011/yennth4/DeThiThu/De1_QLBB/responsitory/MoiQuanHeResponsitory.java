package com.sof3011.yennth4.DeThiThu.De1_QLBB.responsitory;

import com.sof3011.yennth4.DeThiThu.De1_QLBB.entity.MoiQuanHe;
import com.sof3011.yennth4.DeThiThu.De1_QLBB.entity.MoiQuanHe;
import com.sof3011.yennth4.DeThiThu.De1_QLBB.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class MoiQuanHeResponsitory {

    public List<MoiQuanHe> getAll() {

        List<MoiQuanHe> listMoiQuanHe = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MoiQuanHe", MoiQuanHe.class);
            listMoiQuanHe = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMoiQuanHe;
    }

    public MoiQuanHe getOne(int id) {
        MoiQuanHe moiQuanHe = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MoiQuanHe WHERE id = :id", MoiQuanHe.class);
            query.setParameter("id" , id);
            moiQuanHe = (MoiQuanHe) query.getSingleResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return moiQuanHe;
    }

    public static void main(String[] args) {
        System.out.println(new MoiQuanHeResponsitory().getAll());
    }
}
