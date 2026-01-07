package si.ferbisek.snackbox.menu_section.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.ferbisek.snackbox.mappers.MenuSectionMapper;
import si.ferbisek.snackbox.menu_section.persistence.MenuSection;
import si.ferbisek.snackbox.menu_section.service.MenuSectionService;
import si.ferbisek.snackbox.merchant.service.MerchantService;

@RestController
@RequestMapping("/api/v1")
public class MenuSectionController {

    private final MenuSectionService menuSectionService;
    private final MerchantService merchantService;
    private final MenuSectionMapper menuSectionMapper;

    public MenuSectionController(MenuSectionService menuSectionService,
                                 MerchantService merchantService,
                                 MenuSectionMapper menuSectionMapper) {
        this.menuSectionService = menuSectionService;
        this.merchantService = merchantService;
        this.menuSectionMapper = menuSectionMapper;
    }

    @PostMapping(path = "/menu-sections")
    public ResponseEntity<MenuSectionDto> save(@RequestBody MenuSectionDto menuSection) {
        MenuSection menuSectionEntity = menuSectionMapper.mapFrom(menuSection);

        // TODO: find merchant based on user profile
        //Optional<Merchant> merchant = merchantService.findOne(merchantId);

        //if (merchant.isEmpty()) {
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}

        //menuSectionEntity.setMerchant(merchant.get());
        MenuSection savedEntity = menuSectionService.save(menuSectionEntity);
        return new ResponseEntity<>(menuSectionMapper.mapTo(savedEntity), HttpStatus.CREATED);
    }

}
