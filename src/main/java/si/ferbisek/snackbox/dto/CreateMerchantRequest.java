package si.ferbisek.snackbox.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import si.ferbisek.snackbox.entity.Category;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between {min} and {max} characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 3, max = 500, message = "Description must be between {min} and {max} characters")
    private String description;

    @DecimalMin(message = "Define delivery fee", value = "0.00")
    private BigDecimal deliveryFee;

    @NotNull(message = "You must choose a category")
    private Category category;
}
