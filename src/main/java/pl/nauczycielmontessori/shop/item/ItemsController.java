package pl.nauczycielmontessori.shop.item;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    private final ItemsRepository itemsRepository;

    private final ItemService itemService;

    @Autowired
    public ItemsController(ItemsRepository itemsRepository, ItemService itemService) {
        this.itemsRepository = itemsRepository;
        this.itemService = itemService;
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

    @GetMapping("add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") Long itemId, HttpSession httpSession){
        List<Item> cart = (List<Item>) httpSession.getAttribute("cart");
        if (cart == null){
            cart = new ArrayList<Item>();
        }
        Item item = itemService.getItemById(itemId);
        cart.add(item);
        httpSession.setAttribute("cart",cart);
        return  httpSession.toString();
    }
}