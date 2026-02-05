package si.ferbisek.snackbox.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.ferbisek.snackbox.dto.CategoryDto;
import si.ferbisek.snackbox.entity.Category;
import si.ferbisek.snackbox.service.CategoryService;
import si.ferbisek.snackbox.mappers.CategoryMapper;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<CategoryDto> categories = categoryService.listCategories()
                .stream().map(categoryMapper::mapTo)
                .toList();

        return ResponseEntity.ok(categories);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        Optional<Category> foundCategory = categoryService.findById(id);

        return foundCategory.map(categoryEntity -> {
            CategoryDto categoryDto = categoryMapper.mapTo(categoryEntity);
            return ResponseEntity.ok(categoryDto);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CategoryDto> saveCategory(@Valid @RequestBody CategoryDto categoryDto) {
        Category categoryToCreate = categoryMapper.mapFrom(categoryDto);
        Category savedCategory = categoryService.save(categoryToCreate);

        return new ResponseEntity<>(categoryMapper.mapTo(savedCategory), HttpStatus.CREATED);
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDto categoryDto) {
        Category categoryToUpdate = categoryMapper.mapFrom(categoryDto);
        Category updatedCategory = categoryService.update(id, categoryToUpdate);

        return ResponseEntity.ok(categoryMapper.mapTo(updatedCategory));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
