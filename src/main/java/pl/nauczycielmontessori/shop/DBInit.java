package pl.nauczycielmontessori.shop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.nauczycielmontessori.shop.item.Item;
import pl.nauczycielmontessori.shop.item.ItemType;
import pl.nauczycielmontessori.shop.item.ItemsRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Configuration
public class DBInit implements CommandLineRunner {

    private final ItemsRepository itemRepository;

    @Autowired
    public DBInit(ItemsRepository itemRepository ) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) {
        itemRepository.saveAll(List.of(
                new Item("Niebieska książka","To jest niebieska ładna książka", "https://images.unsplash.com/photo-1485989835538-fbc0f2f48014", BigDecimal.valueOf(10.50),BigDecimal.valueOf(10.50),false, 1, 100, LocalDate.of(2023,12,1), ItemType.MATHEMATICS),
                new Item("Czerwona książka","To jest czerwona ładna książka", "https://images.unsplash.com/photo-1485815217103-e1a6fc449a8d", BigDecimal.valueOf(18.20),BigDecimal.valueOf(19.00), true, 0, 10, LocalDate.of(2023,11,1), ItemType.CULTURE),
                new Item("Zielona książka","To jest zielona ładna książka", "https://images.unsplash.com/photo-1568945721873-6f1889039902", BigDecimal.valueOf(70.50),BigDecimal.valueOf(60.90), false, 10, 1000, LocalDate.of(2023,10,1), ItemType.EVERYDAY_LIFE)
                ));
    }
}