package si.ferbisek.snackbox.dto;

import jakarta.validation.constraints.*;
import lombok.*;

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

    @NotNull(message = "Set delivery fee")
    @PositiveOrZero(message = "Price must not be negative")
    @Digits(integer = 2, fraction = 2, message = "Delivery fee must have at most 5 integer digits and 2 decimal places")
    private BigDecimal deliveryFee;

    @NotNull(message = "You must choose a category")
    private Long categoryId;
}
