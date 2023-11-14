package pl.nauczycielmontessori.shop.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsController(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    // Pobieranie wszystkich przedmiotów
    @GetMapping
    public List<Item> getAllItems() {
        return itemsRepository.findAll();
    }

    // Pobieranie informacji o konkretnym przedmiocie po ID
    @GetMapping("/{itemId}")
    public ModelAndView getItemDetails(@PathVariable Long itemId) {
        Item item = itemsRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + itemId));

        ModelAndView modelAndView = new ModelAndView("itemDetails");
        modelAndView.addObject("item", item);
        modelAndView.addObject("currencySymbol","$");
        return modelAndView;
    }

    // Dodawanie nowego przedmiotu
    @PostMapping
    public Item createItem(@RequestBody Item newItem) {
        return itemsRepository.save(newItem);
    }

    // Aktualizacja informacji o przedmiocie po ID
    @PutMapping("/{itemId}")
    public Item updateItem(@PathVariable Long itemId, @RequestBody Item updatedItem) {
        return itemsRepository.findById(itemId)
                .map(item -> {
                    item.setName(updatedItem.getName());
                    item.setDescription(updatedItem.getDescription());
                    item.setFileName(updatedItem.getFileName());
                    item.setActualPrice(updatedItem.getActualPrice());
                    item.setFormerPrice(updatedItem.getFormerPrice());
                    item.setSale(updatedItem.isSale());
                    item.setRating(updatedItem.getRating());
                    return itemsRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + itemId));
    }

    // Usuwanie przedmiotu po ID
    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {
        itemsRepository.deleteById(itemId);
    }
}