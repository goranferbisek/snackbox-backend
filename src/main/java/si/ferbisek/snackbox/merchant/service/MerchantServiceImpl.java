package si.ferbisek.snackbox.merchant.service;

import org.springframework.stereotype.Service;
import si.ferbisek.snackbox.merchant.persistence.MerchantEntity;
import si.ferbisek.snackbox.merchant.persistence.MerchantRepository;

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
}
