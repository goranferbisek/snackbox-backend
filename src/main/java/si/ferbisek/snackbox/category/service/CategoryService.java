package si.ferbisek.snackbox.category.service;

import si.ferbisek.snackbox.category.persistence.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    List<Category> listCategories();
}
