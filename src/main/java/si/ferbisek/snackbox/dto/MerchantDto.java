package si.ferbisek.snackbox.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MerchantDto {

    private Long id;

    private String name;

    private String description;

    private BigDecimal deliveryFee;

    List<MenuSectionDto> menuSections;
}
