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
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String fileName;
    private BigDecimal actualPrice;
    private BigDecimal formerPrice;
    private boolean sale;
    private float rating;

    public Item(String name, String description, String fileName, BigDecimal actualPrice, BigDecimal formerPrice, boolean sale, float rating) {
        this.name = name;
        this.description = description;
        this.fileName = fileName;
        this.actualPrice = actualPrice;
        this.formerPrice = formerPrice;
        this.sale = sale;
        this.rating = rating;
    }
}
