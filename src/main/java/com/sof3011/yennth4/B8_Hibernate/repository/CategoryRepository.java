package com.sof3011.yennth4.B8_Hibernate.repository;

import com.sof3011.yennth4.B8_Hibernate.entity.Category;
import com.sof3011.yennth4.B8_Hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryRepository {

    public Session session = HibernateUtil.getFACTORY().openSession();

    public List<Category> getAll() {
        List<Category> listCategory = session.createQuery("FROM Category").list();
        session.close();
        return listCategory;
    }

    public Category getOne(Long id) {
        Category category = (Category) session.createQuery("FROM Category WHERE id =:id").getSingleResult();
        // id phía trước là của class , phía sau là của thuộc tính db
        // getSingleResult : láy ra 1 dòng dữ liệu

        session.close();
        return category;
    }

    // Add
    public boolean addCategory(Category category) {
        Transaction tra = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            tra = session.beginTransaction();
            session.persist(category); // add
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    // Update
    public boolean updateCategory(Category category) {
        Transaction tra = null;
        try {
            tra = session.beginTransaction();
            session.merge(category); // update
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    // Delete
    public boolean deleteCategory(Category category) {
        Transaction tra = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            tra = session.beginTransaction();
            session.delete(category); // detele
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getAll());
    }
}