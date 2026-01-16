package si.ferbisek.snackbox.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import si.ferbisek.snackbox.entity.Category;
import si.ferbisek.snackbox.repository.CategoryRepository;
import si.ferbisek.snackbox.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Category save(Category category) {
        if (categoryRepository.existsByNameIgnoreCase(category.getName())) {
            throw new IllegalArgumentException("Category with name [" + category.getName() + "] already exists");
        }

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            if (!category.get().getMerchants().isEmpty()) {
                throw new IllegalStateException("Category has merchants associated with it");
            }
            categoryRepository.deleteById(id);
        }
    }
}
