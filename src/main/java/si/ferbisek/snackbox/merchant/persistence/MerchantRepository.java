package si.ferbisek.snackbox.merchant.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant, Long>,
        PagingAndSortingRepository<Merchant, Long> {
}
