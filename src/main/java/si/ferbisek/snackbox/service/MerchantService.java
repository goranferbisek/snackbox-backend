package si.ferbisek.snackbox.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import si.ferbisek.snackbox.entity.Merchant;

import java.util.List;
import java.util.Optional;

public interface MerchantService {
    Merchant save(Merchant merchant);

    List<Merchant> findAll();

    Page<Merchant> findAll(Pageable pageable);

    Optional<Merchant> findOne(Long id);

    boolean isExists(Long id);

    Merchant partialUpdate(Long id, Merchant merchant);

    void delete(Long id);
}
