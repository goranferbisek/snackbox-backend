package si.ferbisek.snackbox.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import si.ferbisek.snackbox.menu_section.persistence.MenuSection;
import si.ferbisek.snackbox.menu_section.presentation.MenuSectionDto;

@Component
public class MenuSectionMapper implements Mapper<MenuSection, MenuSectionDto> {

    private final ModelMapper modelMapper;

    public MenuSectionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MenuSectionDto mapTo(MenuSection menuSection) {
        return modelMapper.map(menuSection, MenuSectionDto.class);
    }

    @Override
    public MenuSection mapFrom(MenuSectionDto menuSectionDto) {
        return modelMapper.map(menuSectionDto, MenuSection.class);
    }
}
