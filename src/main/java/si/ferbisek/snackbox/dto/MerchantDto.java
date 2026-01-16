package si.ferbisek.snackbox.dto;

import lombok.*;
import si.ferbisek.snackbox.entity.MenuSection;

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
