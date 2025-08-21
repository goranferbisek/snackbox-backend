package si.ferbisek.snackbox.menu_section.service;

import org.springframework.stereotype.Service;
import si.ferbisek.snackbox.menu_section.persistence.MenuSection;
import si.ferbisek.snackbox.menu_section.persistence.MenuSectionRepository;

@Service
public class MenuSectionServiceImpl implements MenuSectionService {

    MenuSectionRepository menuSectionRepository;

    public MenuSectionServiceImpl(MenuSectionRepository menuSectionRepository) {
        this.menuSectionRepository = menuSectionRepository;
    }

    @Override
    public MenuSection save(MenuSection menuSection) {
        return menuSection;
    }
}
