package pl.nauczycielmontessori.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.nauczycielmontessori.shop.item.ItemService;
import pl.nauczycielmontessori.shop.item.ItemType;

@Controller
public class ShopController {

    private final ItemService itemService;

    @Autowired
    public ShopController(ItemService itemService) {
        this.itemService = itemService;
    }



    @GetMapping("/shop")
    public String getItemsByType(@RequestParam(name = "type", required = false) String type, Model model) {
        String itemsTitle = "Wszystkie";
        if (type != null) {
            ItemType itemType = ItemType.valueOf(type);
            itemsTitle = itemType.getDisplayName();
            model.addAttribute("allItems", itemService.getItemsByType(itemType));
        } else {
            model.addAttribute("allItems", itemService.getAllItems());
        }
        model.addAttribute("currencySymbol",'$');
        model.addAttribute("itemsTitle",itemsTitle);

        return "shop";
    }
}
