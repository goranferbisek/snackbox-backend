package si.ferbisek.snackbox.merchant.presentation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.ferbisek.snackbox.mappers.Mapper;
import si.ferbisek.snackbox.menu_section.persistence.MenuSection;
import si.ferbisek.snackbox.merchant.persistence.Merchant;
import si.ferbisek.snackbox.merchant.service.MerchantService;

import java.util.Optional;

@RestController
public class MerchantController {

    private final MerchantService merchantService;

    private final Mapper<Merchant, MerchantDto> merchantMapper;

    public MerchantController(MerchantService merchantService, Mapper<Merchant, MerchantDto> merchantMapper) {
        this.merchantService = merchantService;
        this.merchantMapper = merchantMapper;
    }

    @PostMapping(path = "/merchants")
    public ResponseEntity<MerchantDto> save(@RequestBody MerchantDto merchant) {
        Merchant merchantEntity = merchantMapper.mapFrom(merchant);

        if (merchant.getMenuSections() != null) {
            for  (MenuSection menuSection : merchant.getMenuSections()) {
                menuSection.setMerchant(merchantEntity);
            }
        }

        Merchant savedEntity = merchantService.save(merchantEntity);
        return new ResponseEntity<>(merchantMapper.mapTo(savedEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/merchants")
    public Page<MerchantDto> listMerchants(Pageable pageable) {
        Page<Merchant> merchants = merchantService.findAll(pageable);
        return merchants.map(merchantMapper::mapTo);
    }

    @GetMapping(path = "/merchants/{id}")
    public ResponseEntity<MerchantDto> findById(@PathVariable Long id) {
        Optional<Merchant> foundMerchant = merchantService.findOne(id);

        return foundMerchant.map(merchantEntity -> {
            MerchantDto merchantDto =  merchantMapper.mapTo(merchantEntity);
            return new ResponseEntity<>(merchantDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(path = "/merchants/{id}")
    public ResponseEntity<MerchantDto> fullUpdateMerchant(@PathVariable Long id, @RequestBody MerchantDto merchant) {
        if (!merchantService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        merchant.setId(id);
        Merchant merchantEntity =  merchantMapper.mapFrom(merchant);
        Merchant savedMerchant =  merchantService.save(merchantEntity);
        return new ResponseEntity<>(merchantMapper.mapTo(savedMerchant), HttpStatus.OK);
    }

    @PatchMapping(path = "/merchants/{id}")
    public ResponseEntity<MerchantDto> partialUpdate(@PathVariable Long id, @RequestBody MerchantDto merchant) {
        if (!merchantService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Merchant merchantEntity =  merchantMapper.mapFrom(merchant);
        Merchant updatedMerchant = merchantService.partialUpdate(id, merchantEntity);
        return new ResponseEntity<>(merchantMapper.mapTo(updatedMerchant), HttpStatus.OK);
    }

    @DeleteMapping(path = "/merchants/{id}")
    public ResponseEntity<MerchantDto> deleteMerchant(@PathVariable Long id) {
        merchantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
