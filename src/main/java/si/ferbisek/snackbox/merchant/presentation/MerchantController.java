package si.ferbisek.snackbox.merchant.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.ferbisek.snackbox.mappers.Mapper;
import si.ferbisek.snackbox.merchant.persistence.MerchantEntity;
import si.ferbisek.snackbox.merchant.service.MerchantService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MerchantController {

    private MerchantService merchantService;

    private Mapper<MerchantEntity, MerchantDto> merchantMapper;

    public MerchantController(MerchantService merchantService, Mapper<MerchantEntity, MerchantDto> merchantMapper) {
        this.merchantService = merchantService;
        this.merchantMapper = merchantMapper;
    }

    @PostMapping(path = "/merchants")
    public ResponseEntity<MerchantDto> save(@RequestBody MerchantDto merchant) {
        MerchantEntity merchantEntity = merchantMapper.mapFrom(merchant);
        MerchantEntity savedEntity = merchantService.save(merchantEntity);
        return new ResponseEntity<>(merchantMapper.mapTo(savedEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/merchants")
    public List<MerchantDto> listMerchants() {
        List<MerchantEntity> merchants = merchantService.findAll();
        return merchants.stream()
                .map(merchantMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/merchants/{id}")
    public ResponseEntity<MerchantDto> findById(@PathVariable Long id) {
        Optional<MerchantEntity> foundMerchant = merchantService.findOne(id);

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
        MerchantEntity merchantEntity =  merchantMapper.mapFrom(merchant);
        MerchantEntity savedMerchantEntity =  merchantService.save(merchantEntity);
        return new ResponseEntity<>(merchantMapper.mapTo(savedMerchantEntity), HttpStatus.OK);
    }

    @PatchMapping(path = "/merchants/{id}")
    public ResponseEntity<MerchantDto> partialUpdate(@PathVariable Long id, @RequestBody MerchantDto merchant) {
        if (!merchantService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        MerchantEntity merchantEntity =  merchantMapper.mapFrom(merchant);
        MerchantEntity updatedMerchantEntity = merchantService.partialUpdate(id, merchantEntity);
        return new ResponseEntity<>(merchantMapper.mapTo(updatedMerchantEntity), HttpStatus.OK);
    }

    @DeleteMapping(path = "/merchants/{id}")
    public ResponseEntity<MerchantDto> deleteMerchant(@PathVariable Long id) {
        merchantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
