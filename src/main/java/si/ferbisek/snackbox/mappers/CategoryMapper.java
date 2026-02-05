package si.ferbisek.snackbox.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import si.ferbisek.snackbox.entity.Category;
import si.ferbisek.snackbox.dto.CategoryDto;

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
}
