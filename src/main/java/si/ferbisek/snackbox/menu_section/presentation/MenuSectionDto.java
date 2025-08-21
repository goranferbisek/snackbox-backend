package si.ferbisek.snackbox.menu_section.presentation;

import lombok.*;
import si.ferbisek.snackbox.merchant.persistence.Merchant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuSectionDto {

    private Long id;

    private Merchant merchant;

    private String name;
}
