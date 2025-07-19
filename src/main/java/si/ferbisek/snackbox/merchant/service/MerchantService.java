package si.ferbisek.snackbox.merchant.service;

import si.ferbisek.snackbox.merchant.persistence.MerchantEntity;

public interface MerchantService {
    MerchantEntity create(MerchantEntity merchant);
}
