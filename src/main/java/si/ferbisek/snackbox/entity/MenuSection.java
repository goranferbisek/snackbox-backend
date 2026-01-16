package si.ferbisek.snackbox.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
   @Builder.Default
   private List<MenuItem> items = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MenuSection that = (MenuSection) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(merchant, that.merchant) && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, merchant, items);
    }
}
