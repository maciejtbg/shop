package pl.nauczycielmontessori.shop.item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Items {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String fileName;
    private BigDecimal price;
    private float rating;

    public Items(String name, String description, String fileName, BigDecimal price, float rating) {
        this.name = name;
        this.description = description;
        this.fileName = fileName;
        this.price = price;
        this.rating = rating;
    }
}
