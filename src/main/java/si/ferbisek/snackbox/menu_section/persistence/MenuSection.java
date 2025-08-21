package si.ferbisek.snackbox.menu_section.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import si.ferbisek.snackbox.menu_item.peristence.MenuItem;
import si.ferbisek.snackbox.merchant.persistence.Merchant;

import java.util.ArrayList;
import java.util.List;

@Data //TODO: change to getter and setter to avoid looping - instead create equals() and hashcode() manually
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "menu_section")
public class MenuSection {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "merchant_id")
   @JsonBackReference
   private Merchant merchant;

   @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<MenuItem> items = new ArrayList<>();

}
