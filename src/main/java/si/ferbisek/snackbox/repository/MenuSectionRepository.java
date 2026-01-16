package si.ferbisek.snackbox.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import si.ferbisek.snackbox.entity.MenuSection;

@Repository
public interface MenuSectionRepository extends CrudRepository<MenuSection, Long> {
}
