package com.sof3011.yennth4.DeThiThu.De2_QLBB.repository;
import com.sof3011.yennth4.DeThiThu.De2_QLBB.entity.MoiQuanHe;
import com.sof3011.yennth4.DeThiThu.De2_QLBB.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

public class MoiQuanHeResponsitory {

    public List<MoiQuanHe> getAll() {
        List<MoiQuanHe> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MoiQuanHe", MoiQuanHe.class);
            list = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
