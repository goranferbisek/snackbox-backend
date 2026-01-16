package si.ferbisek.snackbox.dto;

import lombok.*;
import si.ferbisek.snackbox.entity.Merchant;

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
