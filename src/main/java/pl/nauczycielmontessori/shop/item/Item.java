package pl.nauczycielmontessori.shop.item;

import jakarta.persistence.*;
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
    private int rating;
//data publikacji

    @Enumerated(EnumType.ORDINAL)
    private ItemType itemType;

    public Item(String name, String description, String fileName, BigDecimal actualPrice, BigDecimal formerPrice, boolean sale, int rating, ItemType itemType) {
        this.name = name;
        this.description = description;
        this.fileName = fileName;
        this.actualPrice = actualPrice;
        this.formerPrice = formerPrice;
        this.sale = sale;
        this.rating = rating;
        this.itemType = itemType;
    }
}
