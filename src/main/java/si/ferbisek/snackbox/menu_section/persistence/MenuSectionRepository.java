package si.ferbisek.snackbox.menu_section.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuSectionRepository extends CrudRepository<MenuSection, Long> {
}
