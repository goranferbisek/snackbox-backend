package si.ferbisek.snackbox.merchant.service;

import si.ferbisek.snackbox.merchant.persistence.MerchantEntity;

import java.util.List;
import java.util.Optional;

public interface MerchantService {
    MerchantEntity create(MerchantEntity merchant);

    List<MerchantEntity> findAll();

    Optional<MerchantEntity> findOne(Long id);
}
