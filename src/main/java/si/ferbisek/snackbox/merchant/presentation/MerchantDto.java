package si.ferbisek.snackbox.merchant.presentation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MerchantDto {

    private Long id;

    String name;

    String description;
}
