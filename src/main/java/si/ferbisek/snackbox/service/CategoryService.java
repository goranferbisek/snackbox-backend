package si.ferbisek.snackbox.service;

import si.ferbisek.snackbox.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category save(Category category);
    List<Category> listCategories();
    Optional<Category> findById(Long id);
    Category update(Long id, Category category);
    void delete(Long id);
}
