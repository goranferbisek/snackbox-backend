package si.ferbisek.snackbox.merchant.service;

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
    public MerchantEntity create(MerchantEntity merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public List<MerchantEntity> findAll() {
        return StreamSupport.stream(merchantRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MerchantEntity> findOne(Long id) {
        return merchantRepository.findById(id);
    }
}
