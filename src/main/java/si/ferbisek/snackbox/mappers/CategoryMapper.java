package si.ferbisek.snackbox.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import si.ferbisek.snackbox.category.persistence.Category;
import si.ferbisek.snackbox.category.presentation.CategoryDto;
import si.ferbisek.snackbox.category.presentation.CreateCategoryRequest;

@Component
public class CategoryMapper implements Mapper<Category, CategoryDto> {

    private final ModelMapper modelMapper;

    public CategoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto mapTo(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public Category mapFrom(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

    public Category mapFrom(CreateCategoryRequest createCategoryRequest) {
        return modelMapper.map(createCategoryRequest, Category.class);
    }
}
