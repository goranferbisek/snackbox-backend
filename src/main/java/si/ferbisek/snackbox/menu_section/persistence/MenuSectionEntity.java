package si.ferbisek.snackbox.menu_section.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import si.ferbisek.snackbox.merchant.persistence.MerchantEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "menu_section")
public class MenuSectionEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "merchant_id")
   @JsonBackReference
   private MerchantEntity merchant;

   private String name;
}
