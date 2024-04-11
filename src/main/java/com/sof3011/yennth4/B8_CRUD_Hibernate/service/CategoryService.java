package com.sof3011.yennth4.B8_CRUD_Hibernate.service;
import com.sof3011.yennth4.B8_CRUD_Hibernate.entity.Category;
import com.sof3011.yennth4.B8_CRUD_Hibernate.repository.CategoryRepository;

import java.util.List;

public class CategoryService {

    CategoryRepository repository = new CategoryRepository();

    public List<Category> getAll() {
        return repository.getAll();
    }

    public Category getOne(Long id) {
        return repository.getOne(id);
    }

    public boolean addCategory(Category category) {
        return repository.add(category);
    }

    public boolean updateCategory(Category category) {
        return repository.update(category);
    }

    public boolean deleteCategory(Category category) {
        return repository.delete(category);
    }

}
