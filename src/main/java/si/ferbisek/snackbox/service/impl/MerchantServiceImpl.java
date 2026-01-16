package si.ferbisek.snackbox.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import si.ferbisek.snackbox.entity.Merchant;
import si.ferbisek.snackbox.repository.MerchantRepository;
import si.ferbisek.snackbox.service.MerchantService;

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
    public Merchant save(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public List<Merchant> findAll() {
        return StreamSupport.stream(merchantRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Merchant> findAll(Pageable pageable) {
        return merchantRepository.findAll(pageable);
    }

    @Override
    public Optional<Merchant> findOne(Long id) {
        return merchantRepository.findById(id);
    }

    @Override
    public boolean isExists(Long id) {
        return merchantRepository.existsById(id);
    }

    @Override
    public Merchant partialUpdate(Long id, Merchant merchant) {
        merchant.setId(id);

        return merchantRepository.findById(id).map(existingMerchant -> {
            Optional.ofNullable(merchant.getName()).ifPresent(existingMerchant::setName);
            Optional.ofNullable(merchant.getDescription()).ifPresent(existingMerchant::setDescription);
            return merchantRepository.save(existingMerchant);
        }).orElseThrow(() -> new RuntimeException("Merchant does not exist!"));
    }

    @Override
    public void delete(Long id) {
        merchantRepository.deleteById(id);
    }
}
