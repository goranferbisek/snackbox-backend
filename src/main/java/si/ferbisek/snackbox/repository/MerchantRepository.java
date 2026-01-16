package si.ferbisek.snackbox.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import si.ferbisek.snackbox.entity.Merchant;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant, Long>,
        PagingAndSortingRepository<Merchant, Long> {
}
