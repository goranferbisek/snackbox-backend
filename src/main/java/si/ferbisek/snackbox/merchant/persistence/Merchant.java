package si.ferbisek.snackbox.merchant.persistence;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import si.ferbisek.snackbox.category.persistence.Category;
import si.ferbisek.snackbox.menu_section.persistence.MenuSection;
import si.ferbisek.snackbox.user.persistence.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "merchant")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToOne
    @JoinColumn(name = "owner_id", unique = true)
    private User owner;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<MenuSection> menuSections;

    @Column(name = "delivery_fee", nullable = false)
    private BigDecimal deliveryFee;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Merchant merchant = (Merchant) o;
        return Objects.equals(id, merchant.id) && Objects.equals(name, merchant.name) && Objects.equals(description, merchant.description) && Objects.equals(owner, merchant.owner) && Objects.equals(menuSections, merchant.menuSections) && Objects.equals(deliveryFee, merchant.deliveryFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, owner, menuSections, deliveryFee);
    }
}
