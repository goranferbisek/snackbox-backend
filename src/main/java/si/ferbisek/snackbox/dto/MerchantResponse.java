package si.ferbisek.snackbox.dto;

import lombok.*;
import si.ferbisek.snackbox.entity.Category;
import si.ferbisek.snackbox.entity.User;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MerchantResponse {

    private Long id;

    private String name;

    private String description;

    private BigDecimal deliveryFee;

    private Category category;

    private User owner;

}
