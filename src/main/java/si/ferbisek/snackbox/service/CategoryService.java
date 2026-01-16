package si.ferbisek.snackbox.service;

import si.ferbisek.snackbox.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    List<Category> listCategories();

    void delete(Long id);
}
