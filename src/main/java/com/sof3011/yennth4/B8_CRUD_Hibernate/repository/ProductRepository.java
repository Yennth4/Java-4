package com.sof3011.yennth4.B8_CRUD_Hibernate.repository;

import com.sof3011.yennth4.B8_CRUD_Hibernate.entity.response.ProductResponse;
import com.sof3011.yennth4.B8_CRUD_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository {

    public Session session = HibernateUtil.getFACTORY().openSession();

    // Product ID , Product Name , Product Code , Category Name , CategoryCode , Price => tao 1 respon hung du lieu
    public List<ProductResponse> getAll() {
        String hql = "";
        List<ProductResponse> listProduct = session.createQuery("FROM Product").list();
        session.close();
        return listProduct;
    }

//    public boolean addProduct(Product product) {
//        Transaction transaction = null;
//        try() {
//
//        }
//    }

    public static void main(String[] args) {

    }
}
