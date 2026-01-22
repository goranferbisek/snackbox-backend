package si.ferbisek.snackbox.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import si.ferbisek.snackbox.entity.Category;
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

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Category name must be between {min} and {max} characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 3, max = 500, message = "Description must be between {min} and {max} characters")
    private String description;

    @DecimalMin(message = "Define delivery fee", value = "0.00")
    private BigDecimal deliveryFee;

    @NotNull(message = "You must choose a category")
    private Category category;

    private List<MenuSection> menuSections;
}
