package si.ferbisek.snackbox.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.ferbisek.snackbox.dto.CategoryDto;
import si.ferbisek.snackbox.dto.CreateCategoryRequest;
import si.ferbisek.snackbox.entity.Category;
import si.ferbisek.snackbox.service.CategoryService;
import si.ferbisek.snackbox.mappers.CategoryMapper;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<CategoryDto> save(@Valid @RequestBody CreateCategoryRequest categoryRequest) {
        Category categoryToCreate = categoryMapper.mapFrom(categoryRequest);
        Category savedCategory = categoryService.save(categoryToCreate);

        return new ResponseEntity<>(categoryMapper.mapTo(savedCategory), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
