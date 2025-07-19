package si.ferbisek.snackbox.merchant.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import si.ferbisek.snackbox.mappers.Mapper;
import si.ferbisek.snackbox.merchant.persistence.MerchantEntity;
import si.ferbisek.snackbox.merchant.service.MerchantService;

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
        MerchantEntity savedEntity = merchantService.create(merchantEntity);
        return new ResponseEntity<>(merchantMapper.mapTo(savedEntity), HttpStatus.CREATED);
    }
}
