package si.ferbisek.snackbox.merchant.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import si.ferbisek.snackbox.merchant.persistence.MerchantEntity;

import java.util.List;
import java.util.Optional;

public interface MerchantService {
    MerchantEntity save(MerchantEntity merchant);

    List<MerchantEntity> findAll();

    Page<MerchantEntity> findAll(Pageable pageable);

    Optional<MerchantEntity> findOne(Long id);

    boolean isExists(Long id);

    MerchantEntity partialUpdate(Long id, MerchantEntity merchantEntity);

    void delete(Long id);
}
