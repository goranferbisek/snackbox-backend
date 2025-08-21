package si.ferbisek.snackbox.merchant.presentation;

import lombok.*;
import si.ferbisek.snackbox.menu_section.persistence.MenuSection;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MerchantDto {

    private Long id;

    String name;

    String description;

    List<MenuSection> menuSections;
}
