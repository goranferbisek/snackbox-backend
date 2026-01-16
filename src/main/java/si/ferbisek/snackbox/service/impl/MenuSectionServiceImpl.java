package si.ferbisek.snackbox.service.impl;

import org.springframework.stereotype.Service;
import si.ferbisek.snackbox.entity.MenuSection;
import si.ferbisek.snackbox.repository.MenuSectionRepository;
import si.ferbisek.snackbox.service.MenuSectionService;

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
