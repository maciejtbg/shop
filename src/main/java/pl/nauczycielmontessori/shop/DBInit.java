package pl.nauczycielmontessori.shop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.nauczycielmontessori.shop.item.Items;
import pl.nauczycielmontessori.shop.item.ItemRepository;

import java.math.BigDecimal;
import java.util.List;


@Configuration
public class DBInit implements CommandLineRunner {

    private final ItemRepository itemRepository;

    @Autowired
    public DBInit(ItemRepository itemRepository ) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) {
        itemRepository.saveAll(List.of(
                new Items("Niebieska książka","To jest niebieska ładna książka", "https://images.unsplash.com/photo-1485989835538-fbc0f2f48014", BigDecimal.valueOf(10.50), 3.5f),
                new Items("Czerwona książka","To jest czerwona ładna książka", "https://images.unsplash.com/photo-1485815217103-e1a6fc449a8d", BigDecimal.valueOf(19.20), 4.9f),
                new Items("Zielona książka","To jest zielona ładna książka", "https://images.unsplash.com/photo-1568945721873-6f1889039902", BigDecimal.valueOf(60.90), 2.3f)
                ));
    }
}