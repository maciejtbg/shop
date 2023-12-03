package pl.nauczycielmontessori.shop.item;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    private int popularity;
    private LocalDate releaseDate;

    @Enumerated(EnumType.ORDINAL)
    private ItemType itemType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!id.equals(item.id)) return false;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    public Item(String name, String description, String fileName, BigDecimal actualPrice, BigDecimal formerPrice, boolean sale, int rating, int popularity, LocalDate releaseDate, ItemType itemType) {
        this.name = name;
        this.description = description;
        this.fileName = fileName;
        this.actualPrice = actualPrice;
        this.formerPrice = formerPrice;
        this.sale = sale;
        this.rating = rating;
        this.popularity = popularity;
        this.releaseDate = releaseDate;
        this.itemType = itemType;
    }
}
