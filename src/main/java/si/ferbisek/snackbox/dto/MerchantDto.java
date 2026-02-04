package si.ferbisek.snackbox.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import si.ferbisek.snackbox.entity.MenuSection;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MerchantDto {

    private Long id;

    @NotBlank(message = "Description is required")
    @Size(min = 3, max = 50, message = "Category name must be between {min} and {max} characters")
    @Pattern(regexp = "^[\\w\\s-:]+$", message = "Category name can only contain letters, numbers and spaces")
    String name;

    @NotBlank(message = "Description is required")
    @Size(min = 3, max = 500, message = "Description must be between {min} and {max} characters")
    String description;

    List<MenuSection> menuSections;

    @DecimalMin(message = "Define delivery fee", value = "0.00")
    private BigDecimal deliveryFee;
}
