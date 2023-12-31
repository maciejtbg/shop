package pl.nauczycielmontessori.shop.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ItemService {

    private final ItemsRepository itemRepository;

    @Autowired
    public ItemService(ItemsRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> getItemsByType(ItemType itemType) {
        return itemRepository.findByItemType(itemType);
    }

    public Item getItemById(Long id){
        return itemRepository.getReferenceById(id);
    }

    public List<Item> getItemsByDate(LocalDate localDate){
        return itemRepository.findItemsByReleaseDateAfterOrderByReleaseDate(localDate);
    }

    public List<Item> getByPopularity(int startingPopularity){
        return itemRepository.findItemsByPopularityGreaterThanOrderByPopularity(startingPopularity);
    }
}
