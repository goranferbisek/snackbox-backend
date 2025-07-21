package si.ferbisek.snackbox.merchant.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import si.ferbisek.snackbox.merchant.persistence.MerchantEntity;
import si.ferbisek.snackbox.merchant.persistence.MerchantRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MerchantServiceImpl implements MerchantService {

    private MerchantRepository merchantRepository;

    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public MerchantEntity save(MerchantEntity merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public List<MerchantEntity> findAll() {
        return StreamSupport.stream(merchantRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Page<MerchantEntity> findAll(Pageable pageable) {
        return merchantRepository.findAll(pageable);
    }

    @Override
    public Optional<MerchantEntity> findOne(Long id) {
        return merchantRepository.findById(id);
    }

    @Override
    public boolean isExists(Long id) {
        return merchantRepository.existsById(id);
    }

    @Override
    public MerchantEntity partialUpdate(Long id, MerchantEntity merchantEntity) {
        merchantEntity.setId(id);

        return merchantRepository.findById(id).map(existingMerchant -> {
            Optional.ofNullable(merchantEntity.getName()).ifPresent(existingMerchant::setName);
            Optional.ofNullable(merchantEntity.getDescription()).ifPresent(existingMerchant::setDescription);
            return merchantRepository.save(existingMerchant);
        }).orElseThrow(() -> new RuntimeException("Merchant does not exist!"));
    }

    @Override
    public void delete(Long id) {
        merchantRepository.deleteById(id);
    }
}
